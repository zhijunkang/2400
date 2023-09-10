package org.come.action.mount;

import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.come.action.IAction;
import org.come.entity.Mount;
import org.come.entity.MountSkill;
import org.come.model.Configure;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;
/**
 * 坐骑学习技能
 * @author Administrator
 *
 */
public class MountSkillStuAction implements IAction {

	@Override
	public void action(ChannelHandlerContext ctx, String message) {
		
		MountSkill mountSkill = GsonUtil.getGsonUtil().getgson().fromJson(message, MountSkill.class);	
		Mount mount=AllServiceUtil.getMountService().selectMountsByMID(mountSkill.getMid());
		if (mount==null) {return;}
		List<MountSkill> skills=mount.getMountskill();
		
		ConcurrentHashMap<Integer, Configure> s = GameServer.getAllConfigure();
		Configure configure = s.get(1);
		
		//判断是否飞行坐骑
 		if (skills!=null && skills.size()>=Integer.parseInt(configure.getZqjnsx()) && mount.getMountid()<8) {
			return;
		}else if (skills!=null && skills.size()>=(Integer.parseInt(configure.getZqjnsx())+1) && mount.getMountid()>7) {
			return;
		}
		if (skills==null) {
			skills=new ArrayList<>();
		}
		skills.add(mountSkill);
		mount.setMountskill(skills);
		AllServiceUtil.getMountService().updateMountRedis(mount);
		// 添加坐骑技能
		AllServiceUtil.getMountskillService().insertMountskills(mountSkill);
	}

}
