package org.come.action.vip;

import io.netty.channel.ChannelHandlerContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.come.action.IAction;
import org.come.entity.ChongjipackBean;
import org.come.handler.SendMessage;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.until.GsonUtil;

/** 每日特惠 */
public class DayForOneGetAction implements IAction {
	private final Log log = LogFactory.getLog(this.getClass());

	@Override
	public void action(ChannelHandlerContext ctx, String message) {
		this.log.info("每日特惠，获取每日特惠信息：" + GameServer.getPackgradecontrol().size());
		// 三端 每日特惠列表
		List<ChongjipackBean> chongjipack = GameServer.getPackgradecontrol().get(6);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(d);
		this.log.info("每日特惠，获取每日特惠信息 chongjipack.size() ：" + chongjipack.size());
		for (int i = 0; i < chongjipack.size(); i++) {
			this.log.info("每日特惠，获取每日特惠信息规定释放日期：" + chongjipack.get(i).getHuitime());
			if (format.equals(chongjipack.get(i).getHuitime())) {
				// 将信息返回给前端
				this.log.info("每日特惠，发送每日特惠信息 明文信息 ：" + GsonUtil.getGsonUtil().getgson().toJson(chongjipack.get(i)));
				String sendmes = Agreement.getAgreement().DayforonegetAgreement(GsonUtil.getGsonUtil().getgson().toJson(chongjipack.get(i)));
				this.log.info("每日特惠，发送每日特惠信息 ：" + sendmes);
				SendMessage.sendMessageToSlef(ctx, sendmes);
				break;
			}
		}
	}

}
