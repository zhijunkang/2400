package org.come.action.Fly;

import come.tool.Role.RoleData;
import come.tool.Role.RolePool;
import io.netty.channel.ChannelHandlerContext;
import org.come.action.IAction;
import org.come.bean.LoginResult;
import org.come.entity.Fly;

import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

public class FlyUpdateAction implements IAction {
    public void action(ChannelHandlerContext ctx, String message){
        LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);
        RoleData data= RolePool.getRoleData(loginResult.getRole_id());

        Fly fly=GsonUtil.getGsonUtil().getgson().fromJson(message,Fly.class);
        Fly flyRedis=AllServiceUtil.getFlyService().selectFlysByMID(fly.getMid());
        if (flyRedis==null||data==null||loginResult.getRole_id().compareTo(flyRedis.getRoleid())!=0) {
            return;
        }
        flyRedis.setFlystate(fly.getFlystate());
        flyRedis.setExp(fly.getExp());
        flyRedis.setFlyname(fly.getFlyname());
        AllServiceUtil.getFlyService().updateFlyRedis(flyRedis);
    }
}
