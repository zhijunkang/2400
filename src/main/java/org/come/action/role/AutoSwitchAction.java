package org.come.action.role;

import come.tool.Role.RoleData;
import come.tool.Role.RolePool;
import io.netty.channel.ChannelHandlerContext;
import org.come.action.IAction;
import org.come.bean.AutoSwitchBean;
import org.come.bean.ChangeRoleNameBean;
import org.come.bean.LoginResult;
import org.come.entity.RoleTable;
import org.come.handler.SendMessage;
import org.come.protocol.Agreement;
import org.come.protocol.AgreementUtil;
import org.come.redis.RedisControl;
import org.come.redis.RedisPoolUntil;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;
import redis.clients.jedis.Jedis;

/**
 * 修改角色名字
 * @author Administrator
 *
 */
public class AutoSwitchAction implements IAction {

    @Override
    public void action(ChannelHandlerContext ctx, String message) {
        // 获取客户端发来的消息
        AutoSwitchBean autoSwitchBean = GsonUtil.getGsonUtil().getgson().fromJson(message, AutoSwitchBean.class);

        LoginResult roleInfo = GameServer.getAllLoginRole().get(ctx);
        Jedis jedis = RedisPoolUntil.getJedis();
        jedis.hset(AgreementUtil.autoSwitch,roleInfo.getRole_id().toString(),GsonUtil.getGsonUtil().getgson().toJson(autoSwitchBean));
        RedisPoolUntil.returnResource(jedis);
    }
}
