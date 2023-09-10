package org.come.action.sys;

import io.netty.channel.ChannelHandlerContext;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

import org.come.action.IAction;
import org.come.action.monitor.MonitorUtil;
import org.come.bean.LoginResult;
import org.come.handler.SendMessage;
import org.come.model.Configure;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.until.GsonUtil;

import come.tool.Good.ExpUtil;
import come.tool.Stall.AssetUpdate;

public class expAddAction implements IAction{

	@Override
	public void action(ChannelHandlerContext ctx, String message) {
		// TODO Auto-generated method stub
		LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);

		//金币泡点
		if(message.split("=")[0].equals("expAddJ")) {
			AssetUpdate assetUpdate=null;
			StringBuffer buffer=new StringBuffer();
			Long exp = Long.parseLong(message.split("=")[1]);
			
			if (assetUpdate==null) {assetUpdate=new AssetUpdate(25);}
			ExpUtil.RoleExp(loginResult,exp);
			Long zjy = Long.parseLong(loginResult.getExperience().toString())+exp;
			assetUpdate.updata("R"+loginResult.getGrade()+"="+zjy+"="+loginResult.getHp()+"="+loginResult.getMp());
	    	if (buffer.length()!=0) {buffer.append("|");}
	    	
			buffer.append("你获得经验#G");
			buffer.append(exp);
			assetUpdate.setMsg(buffer.toString());
			SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate))); 
		} else 
		//仙玉泡点
		if(message.split("=")[0].equals("expAddY")) {
			
			long xh=Long.parseLong(message.split("=")[2]);
            if (xh > loginResult.getCodecard().longValue()) {
            	SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().PromptAgreement("你仙玉不足"+xh));
				return;
			}
//			AssetUpdate assetUpdate1=null;
//			StringBuffer buffer1=new StringBuffer();
//			assetUpdate1.setData("X=" + (xh));
//			MonitorUtil.getMoney().useX(xh);
//			loginResult.setCodecard(loginResult.getCodecard().add(new BigDecimal(-xh)));
//			if (buffer1.length()!=0) {buffer1.append("|");}
//			buffer1.append("花费仙玉#G");
//			buffer1.append(xh);
//			assetUpdate1.setMsg(buffer1.toString());
//			SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate1)));
			
//            MonitorUtil.getMoney().useX(xh);
			AssetUpdate assetUpdate=null;
			StringBuffer buffer=new StringBuffer();
			Long exp = Long.parseLong(message.split("=")[1]);
			if (assetUpdate==null) {assetUpdate=new AssetUpdate(25);}
			ExpUtil.RoleExp(loginResult,exp);
			assetUpdate.setData("X=" + (-xh));
			Long zjy = Long.parseLong(loginResult.getExperience().toString())+exp;
			assetUpdate.updata("R"+loginResult.getGrade()+"="+zjy+"="+loginResult.getHp()+"="+loginResult.getMp());
	    	if (buffer.length()!=0) {buffer.append("|");}
	    	loginResult.setCodecard(new BigDecimal((loginResult.getCodecard().longValue()-xh)));
			buffer.append("花费【#G"+xh+"#Y】仙玉，获得经验#G");
			buffer.append(exp);
			assetUpdate.setMsg(buffer.toString());
			SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate))); 
		} else 
		//激情泡点  免费
		if(message.split("=")[0].equals("expAddM")) {
			AssetUpdate assetUpdate=null;
			StringBuffer buffer=new StringBuffer();
			Long exp = Long.parseLong(message.split("=")[1]);
			
			if (assetUpdate==null) {assetUpdate=new AssetUpdate(25);}
			ExpUtil.RoleExp(loginResult,exp);
			Long zjy = Long.parseLong(loginResult.getExperience().toString())+exp;
			assetUpdate.updata("R"+loginResult.getGrade()+"="+zjy+"="+loginResult.getHp()+"="+loginResult.getMp());
	    	if (buffer.length()!=0) {buffer.append("|");}
			buffer.append("你获得经验#G");
			buffer.append(exp);
			assetUpdate.setMsg(buffer.toString());
			SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate))); 
		}
	}
}
