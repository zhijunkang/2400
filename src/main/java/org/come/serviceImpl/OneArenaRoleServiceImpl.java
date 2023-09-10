package org.come.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.come.mapper.OneArenaRoleMapper;
import org.come.service.OneArenaRoleService;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

import come.tool.oneArena.OneArenaRole;

public class OneArenaRoleServiceImpl implements OneArenaRoleService {

	private OneArenaRoleMapper oneArenaRoleMapper;
	public OneArenaRoleServiceImpl() {
		// TODO Auto-generated constructor stub
		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		// id为类名且首字母小写才能被自动扫描扫到
		this.oneArenaRoleMapper = (OneArenaRoleMapper) ctx.getBean("oneArenaRoleMapper");
	}
	@Override
	public int insertOneArenaRole(OneArenaRole role) {
		// TODO Auto-generated method stub
		return this.oneArenaRoleMapper.insertOneArenaRole(role);
	}
	@Override
	public List<OneArenaRole> selectRankRoles(List<Integer> list) {
		// TODO Auto-generated method stub
		return this.oneArenaRoleMapper.selectRankRoles(list);
	}
	@Override
	public OneArenaRole selectRole(BigDecimal roleID) {
		// TODO Auto-generated method stub
		return this.oneArenaRoleMapper.selectRole(roleID);
	}
	@Override
	public int updateDayReset() {
		// TODO Auto-generated method stub
		return this.oneArenaRoleMapper.updateDayReset();
	}
	@Override
	public int updateRankRole(BigDecimal roleID, int rank,String skin,String name,int lvl) {
		// TODO Auto-generated method stub
		return this.oneArenaRoleMapper.updateRankRole(roleID, rank, skin, name, lvl);
	}
	@Override
	public int selectRank(BigDecimal roleID) {
		// TODO Auto-generated method stub
	    Integer selectRank = this.oneArenaRoleMapper.selectRank(roleID);
		return  selectRank == null? 0 : selectRank;
	}
	@Override
	public int selectRankPast(BigDecimal roleID) {
		// TODO Auto-generated method stub
	    Integer selectRankPast = this.oneArenaRoleMapper.selectRankPast(roleID);
		return selectRankPast == null ? 0 : selectRankPast;
	}
	@Override
	public int updateDayResetRole(BigDecimal roleID) {
		// TODO Auto-generated method stub
		return this.oneArenaRoleMapper.updateDayResetRole(roleID);
	}
}
