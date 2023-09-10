package org.come.action.mount;

import io.netty.channel.ChannelHandlerContext;

import java.math.BigDecimal;

import org.come.action.IAction;
import org.come.action.summoning.SummonPetAction;
import org.come.until.AllServiceUtil;
/**
 * 放生坐骑
 * @author 叶豪芳
 *
 */
public class MountReleaseAction implements IAction {

	@Override
	public void action(ChannelHandlerContext ctx, String message) {
		BigDecimal mountId = new BigDecimal(message);
		if(!SummonPetAction.validateMount(ctx, mountId)) {
			return;
		}
		// 删除坐骑
		AllServiceUtil.getMountService().deleteMountsByMid(new BigDecimal(message));
		
		// 删除该坐骑下的法术
		AllServiceUtil.getMountskillService().deleteMountskills(new BigDecimal(message));

	}

}
