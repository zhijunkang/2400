package org.come.action.lottery;

import java.math.BigDecimal;

import org.come.action.IAction;
import org.come.bean.LoginResult;
import org.come.handler.SendMessage;
import org.come.model.LotteryData;
import org.come.model.LotteryRole;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.until.QmjcUtil;

import io.netty.channel.ChannelHandlerContext;
/**
 * 全民竞猜
 * @author Administrator
 *
 */
public class LotteryRoleAction implements IAction {

	public static String CHECKTS1=Agreement.getAgreement().PromptAgreement("购买成功！请等待开奖！");
	
	public static String CHECKTS2=Agreement.getAgreement().PromptAgreement("每期");
	public static String CHECKTS4=Agreement.getAgreement().PromptAgreement("你未有资格领取");
	public static String CHECKTS5=Agreement.getAgreement().PromptAgreement("你已经领取");
	
	@Override
	public void action(ChannelHandlerContext ctx, String message) {
		LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);
		// TODO Auto-generated method stub
		if (message.startsWith("QMJC")) {
			setData(ctx,message);
		}
		if(message.startsWith("QPEN")) {
			refreshData(loginResult);
			roleRecord(loginResult);
		}
	}
	
	
    /**储存竞猜数据的方法*/
	public void setData(ChannelHandlerContext ctx,String message){
		int mathMaxInt = 0;
		if(QmjcUtil.lotteryDataList.size()>0) {
			mathMaxInt = QmjcUtil.lotteryDataList.stream().mapToInt( LotteryData::getStage ).max().getAsInt(); //获取开奖期数
		}
		if (message==null || message.equals("")) {
			SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("请选择要购买的生肖，并且输入金额！"));
			return;
		}
		LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);
		LotteryRole lotteryRole = new LotteryRole();
		String msg = message.split("=")[1];
		String[] m = msg.split("\\|");
		lotteryRole.setPrizeNumber(m[0]);
		lotteryRole.setMoney(Integer.parseInt(m[1]));
		lotteryRole.setRole_id(loginResult.getRole_id());
		lotteryRole.setStage(mathMaxInt+1);
		QmjcUtil.lotteryRoleList.add(lotteryRole);
		lotteryRole.setIfWin("未开奖");
		QmjcUtil.lotteryRoleRecordList.add(lotteryRole);
		SendMessage.sendMessageToSlef(ctx,CHECKTS1);
		roleRecord(loginResult);
	}
	
	
	public static void refreshData(LoginResult loginResult) {
		String msgd = "";
		if(QmjcUtil.lotteryDataList.size()>0) {
			int j = 0;
			if(QmjcUtil.lotteryDataList.size()>3) {
				j = QmjcUtil.lotteryDataList.size()-3;
			}
			for(int i = j;i<QmjcUtil.lotteryDataList.size();i++) {
				msgd = msgd+"第["+(QmjcUtil.lotteryDataList.get(i).getStage())+"]期 开奖结果["+QmjcUtil.lotteryDataList.get(i).getPrizeNumber()+"] 中奖["+QmjcUtil.lotteryDataList.get(i).getTotal()+"] 中奖金额["+QmjcUtil.lotteryDataList.get(i).getTotalMoney()+"],";
			}
		}
		String msg = Agreement.getAgreement().LotteryCPAgreement("QPEN=" + msgd);
		SendMessage.sendMessageByRoleName(loginResult.getRolename(), msg);
	}
	
	
	
	public static void roleRecord(LoginResult loginResult) {
		String msgd = ""; 
		if(QmjcUtil.lotteryRoleRecordList.size()>0) {
			for(int i = 0;i<QmjcUtil.lotteryRoleRecordList.size();i++) {
				
				if(QmjcUtil.lotteryRoleRecordList.get(i).getRole_id().compareTo(loginResult.getRole_id()) == 0) {
					msgd = msgd+QmjcUtil.lotteryRoleRecordList.get(i).getStage()+"期,"+QmjcUtil.lotteryRoleRecordList.get(i).getPrizeNumber()+","+QmjcUtil.lotteryRoleRecordList.get(i).getIfWin()+"|";
				}
			}
		}
		String msg = Agreement.getAgreement().LotteryCPAgreement("RECORD=" + msgd);
		SendMessage.sendMessageByRoleName(loginResult.getRolename(), msg);
	}
	
	
	
}
