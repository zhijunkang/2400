package org.come.action.summoning;

import io.netty.channel.ChannelHandlerContext;
import org.come.action.IAction;
import org.come.bean.LoginResult;
import org.come.entity.RoleSummoning;
import org.come.handler.SendMessage;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

import java.util.List;

/**
 * 修改宠物信息
 * @author 叶豪芳
 * @date 2017年12月23日 下午8:03:21
 *
 */
public class PetChangeAction implements IAction{

	@Override
	public void action(ChannelHandlerContext ctx, String message) {
		// 获得宠物信息
		RoleSummoning roleSummoning = GsonUtil.getGsonUtil().getgson().fromJson(message, RoleSummoning.class);
		LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);
		List<RoleSummoning> roleSummonings=null;
		if(roleSummoning.isShow()){
			//宠物跟随
			roleSummonings = AllServiceUtil.getRoleSummoningService().selectRoleSummoningsByRoleID(loginResult.getRole_id());
			if (roleSummonings.stream().filter(e->e.isShow()).count()>2){
				SendMessage.sendMessageByRoleName(loginResult.getRolename(),Agreement.getAgreement().PromptAgreement("最多跟随3只"));
				return;
			}
		}

		// 修改宠物信息
		AllServiceUtil.getRoleSummoningService().updateRoleSummoning(roleSummoning);

		roleSummonings = AllServiceUtil.getRoleSummoningService().selectRoleSummoningsByRoleID(loginResult.getRole_id());
		loginResult.setShowRoleSummoningList(roleSummonings);
		//通知地图
		SendMessage.sendMessageToMapRoles(loginResult.getMapid(), Agreement.getAgreement().upRoleShowAgreement(GsonUtil.getGsonUtil().getgson().toJson(loginResult.getRoleShow())));

	}
}
