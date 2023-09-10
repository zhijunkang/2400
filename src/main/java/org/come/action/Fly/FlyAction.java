package org.come.action.Fly;

import io.netty.channel.ChannelHandlerContext;
import org.come.action.IAction;
import org.come.bean.FlyResult;
import org.come.bean.MountResult;
import org.come.entity.Fly;
import org.come.entity.Mount;
import org.come.handler.SendMessage;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

import java.math.BigDecimal;
import java.util.List;

public class FlyAction implements IAction {
    public void action(ChannelHandlerContext ctx, String message){

        BigDecimal roleID = GameServer.getAllLoginRole().get(ctx).getRole_id();
        List<Fly> flys = AllServiceUtil.getFlyService().selectFlysByRoleID(roleID);
        FlyResult flyResult = new FlyResult();
        flyResult.setFlys(flys);
        String msg = Agreement.getAgreement().FlyAgreement(GsonUtil.getGsonUtil().getgson().toJson(flyResult));
        SendMessage.sendMessageToSlef(ctx, msg);


    }
}
