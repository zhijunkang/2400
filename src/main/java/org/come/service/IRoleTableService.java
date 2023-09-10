package org.come.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.come.bean.LoginResult;
import org.come.entity.RoleAttribute;
import org.come.entity.RoleTable;
import org.come.entity.UserTable;

public interface IRoleTableService {
	// 查询排行榜
	LoginResult selectRoleID(BigDecimal role_id);
	// 查询排行榜
	List<LoginResult> selectOrderByType(Integer type);
	// 查询水陆大会排行榜
	List<LoginResult> selectSLDH();	
	// 查找角色名是否存在
	RoleTable selectRoleTableByRoleName( String rolename );
	// 创建角色
	boolean insertIntoRoleTable(LoginResult loginResult);
	// 查询帮派里的成员
	List<LoginResult> findGangManberByGangID(BigDecimal gang_id);
	// 穿脱装备修改角色属性
	boolean updateRole( RoleTable roleTable );
	// 用户退出时修改角色属性
	void updateRoleWhenExit( LoginResult loginResult );
	//查询用户金钱
	BigDecimal selectMoneyRoleID(@Param("role_id")BigDecimal role_id);
	//修改用户金钱
	int updateMoneyRoleID(@Param("role_id")BigDecimal role_id,@Param("gold")BigDecimal gold);
	//修改积分
	int updateMoneyUserID(@Param("USER_ID")BigDecimal USER_ID,@Param("MONEY")BigDecimal MONEY);
	void updateByPrimaryKey(RoleTable roleTable);
	/**依据角色ID 修改解锁码*/
	int updateRolePwdForRid(RoleTable roleTable);
	/**依据角色ID 修改授权*/
	int updateRoleGMForRid(RoleTable roleTable);
	/**依据角色ID 删除*/
	int deleteRolePwdForRid(RoleTable roleTable);
	/**查询角色帮派信息*/
	RoleTable selectGang(BigDecimal role_id);
	/**修改角色帮派信息*/
	int updateGang(RoleTable roleTable);
	/**查询最大ID*/
	BigDecimal selectRoleMax();
	
	/** zrikka 2020-0408 **/
	/**查询某个账号的所有角色*/
	List<LoginResult> selectRoleByUserid(BigDecimal userid,BigDecimal fuserid);
	/**角色状态更新*/
	int updateRoleStatues(BigDecimal roleid);
	/**角色信息*/
	LoginResult selectRoleByRoleId(BigDecimal roleid);
	UserTable selectForUserId(BigDecimal roleid);
	/**改变角色归属*/
	int updateRoleBelong(BigDecimal roleid,BigDecimal userid);
	/**根据角色名搜索*/
	LoginResult selectRoleName(String rolename);
	
	/**修改全民竞技积分*/
	void addQMJJ(@Param("roleid")BigDecimal roleid,@Param("add")int add);
	void addTTJJ(@Param("roleid") BigDecimal roleid, @Param("state") int state, @Param("add") int add);
	void updateTTJiangli(String TTJIANGLI);
	/**查询指定用户数*/
	List<LoginResult> selectRoleByRoleNum(@Param("notInStr")int count,@Param("notInStr")String notInStr);
	void deleteTableSQL(RoleTable roleTable);
	
	List<Map<String, Object>> selectConfigure();
	
	//查询授权人员
	List<Map<String, Object>> selectadminUserList(Map<String, Object> param);
	//添加授权人员
	int insertUser(Map<String, Object> param);
	
	boolean deleteUser(Map<String, Object> param);
	
	void updateUserAmount(Map<String, Object> param);
	
	RoleAttribute selectRoleAttributeRoleId(BigDecimal role_id);
	void updateRoleAttributeRoleId(RoleAttribute roleAttribute);
	void insertRoleAttribute(RoleAttribute roleAttribute);
}
