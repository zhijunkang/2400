package org.come.gmshop;

import org.come.action.IAction;
import org.come.bean.LoginResult;
import org.come.handler.SendMessage;
import org.come.protocol.Agreement;
import org.come.server.GameServer;

import com.gl.service.PlayerService;

import come.tool.Good.DropUtil;
import io.netty.channel.ChannelHandlerContext;
/**
 * 兑换码兑换物品
 * @author Administrator
 */
public class GMshopItemAction implements IAction {
	
	PlayerService playerService;
	static String CHECKTS1=Agreement.getAgreement().PromptAgreement("获得");
	static String CHECKTS2=Agreement.getAgreement().PromptAgreement("特权等级不够请联系群主升级！");
	@Override
	public synchronized void action(ChannelHandlerContext ctx, String message) {
		// 获得用户信息
		LoginResult roleInfo = GameServer.getAllLoginRole().get(ctx);
		String[] sm = message.split(",");
		String mes = sm[0]+"|"+sm[1];
		String msg = ":25|"+mes+"|#SDFSDFSD4WDFSGSDFERTDF454512";
		//判断刷物资
		if (DropUtil.isDH(msg, roleInfo)) {
			SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().PromptAgreement("获得："+sm[2]+"*"+sm[1]));
			return;
		}
	}

}
