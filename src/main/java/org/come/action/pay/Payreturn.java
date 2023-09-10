package org.come.action.pay;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.ChannelHandlerContext;

import org.come.action.IAction;
import org.come.action.monitor.MonitorUtil;
import org.come.bean.ApplyBean;
import org.come.bean.ApplyPayBean;
import org.come.bean.LoginResult;
import org.come.bean.UseCardBean;
import org.come.entity.ExpensesReceipts;
import org.come.entity.Goodstable;
import org.come.entity.PayvipBean;
import org.come.entity.Record;
import org.come.entity.UserTable;
import org.come.handler.MainServerHandler;
import org.come.handler.SendMessage;
import org.come.protocol.Agreement;
import org.come.redis.RedisPoolUntil;
import org.come.server.GameServer;
import org.come.tool.WriteOut;
import org.come.until.APIHttpClient;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

import redis.clients.jedis.Jedis;
import come.tool.Role.PrivateData;
import come.tool.Role.RoleData;
import come.tool.Role.RolePool;
import come.tool.Scene.LaborDay.LaborScene;
import come.tool.Stall.AssetUpdate;

/**
 * 充值回调
 * 
 * @author zengr
 * 
 */
public class Payreturn implements IAction {

	@Override
	public void action(ChannelHandlerContext ctx1, String mes) {
		// TODO Auto-generated method stub
//		System.out.println("充值回调信息: " + mes);

		// System.out.println(mes);
		ExpensesReceipts expensesReceipts = GsonUtil.getGsonUtil().getgson().fromJson(mes, ExpensesReceipts.class);
		// 依据角色名去查询数据库的账号对应的quID
		try {
			String[] vs = expensesReceipts.getPlayeracc().split("\\|");
			expensesReceipts.setPlayeracc(vs[0]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		UserTable userTable = AllServiceUtil.getUserTableService().selectForUsername(expensesReceipts.getPlayeracc());
		Jedis jedis = RedisPoolUntil.getJedis();
		if (userTable == null || jedis.hget("order_number_control_orno", expensesReceipts.getErid() + "") != null) {
			if (jedis.hget("payReturnForpayServer", expensesReceipts.getErid() + "") != null) {
				String mes11[] = jedis.hget("payReturnForpayServer", expensesReceipts.getErid() + "").split("=");
				// 发送到数据处理处
				APIHttpClient.sendMes(mes11[0], mes11[1]);
			}
			// 归还连接资源
			RedisPoolUntil.returnResource(jedis);
			return;
		}
		Goodstable goodstable=null;
		if (expensesReceipts.getType()==5) {
			try {
				if (expensesReceipts.getGoodsid()!=null) {
					goodstable=AllServiceUtil.getGoodsTableService().getGoodsByRgID(expensesReceipts.getGoodsid());
					if (goodstable!=null) {
						boolean is=expensesReceipts.getRoleid()!=null&&goodstable.getRole_id().compareTo(expensesReceipts.getRoleid())==0;
						if (expensesReceipts.getRoleid()==null) {
							List<LoginResult> loginResults = AllServiceUtil.getUserTableService().findRoleByUserNameAndPassword(expensesReceipts.getPlayeracc(), null, null);
							for (int i = 0; i < loginResults.size(); i++) {if (loginResults.get(i).getRole_id().compareTo(goodstable.getRole_id())==0) {is=true;break;}}
						}
						if (is) {//享受折扣81281 1.1 81282 1.2 81283 1.3 81284 1.4 81285 1.5
							int sid=goodstable.getGoodsid().intValue();
							double xs=sid==81281?440:sid==81282?480:sid==81283?520:sid==81284?560:sid==81285?600:0;
							if (xs!=0) {
								expensesReceipts.setPlayerpay(new BigDecimal(expensesReceipts.getRecharge().doubleValue()*xs/100));
								expensesReceipts.setYuanbao(new BigDecimal(expensesReceipts.getRecharge().doubleValue()*xs));
								goodstable.goodxh(1);
					    		AllServiceUtil.getGoodsTableService().updateGoodRedis(goodstable);
					    		AllServiceUtil.getGoodsrecordService().insert(goodstable, null, 1, 9);//添加记录		
							}else {goodstable=null;}
						}else {goodstable=null;}
					}
				}
				if (goodstable==null) {AllServiceUtil.getRecordService().insert(new Record(0, "无法生效的折扣充值携带的物品ID:"+expensesReceipts.getGoodsid()));}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				WriteOut.addtxt("换算充值折扣报错:" + MainServerHandler.getErrorMessage(e), 9999);
			}finally{
				expensesReceipts.setType(0);
			}
		}
		expensesReceipts.setSid(userTable.getQid());
		try {
			ApplyBean applyBean = new ApplyBean();
			applyBean.setUserNameS(expensesReceipts.getPlayeracc());// 充值的帐户名
			applyBean.setRealmoney(expensesReceipts.getRecharge() + "");// 实际充值金额
			BigDecimal addC = new BigDecimal(applyBean.getRealmoney());
			int type = expensesReceipts.getType();
			// 支付类型 1仙玉充值 2周月卡充值 3小资冲级礼包充值 4土豪冲级礼包字段

			userTable.setPayintegration(userTable.getPayintegration() + addC.intValue());
			ChannelHandlerContext ctx = GameServer.getInlineUserNameMap().get(applyBean.getUserNameS());
			LoginResult login = ctx != null ? GameServer.getAllLoginRole().get(ctx) : null;
			if (login != null) {// 在线充值
				AllServiceUtil.getUserTableService().updateUser(userTable);
				login.setPaysum(login.getPaysum().add(addC));// 累计充值
				login.setDaypaysum(login.getDaypaysum().add(addC));// 每日累计充值
				LaborScene.addRankValue(0, addC.intValue(), login);//劳动节活动
				ApplyPayBean applyPayBean = new ApplyPayBean();
				applyPayBean.setAddM(addC);
				RoleData roleData = RolePool.getRoleData(login.getRole_id());
				PayvipBean vipBean = GameServer.getVIP(login.getPaysum().longValue());
				if (vipBean != null && roleData != null) {
					UseCardBean limit = roleData.getLimit("SVIP");
					if (limit == null) {
						limit = new UseCardBean("VIP" + vipBean.getGrade(), "SVIP", "S" + (19 + vipBean.getGrade()), -1, vipBean.getIncreationtext());
						roleData.addLimit(limit);
						applyPayBean.setVIPBean(limit);
					} else if (!limit.getName().equals("VIP" + vipBean.getGrade())) {
						limit.setName("VIP" + vipBean.getGrade());
						limit.setSkin("S" + (19 + vipBean.getGrade()));
						limit.setValue(vipBean.getIncreationtext());
						applyPayBean.setVIPBean(limit);
					}
				}
				if (type == 2) {
					long time = 0;
					if (expensesReceipts.getRecharge().intValue() == 30) {
						time = 1000L * 60L * 60L * 24L * 30L;
					} else if (expensesReceipts.getRecharge().intValue() == 10) {
						time = 1000L * 60L * 60L * 24L * 7L;
					} else if (expensesReceipts.getRecharge().intValue() == 1) {
						time = 1000L * 60L * 60L * 1L;
					}
					if (time != 0 && roleData != null) {
						UseCardBean limit = roleData.getLimit("VIP");
						if (limit != null) {
							limit.setTime(limit.getTime() + time);
						} else {
							// limit=new UseCardBean("VIP","VIP","1",
							// System.currentTimeMillis()+time,
							// "掉落率=1|经验加成=5|加强全系法术=5|召唤兽死亡不掉忠诚,血法|人物死亡惩罚减半|每天领取268仙玉");
							limit = new UseCardBean("VIP", "VIP", "1", System.currentTimeMillis() + time, "掉落率=1|经验加成=5|加强全系法术=5|召唤兽死亡不掉忠诚,血法|人物死亡惩罚减半");
							roleData.addLimit(limit);
						}
						applyPayBean.setUseCardBean(limit);
						applyPayBean.setMsg("激活了" + (time / 1000 / 60 / 60 / 24) + "天VIP特权");
					}
				} else if (type == 3 && login.getLowOrHihtpack() == 0) {
					login.setLowOrHihtpack(1);
					applyPayBean.setLowOrHihtpack(new BigDecimal(1));
					applyPayBean.setMsg("开通了小资冲级礼包");
				} else if (type == 4 && login.getLowOrHihtpack() == 0) {
					login.setLowOrHihtpack(2);
					applyPayBean.setLowOrHihtpack(new BigDecimal(2));
					applyPayBean.setMsg("开通了土豪冲级礼包");
				} else {
					applyBean.setPaymoney(expensesReceipts.getYuanbao() + "");// 充值的元宝数量
					login.setCodecard(login.getCodecard().add(new BigDecimal(applyBean.getPaymoney())));
					MonitorUtil.getMoney().addX(new BigDecimal(applyBean.getPaymoney()).longValue(), 0);
					MonitorUtil.getMoney().addC(addC.longValue());
					login.setMoney((login.getMoney() != null ? login.getMoney() : 0) + addC.intValue());
					applyPayBean.setAddX(new BigDecimal(applyBean.getPaymoney()));
					applyPayBean.setAddC(addC);
					if (addC.longValue() >= 30 && login.getDayfirstinorno() == 0) {// 在线充值
																					// 添加连充天数
						login.setDayandpayorno(login.getDayandpayorno().add(new BigDecimal(1)));
						login.setDayfirstinorno(1);
						applyPayBean.setDayandpayorno(login.getDayandpayorno());
					}
					StringBuffer buffer = new StringBuffer();
					if (type == 3 || type == 4) {
						buffer.append("小资冲级礼包和土豪冲级礼包只能同时拥有一个,你已经有了");
						buffer.append(login.getLowOrHihtpack() == 2 ? "土豪冲级礼包" : "小资冲级礼包");
						buffer.append("本次充值变为正常仙玉充值.");
					}
					buffer.append("你充值积分:");
					buffer.append(addC.intValue());
					buffer.append(",获得仙玉:");
					buffer.append(applyBean.getPaymoney());
					applyPayBean.setMsg(buffer.toString());
				}
				SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().applyPay(GsonUtil.getGsonUtil().getgson().toJson(applyPayBean)));
				// 确保第一次处理订单(确保充值成功)
				if (goodstable!=null) {
					AssetUpdate assetUpdate = new AssetUpdate(AssetUpdate.USEGOOD);
					assetUpdate.updata("G"+goodstable.getRgid()+"="+goodstable.getUsetime());
					assetUpdate.setMsg("你的"+goodstable.getGoodsname()+"发挥作用后消失了");
				    SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate)));
				}
			} else {// 不在线充值
				if (expensesReceipts.getRoleid() != null) {
					login = AllServiceUtil.getRoleTableService().selectRoleID(expensesReceipts.getRoleid());
				} else {
					List<LoginResult> loginResults = AllServiceUtil.getUserTableService().findRoleByUserNameAndPassword(applyBean.getUserNameS(), null, null);
					if (loginResults.size() != 0) {
						login = loginResults.get(0);
					}
				}
				if (login != null) {
					login.setPaysum(login.getPaysum().add(addC));// 累计充值
					login.setDaypaysum(login.getDaypaysum().add(addC));// 每日累计充值
					LaborScene.addRankValue(0, addC.intValue(), login);//劳动节活动
					if (type == 2) {
						long time = 0;
						if (expensesReceipts.getRecharge().intValue() == 30) {
							time = 1000L * 60L * 60L * 24L * 30L;
						} else if (expensesReceipts.getRecharge().intValue() == 10) {
							time = 1000L * 60L * 60L * 24L * 7L;
						} else if (expensesReceipts.getRecharge().intValue() == 1) {
							time = 1000L * 60L * 60L * 1L;
						}
						PrivateData privateData = new PrivateData();
						privateData.setTimingGood(login.getTimingGood());
						ConcurrentHashMap<String, UseCardBean> limitMap = privateData.initLimit(0);
						UseCardBean limit = limitMap.get("VIP");
						if (limit != null) {
							limit.setTime(limit.getTime() + time);
						} else {
							limit = new UseCardBean("VIP", "VIP", "1", System.currentTimeMillis() + time, "掉落率=1|经验加成=5|加强全系法术=5|召唤兽死亡不掉忠诚,血法|人物死亡惩罚减半|每天领取268仙玉");
							limitMap.put("VIP", limit);
						}
						StringBuffer buffer = new StringBuffer();
						for (UseCardBean cardBean : limitMap.values()) {
							if (buffer.length() != 0) {
								buffer.append("^");
							}
							buffer.append(cardBean.getName());
							buffer.append("#");
							buffer.append(cardBean.getType());
							buffer.append("#");
							buffer.append(cardBean.getSkin());
							buffer.append("#");
							buffer.append(cardBean.getTime() / 60000);
							if (cardBean.getValue() != null && !cardBean.getValue().equals("")) {
								buffer.append("#");
								buffer.append(cardBean.getValue());
							}
						}
						login.setTimingGood(buffer.toString());
					} else if (type == 3 && login.getLowOrHihtpack() == 0) {
						login.setLowOrHihtpack(1);
					} else if (type == 4 && login.getLowOrHihtpack() == 0) {
						login.setLowOrHihtpack(2);
					} else {
						applyBean.setPaymoney(expensesReceipts.getYuanbao() + "");// 充值的元宝数量
						login.setCodecard(login.getCodecard().add(new BigDecimal(applyBean.getPaymoney())));
						userTable.setCodecard(userTable.getCodecard().add(new BigDecimal(applyBean.getPaymoney())));
						userTable.setMoney(userTable.getMoney() + addC.intValue());
						MonitorUtil.getMoney().addX(new BigDecimal(applyBean.getPaymoney()).longValue(), 0);
						MonitorUtil.getMoney().addC(addC.longValue());
						if (addC.longValue() >= 30 && login.getDayfirstinorno() == 0) {// 在线充值
																						// 添加连充天数
							login.setDayandpayorno(login.getDayandpayorno().add(new BigDecimal(1)));
							login.setDayfirstinorno(1);
						}
					}
					try {
						AllServiceUtil.getRoleTableService().updateRoleWhenExit(login);
					} catch (Exception e) {
						// TODO: handle exception
						WriteOut.addtxt("人物数据保存报错:" + GsonUtil.getGsonUtil().getgson().toJson(login), 9999);
					}
				} else {
					userTable.setCodecard(userTable.getCodecard().add(new BigDecimal(applyBean.getPaymoney())));
					userTable.setMoney(userTable.getMoney() + addC.intValue());
					MonitorUtil.getMoney().addX(new BigDecimal(applyBean.getPaymoney()).longValue(), 0);
					MonitorUtil.getMoney().addC(addC.longValue());
				}
				AllServiceUtil.getUserTableService().updateUser(userTable);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			WriteOut.addtxt("充值报错:" + MainServerHandler.getErrorMessage(e), 9999);
		}
		RedisPoolUntil.returnResource(jedis);
		//充值日志
		AllServiceUtil.getRecordService().insert(new Record(7,mes));
	
	}
}
