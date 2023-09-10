package org.come.serviceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.come.bean.LoginResult;
import org.come.entity.RoleAttribute;
import org.come.entity.RoleTable;
import org.come.entity.UserTable;
import org.come.mapper.RoleTableMapper;
import org.come.redis.RedisControl;
import org.come.service.IRoleTableService;
import org.come.until.GsonUtil;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

public class RoleTableServiceImpl implements IRoleTableService{

	private RoleTableMapper roleTableMapper;
	
	public RoleTableServiceImpl() {
		ApplicationContext ctx = MybatisUntil.getApplicationContext();
		// id为类名且首字母小写才能被自动扫描扫到	
		this.roleTableMapper = ctx.getBean("roleTableMapper",RoleTableMapper.class);
	}
	public static void main(String[] args) {
		RoleTableServiceImpl impl = new RoleTableServiceImpl();
		RoleTable roleTable = new RoleTable();
		roleTable.setRole_id(new BigDecimal(11));
		impl.updateByPrimaryKey(roleTable);
	}
	//创建用户
	@Override
	public boolean insertIntoRoleTable(LoginResult loginResult) {		
		boolean exist = this.roleTableMapper.insertIntoRoleTable(loginResult);
		RedisControl.userController("R",loginResult.getRole_id().toString(),RedisControl.CADD,GsonUtil.getGsonUtil().getgson().toJson(loginResult));
		return exist;
	}
	// 查询帮派所有成员
	@Override
	public List<LoginResult> findGangManberByGangID(BigDecimal gang_id) {
		List<LoginResult> gangRoles = this.roleTableMapper.findGangManberByGangID(gang_id);
		return gangRoles;
	}
	//查询 
	
	
	
	
	// 修改角色属性
	@Override
	public boolean updateRole(RoleTable roleTable) {

		boolean isSuccess = this.roleTableMapper.updateRole(roleTable);
		
		return isSuccess;
	}
	// 查找角色名是否存在
	@Override
	public RoleTable selectRoleTableByRoleName(String rolename) {

		RoleTable roleTable = this.roleTableMapper.selectRoleTableByRoleName(rolename);
		return roleTable;
	}
	// 用户退出时修改角色属性
	@Override
	public void updateRoleWhenExit(LoginResult loginResult) {
		
		this.roleTableMapper.updateRoleWhenExit(loginResult);
		
	}
	@Override
	public BigDecimal selectMoneyRoleID(BigDecimal role_id) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectMoneyRoleID(role_id);
	}
	@Override
	public int updateMoneyRoleID(BigDecimal role_id,BigDecimal gold) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.updateMoneyRoleID(role_id,gold);
	}
	@Override
	public void updateByPrimaryKey(RoleTable roleTable) {
		this.roleTableMapper.updateByPrimaryKey(roleTable);		
	}
	// 查询排行榜
	@Override
	public List<LoginResult> selectOrderByType(Integer type) {
		return this.roleTableMapper.selectOrderByType(type);
	}
	@Override
	public LoginResult selectRoleID(BigDecimal role_id) {
		// TODO Auto-generated method stub
		LoginResult S = this.roleTableMapper.selectRoleID(role_id);
		return S;
	}
	@Override
	public int updateRolePwdForRid(RoleTable roleTable) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.updateRolePwdForRid(roleTable);
	}
	@Override
	public int updateRoleGMForRid(RoleTable roleTable) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.updateRoleGMForRid(roleTable);
	}
	@Override
	public int deleteRolePwdForRid(RoleTable roleTable) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.deleteRolePwdForRid(roleTable);
	}
	@Override
	public List<LoginResult> selectSLDH() {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectSLDH();
	}
	@Override
	public RoleTable selectGang(BigDecimal role_id) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectGang(role_id);
	}
	@Override
	public int updateGang(RoleTable roleTable) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.updateGang(roleTable);
	}
	@Override
	public BigDecimal selectRoleMax() {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectRoleMax();
	}
	@Override
	public List<LoginResult> selectRoleByUserid(BigDecimal userid, BigDecimal fuserid) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectRoleByUserid(userid, fuserid);
	}
	@Override
	public int updateRoleStatues(BigDecimal roleid) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.updateRoleStatues(roleid);
	}
	@Override
	public int updateRoleBelong(BigDecimal roleid, BigDecimal userid) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.updateRoleBelong(roleid, userid);
	}
	@Override
	public int updateMoneyUserID(BigDecimal roleid, BigDecimal userid) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.updateMoneyUserID(roleid, userid);
	}
	@Override
	public LoginResult selectRoleByRoleId(BigDecimal roleid) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectRoleByRoleId(roleid);
	}
	@Override
	public LoginResult selectRoleName(String rolename) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectRoleName(rolename);
	}
	@Override
	public List<Map<String, Object>> selectConfigure() {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectConfigure();
	}
	
	@Override
	public void addQMJJ(BigDecimal roleid, int add) {
		// TODO Auto-generated method stub
		this.roleTableMapper.addQMJJ(roleid, add);
	}

	@Override
	public List<LoginResult> selectRoleByRoleNum(int count,String notInStr) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectRoleByRoleNum(count,notInStr);
	}
	
	@Override
	public void deleteTableSQL(RoleTable roleTable) {
		// TODO Auto-generated method stub
		
		this.roleTableMapper.deleteTableSQL1(roleTable);
		this.roleTableMapper.deleteTableSQL2(roleTable);
		this.roleTableMapper.deleteTableSQL3(roleTable);
		this.roleTableMapper.deleteTableSQL4(roleTable);
		this.roleTableMapper.deleteTableSQL5(roleTable);
		this.roleTableMapper.deleteTableSQL6(roleTable);
		this.roleTableMapper.deleteTableSQL7(roleTable);
		this.roleTableMapper.deleteTableSQL8(roleTable);
		this.roleTableMapper.deleteTableSQL9(roleTable);
		this.roleTableMapper.deleteTableSQL10(roleTable);
		this.roleTableMapper.deleteTableSQL11(roleTable);
		this.roleTableMapper.deleteTableSQL12(roleTable);
		this.roleTableMapper.deleteTableSQL13(roleTable);
		this.roleTableMapper.deleteTableSQL14(roleTable);
		this.roleTableMapper.deleteTableSQL15(roleTable);
		this.roleTableMapper.deleteTableSQL16(roleTable);
		this.roleTableMapper.deleteTableSQL17(roleTable);
		this.roleTableMapper.deleteTableSQL18(roleTable);
		this.roleTableMapper.deleteTableSQL19(roleTable);
		this.roleTableMapper.deleteTableSQL20(roleTable);
		this.roleTableMapper.deleteTableSQL21(roleTable);
		this.roleTableMapper.deleteTableSQL22(roleTable);
		this.roleTableMapper.deleteTableSQL23(roleTable);
		this.roleTableMapper.deleteTableSQL24(roleTable);
		this.roleTableMapper.deleteTableSQL25(roleTable);
		this.roleTableMapper.deleteTableSQL26(roleTable);
		this.roleTableMapper.deleteTableSQL27(roleTable);
		this.roleTableMapper.deleteTableSQL28(roleTable);
		this.roleTableMapper.deleteTableSQL29(roleTable);
		this.roleTableMapper.deleteTableSQL30(roleTable);
		this.roleTableMapper.deleteTableSQL31(roleTable);
		this.roleTableMapper.deleteTableSQL32(roleTable);
		this.roleTableMapper.deleteTableSQL33(roleTable);
		this.roleTableMapper.deleteTableSQL34(roleTable);
		this.roleTableMapper.deleteTableSQL35(roleTable);
		this.roleTableMapper.deleteTableSQL36(roleTable);
		this.roleTableMapper.deleteTableSQL37(roleTable);
		this.roleTableMapper.deleteTableSQL38(roleTable);
		this.roleTableMapper.deleteTableSQL39(roleTable);
		this.roleTableMapper.deleteTableSQL40(roleTable);
		this.roleTableMapper.deleteTableSQL41(roleTable);
		this.roleTableMapper.deleteTableSQL42(roleTable);
		this.roleTableMapper.deleteTableSQL43(roleTable);
		this.roleTableMapper.deleteTableSQL44(roleTable);
		this.roleTableMapper.deleteTableSQL45(roleTable);
		this.roleTableMapper.deleteTableSQL46(roleTable);

	}
	
	//查询授权user
	@Override
	public List<Map<String, Object>> selectadminUserList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return this.roleTableMapper.selectadminUserList(param);
	}
	
	
	//添加授权user
	@Override
	public int insertUser(Map<String, Object> param) {
	
		int isSuccess = this.roleTableMapper.insertUser(param);
		
		return isSuccess;
	}
	//添加授权user
	@Override
	public boolean deleteUser(Map<String, Object> param) {
		System.out.println(param.get("ACCOUNT"));
		this.roleTableMapper.deleteUser(param);
		return true;
	}
	//添加授权user
	@Override
	public void updateUserAmount(Map<String, Object> param) {
		this.roleTableMapper.updateUserAmount(param);
	}
	//天梯
	@Override
	public void addTTJJ(BigDecimal roleid, int add,int state ) {
		// TODO Auto-generated method stub
		roleTableMapper.addTTJJ(roleid, add, state);
	}
	@Override
	public void updateTTJiangli(String TTJIANGLI) {
		// TODO Auto-generated method stub
		roleTableMapper.updateTTJiangli(TTJIANGLI);
	}
	@Override
	public UserTable selectForUserId(BigDecimal roleid) {
		return roleTableMapper.selectForUserId(roleid);
	}
	@Override
	public RoleAttribute selectRoleAttributeRoleId(BigDecimal roleid) {
		return roleTableMapper.selectRoleAttributeRoleId(roleid);
	}
	@Override
	public void updateRoleAttributeRoleId(RoleAttribute roleAttribute) {
		roleTableMapper.updateRoleAttributeRoleId(roleAttribute);
	}
	@Override
	public void insertRoleAttribute(RoleAttribute roleAttribute) {
		roleTableMapper.insertRoleAttribute(roleAttribute);
	}
}
