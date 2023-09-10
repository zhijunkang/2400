package org.come.action.qiandao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.come.action.IAction;
import org.come.bean.LoginResult;
import org.come.entity.Goodstable;
import org.come.handler.SendMessage;
import org.come.model.QianDao;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

import come.tool.Good.ExpUtil;
import come.tool.Stall.AssetUpdate;
import io.netty.channel.ChannelHandlerContext;

public class QianDaoAction implements IAction {

    @Override
    public void action(ChannelHandlerContext ctx, String message) {
        LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);
        //打开
        if (message.contains("open"))
        {
            //返回 签到信息
            String qianDao = loginResult.getQianDao();
            if (StringUtils.isBlank(qianDao))
            {
                loginResult.setQianDao("ED=&LQ=");
            }
            String msg = Agreement.getAgreement().QDAgreement("open=" + loginResult.getQianDao());
            SendMessage.sendMessageByRoleName(loginResult.getRolename(), msg);
            return;
        }
        //签到
        if (message.contains("qd"))
        {
                        Integer dayOfMonth = LocalDate.now().getDayOfMonth();
            //非首次签到
            HashSet<Integer> ed = loginResult.getQianDaoObject().getEd();
            if (ed.contains(dayOfMonth))
            {
                String msg = Agreement.getAgreement().QDAgreement("qd=fail&#24 少侠,您今天已经签到过了！！！");
                SendMessage.sendMessageByRoleName(loginResult.getRolename(), msg);
                
            }
            else
            {
            	Long jy = 5000L;
            	if(loginResult.getGrade()!=null && loginResult.getGrade()!=0) {
            		jy = 5000*Long.parseLong(loginResult.getGrade().toString());
            	}
                exp(loginResult, jy);
                ed.add(dayOfMonth);
                loginResult.getQianDaoObject().setEd(ed);
                loginResult.saveQiandao();
                String msg = Agreement.getAgreement().QDAgreement("qd=succ&" + dayOfMonth);
                SendMessage.sendMessageByRoleName(loginResult.getRolename(), msg);
                 if (loginResult.getQianDaoObject().getEd().size()==getCurrentMonthDay()){
                     //给30天签到奖励
                     giveGoodByType(ctx,loginResult,32);
                 }
            }
            return;
        }
        
        if (message.contains("select"))
        {
            
            //领取
            String[] split = message.split("=");
            int lqGoodType = Integer.parseInt(split[1]);
            HashSet<Integer> lq = loginResult.getQianDaoObject().getLq();
            String mes;
            if (loginResult.getQianDaoObject().getEd().size() < lqGoodType)
            {
                mes = "select=fail&#24 少侠,请签到达到" + lqGoodType + "天时再领取" + lqGoodType + "天奖励！！！";
            }
            else if (lq.contains(lqGoodType))
            {
                mes = "select=fail&#24 少侠,该奖励已经领取过了！！！";
            }
            else
            {
                //如果可以领取
                giveGoodByType(ctx,loginResult,lqGoodType);
                //同时更新领取数
                lq.add(lqGoodType);
                loginResult.getQianDaoObject().setLq(lq);
                loginResult.saveQiandao();
                mes = "select=succ&" + lqGoodType;
            }
            
            String msg = Agreement.getAgreement().QDAgreement(mes);
            SendMessage.sendMessageByRoleName(loginResult.getRolename(), msg);
        }
        
    }

    private void giveGoodByType(ChannelHandlerContext ctx, LoginResult loginResult, int lqGoodType) {
    	
    	
    	QianDao qianDao1 = GameServer.getQianDaoMap().get(lqGoodType);
    	System.out.println(qianDao1.getDay());
        QianDao qianDao = GameServer.getQianDaoMap().values().stream().collect(Collectors.groupingBy(QianDao::getDay)).get(lqGoodType).get(0);
        String[] v = qianDao.getGoods().split("=")[1].split("&");
        for (int j = 0; j < v.length; j++)
        {
            AssetUpdate assetUpdate = new AssetUpdate(AssetUpdate.USEGOOD);
            String[] v4 = v[j].split("\\$");
            BigDecimal id = new BigDecimal(v4[0]);
            int sum = Integer.parseInt(v4[1]);
            Goodstable good = GameServer.getGood(id);
            if (good == null)
            {
                continue;
            }
            good.setRole_id(loginResult.getRole_id());
            good.setGoodsname(good.getGoodsname());
            good.setUsetime(sum);
            good.setValue(good.getValue());
            good.setType(good.getType());
            good.setInstruction(good.getInstruction());
            assetUpdate.setMsg("恭喜你，签到获取 " + good.getGoodsname() + sum + "个");
            assetUpdate.setType(100);
            assetUpdate.setGood(good);
            AllServiceUtil.getGoodsTableService().insertGoods(good);
            SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate)));
        }
    }

    public static void exp(LoginResult loginResult, Long value)
    {
        ChannelHandlerContext ctx = GameServer.getRoleNameMap().get(loginResult.getRolename());
        AssetUpdate assetUpdate = new AssetUpdate(25);
        ExpUtil.RoleExp(loginResult, value);
        assetUpdate.updata("R" + loginResult.getGrade() + "=" + loginResult.getExperience() + "=" + loginResult.getHp() + "=" + loginResult.getMp());
        StringBuffer buffer = new StringBuffer();
        buffer.append("本日签到成功！！！！！ 恭喜少侠获得经验 #89");
        buffer.append(value);
        assetUpdate.setMsg(buffer.toString());
        SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate)));
    }
    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();

        a.set(Calendar.DATE, 1);

        a.roll(Calendar.DATE, -1);

        int maxDate = a.get(Calendar.DATE);

        return maxDate;

    }
}
