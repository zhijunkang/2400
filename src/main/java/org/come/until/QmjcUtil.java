package org.come.until;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.come.action.lottery.LotteryRoleAction;
import org.come.action.monitor.MonitorUtil;
import org.come.bean.LoginResult;
import org.come.bean.NChatBean;
import org.come.bean.XXGDBean;
import org.come.entity.Goodstable;
import org.come.entity.Record;
import org.come.handler.SendMessage;
import org.come.model.LotteryData;
import org.come.model.LotteryRole;
import org.come.model.LotteryRoleRecord;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.tool.WriteOut;

import come.tool.Good.AddGoodAction;
import come.tool.Role.RoleData;
import come.tool.Role.RolePool;
import come.tool.Stall.AssetUpdate;
import io.netty.channel.ChannelHandlerContext;
/**
 * 全民竞猜
 * @author Administrator
 *
 */
public class QmjcUtil {
	public static List<LotteryRole> lotteryRoleList = new ArrayList<>();
	public static List<LotteryData> lotteryDataList = new ArrayList<>();
	public static List<LotteryRole> lotteryRoleRecordList = new ArrayList<>();
	
	public static String[] number= {"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
//	public static int[] number= {9};
	//计算竞猜结果
	public static Random random=new Random();
	//中奖人数
	public static int total= 0;
	//中奖总金额
	public static int totalMoney= 0;
	//中奖倍数
	public static int multiple = 50;
	
	public static void QmjcMan() {
		int mathMaxInt = 0;
		if(lotteryDataList.size()>0) {
			mathMaxInt = lotteryDataList.stream().mapToInt( LotteryData::getStage ).max().getAsInt(); //获取开奖期数
		}
		//开始抽奖
		//第一个号
		String num1 = number[random.nextInt(number.length)];
		//第二个号
		String num2 = number[random.nextInt(number.length)];
		//第三个号
		String num3 = number[random.nextInt(number.length)];
		
		int b = identical(num1,num2,num3);
		if(b == 2) {
			multiple = 100;
		}else if(b == 3){
			multiple = 1000;
		}
		//系统公告
		NChatBean beand=new NChatBean();
		beand.setId(5); 
		beand.setMessage("#R全民竞猜第#G【"+(mathMaxInt+1)+"】#R期开奖结果：#G【"+num1+num2+num3+"】");
		String msgk = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson(beand));
		SendMessage.sendMessageToAllRoles(msgk);
		
		//判断中奖发送奖励
		KJ(num1,num2,num3);
		
		
		//保存开奖数据
		LotteryData lotteryData = new LotteryData();
		lotteryData.setStage(mathMaxInt+1);
		lotteryData.setPrizeNumber(num1+num2+num3);
//		lotteryData.setTotal(lotteryRoleList.size());
		lotteryData.setTotal(total);
		lotteryData.setTotalMoney(totalMoney);
		
		lotteryDataList.add(lotteryData);
		//系统公告
		NChatBean bean=new NChatBean();
		bean.setId(5); 
		bean.setMessage("#R全民竞猜第#G【"+(mathMaxInt+1)+"】#R期开奖结果：#G【"+lotteryData.getPrizeNumber()+"】#R中奖数#Y【"+lotteryData.getTotal()+"】#R中奖总金额#Y【"+lotteryData.getTotalMoney()+"】");
		String msg = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson(bean));
		SendMessage.sendMessageToAllRoles(msg);
		if(lotteryRoleList.size()>0) {
			for(LotteryRole lotteryRole:lotteryRoleList) {
				LoginResult roleInfo = AllServiceUtil.getRoleTableService().selectRoleID(lotteryRole.getRole_id());
				LotteryRoleAction.refreshData(roleInfo);
			}
		}
		lotteryRoleList = new ArrayList<>();
		total = 0;
		totalMoney = 0;
	}
	public static void KJ(String num1,String num2,String num3) {
		if(lotteryRoleList.size()>0) {
			//所有参与者
			for(LotteryRole lotteryRole:lotteryRoleList) {
				//是否全中
				boolean PTQZ = false;
				int zj = 0;//判断中奖几个号
				boolean n1 = false;
				boolean n2 = false;
				boolean n3 = false;
				String[] rolenum = lotteryRole.getPrizeNumber().split("");
				
				
				String[] rolen = {rolenum[0],rolenum[1],rolenum[2]};
				//第一个号是否中奖
				List<String> rolent = new ArrayList<>();
				for(int i = 0; i<rolen.length;i++) {
					rolent.add(rolen[i]);
				}
				
				for(int i = 0; i<rolent.size();i++) {
					if(num1.equals(rolent.get(i))) {
						n1 = true;
						zj++;
						rolent.remove(i);
						break;
					}
				}
				//第二个号是否中奖
				for(int i = 0; i<rolent.size();i++) {
					if(num2.equals(rolent.get(i))) {
						n2 = true;
						zj++;
						rolent.remove(i);
						break;
					}
				}
				//第三个号是否中奖
				for(int i = 0; i<rolent.size();i++) {
					if(num3.equals(rolent.get(i))) {
						n3 =true;
						zj++;
					}
				}
				if(n1&&n2&&n3) {
					PTQZ = true;
				}
				
				//发奖励
				if(PTQZ) {
					LoginResult roleInfo = AllServiceUtil.getRoleTableService().selectRoleID(lotteryRole.getRole_id());
					total = total+1;
					totalMoney = totalMoney + lotteryRole.getMoney()*multiple;
					AssetUpdate assetUpdate = new AssetUpdate();
//					assetUpdate.setType(AssetUpdate.GIVE);
					assetUpdate.updata("D=" + lotteryRole.getMoney()*multiple);
					if(roleInfo != null) {
						sendReward(roleInfo, (lotteryRole.getMoney()*multiple)+"",lotteryRole.getStage());
						ChannelHandlerContext ctx1 = GameServer.getRoleNameMap().get(roleInfo.getRolename());
						SendMessage.sendMessageToSlef(ctx1, Agreement.getAgreement().PromptAgreement("恭喜您：本期中奖金额"+(lotteryRole.getMoney()*multiple)));
//						roleInfo.setGold(roleInfo.getGold().add(new BigDecimal(lotteryRole.getMoney()*multiple)));
//						MonitorUtil.getMoney().addD((long)lotteryRole.getMoney()*multiple, 3);
//						assetUpdate.setMsg("恭喜您：本期中奖金额"+lotteryRole.getMoney()*multiple);
//						SendMessage.sendMessageToSlef(ctx1, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate)));
						NChatBean bean=new NChatBean();
						bean.setId(5); 
						bean.setMessage("#R恭喜玩家#Y【"+roleInfo.getRolename()+"】在全民竞猜第#G【"+lotteryRole.getStage()+"】#G期获得#Y"+(lotteryRole.getMoney()*multiple)+"两银子真是可喜可贺！！！");
						String msg = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson(bean));
						SendMessage.sendMessageToAllRoles(msg);
					}
//					else {
//					    BigDecimal gold = AllServiceUtil.getRoleTableService().selectMoneyRoleID(lotteryRole.getRole_id());
//					    gold=gold.add(new BigDecimal(lotteryRole.getMoney()*multiple));
//					    if(gold.compareTo(new BigDecimal("9999999999")) > 0){
//							gold=new BigDecimal("9999999999");
//					    }
//					    AllServiceUtil.getRoleTableService().updateMoneyRoleID(lotteryRole.getRole_id(),gold);
//				    }
				}else if(zj>0){
					if(zj == 1) {
						LoginResult roleInfo = AllServiceUtil.getRoleTableService().selectRoleID(lotteryRole.getRole_id());
						int zjm = lotteryRole.getMoney()/2;
						total = total+1;
						totalMoney = totalMoney + zjm;
//						AssetUpdate assetUpdate = new AssetUpdate();
////						assetUpdate.setType(AssetUpdate.GIVE);
//						assetUpdate.updata("D=" + zjm);
//						MonitorUtil.getMoney().addD((long)zjm, 3);
						if (roleInfo!=null) {
							sendReward(roleInfo, zjm+"",lotteryRole.getStage());
							ChannelHandlerContext ctx1 = GameServer.getRoleNameMap().get(roleInfo.getRolename());
//							roleInfo.setGold(new BigDecimal(roleInfo.getGold().longValue()+zjm));
//						    SendMessage.sendMessageToSlef(ctx1,Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate)));  
						    SendMessage.sendMessageToSlef(ctx1, Agreement.getAgreement().PromptAgreement("恭喜您：本期中奖金额"+zjm));
					    } 
//						else {
//						    BigDecimal gold = AllServiceUtil.getRoleTableService().selectMoneyRoleID(lotteryRole.getRole_id());
//						    gold=gold.add(new BigDecimal(zjm));
//						    if(gold.compareTo(new BigDecimal("9999999999")) > 0){
//								gold=new BigDecimal("9999999999");
//						    }
//						    AllServiceUtil.getRoleTableService().updateMoneyRoleID(lotteryRole.getRole_id(),gold);
//					    }	
					}else if(zj == 2) {
						LoginResult roleInfo = AllServiceUtil.getRoleTableService().selectRoleID(lotteryRole.getRole_id());
						total = total+1;
						totalMoney = totalMoney + lotteryRole.getMoney();
//						AssetUpdate assetUpdate = new AssetUpdate();
//						assetUpdate.setType(AssetUpdate.GIVE);
//						assetUpdate.updata("D=" + lotteryRole.getMoney());
						if (roleInfo!=null) {
							sendReward(roleInfo, lotteryRole.getMoney()+"",lotteryRole.getStage());
							ChannelHandlerContext ctx1 = GameServer.getRoleNameMap().get(roleInfo.getRolename());
//							roleInfo.setGold(roleInfo.getGold().add(new BigDecimal(lotteryRole.getMoney())));
//							MonitorUtil.getMoney().addD((long)lotteryRole.getMoney(), 3);
//							SendMessage.sendMessageToSlef(ctx1, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate)));
							SendMessage.sendMessageToSlef(ctx1, Agreement.getAgreement().PromptAgreement("恭喜您：本期中奖金额"+lotteryRole.getMoney()));
						} 
//						else {
//						    BigDecimal gold = AllServiceUtil.getRoleTableService().selectMoneyRoleID(lotteryRole.getRole_id());
//						    gold=gold.add(new BigDecimal(lotteryRole.getMoney()));
//						    if(gold.compareTo(new BigDecimal("9999999999")) > 0){
//								gold=new BigDecimal("9999999999");
//						    }
//						    AllServiceUtil.getRoleTableService().updateMoneyRoleID(lotteryRole.getRole_id(),gold);
//					    }
					}
				}else {
					LoginResult roleInfo = AllServiceUtil.getRoleTableService().selectRoleID(lotteryRole.getRole_id());
					if (roleInfo!=null) {
						ChannelHandlerContext ctx1 = GameServer.getRoleNameMap().get(roleInfo.getRolename());
						SendMessage.sendMessageToSlef(ctx1, Agreement.getAgreement().PromptAgreement("很遗憾您未能猜中！"));
					}
				}
				for(LotteryRole roleRecord : lotteryRoleRecordList) {
					if(roleRecord.getStage() == lotteryRole.getStage() && roleRecord.getPrizeNumber().equals(lotteryRole.getPrizeNumber())) {
						if(zj>0 || PTQZ) {
							roleRecord.setIfWin("已中奖");
						}else {
							roleRecord.setIfWin("未中奖");
						}
					}
				}
			}
		}
	}
	
	//判断倍数
	public static int identical(String num1,String num2,String num3) {
		if(num1.equals(num2) && num2.equals(num3)) {
			return 3;
		}else if(num1.equals(num2) || num2.equals(num3) || num1.equals(num3)) {
			return 2;
		}
		return 0;
	}
	

	
	/**发送获得奖励的银票*/
	public static boolean sendReward(LoginResult loginResult,String money,int num){
		String ab = ":25|9924517|1|#SDFSDFSD4WDFSGSDFERTDF454512";
//		String msgs = "全民竞猜第";
		ChannelHandlerContext ctx=GameServer.getRoleNameMap().get(loginResult.getRolename());
		XXGDBean bean=new XXGDBean();
		bean.setId("9924517");
		bean.setSum(1);
		RoleData roleData=RolePool.getRoleData(loginResult.getRole_id());
		AssetUpdate assetUpdate=new AssetUpdate(25);
		BigDecimal id=new BigDecimal(bean.getId());
		Goodstable goodstable = GameServer.getGood(id);
		//特效物品判断是拥有特效
		if( goodstable == null ){return true;}
		goodstable.setGoodsname("全民竞猜金票");
		goodstable.setInstruction("#Y全民竞猜金票第#G【"+num+"】#Y期中奖获得，右击使用获得对应的银两！");
		goodstable.setSkin("9036");
		goodstable.setValue("钱="+money);
		StringBuffer buffer=new StringBuffer();
		buffer.append("全民竞猜中奖金票:");
		buffer.append(id);
		buffer.append(",");
		buffer.append(bean.getSum()+"个"+goodstable.getGoodsname());
		buffer.append(",玩家:");
		buffer.append(loginResult.getRole_id());
		buffer.append("_");
		buffer.append(loginResult.getRolename());
		AllServiceUtil.getRecordService().insert(new Record(4,buffer.toString()));
		
		AddGoodAction.addGood(assetUpdate,goodstable,loginResult,roleData,bean,assetUpdate.getType());
		SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate)));  		
		String msg="dh:"+ab+(loginResult!=null?loginResult.getRole_id():null);
		WriteOut.addtxt(msg,9999);
		return true;
	}
	
	
}
