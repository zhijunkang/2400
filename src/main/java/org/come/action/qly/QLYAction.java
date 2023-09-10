package org.come.action.qly;

import io.netty.channel.ChannelHandlerContext;
import org.come.action.IAction;
import org.come.action.monitor.MonitorUtil;
import org.come.bean.LoginResult;
import org.come.handler.SendMessage;
import org.come.model.Gamemap;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class QLYAction implements IAction {

    @Override
    public void action(ChannelHandlerContext ctx, String message) {

        LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);
        BigDecimal money = new BigDecimal(1000000);
        //金钱不足
        if (loginResult.getGold().compareTo(money) < 0) {
            SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("小兄弟，想用我的眼睛#24多准备点钱#32"));
            return;
        }
        //扣除费用
        loginResult.setGold(loginResult.getGold().subtract(money));
        MonitorUtil.getMoney().useD(money.longValue());

        Pattern digit = Pattern.compile("\\d+");
        if (digit.matcher(message).matches()) {
            LoginResult role = AllServiceUtil.getRoleTableService().selectRoleByRoleId(new BigDecimal(message));
            ChannelHandlerContext channelHandlerContext = GameServer.getRoleNameMap().get(role.getRolename());
            if(channelHandlerContext == null){
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("小兄弟，三界内没有看到此人的踪影！"));
                return;
            }else{
                LoginResult roleInfo = GameServer.getAllLoginRole().get(channelHandlerContext);
                Gamemap map = GameServer.getMap(roleInfo.getMapid().toString());
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("小兄弟，你查找的人出现在：#G"+ map.getMapname()+"("+ (roleInfo.getX()/20) + "," + (roleInfo.getY()/20) + ")"));
                SendMessage.sendMessageToSlef(channelHandlerContext, Agreement.getAgreement().PromptAgreement("#R一阵阴风吹过，你感觉后背发凉#24"));
                return;
            }
        }

    }

}

