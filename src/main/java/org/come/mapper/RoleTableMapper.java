package org.come.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.come.annotation.MyBatisAnnotation;
import org.come.bean.LoginResult;
import org.come.entity.RoleAttribute;
import org.come.entity.RoleTable;
import org.come.entity.UserTable;

@MyBatisAnnotation
public interface RoleTableMapper {
	// 查询排行榜
	LoginResult selectRoleID(BigDecimal role_id);
	// 查询多属性
	RoleAttribute selectRoleAttributeRoleId(BigDecimal role_id);
	// 修改多属性
	void updateRoleAttributeRoleId(RoleAttribute roleAttribute);
	// 创建多属性
	void insertRoleAttribute(RoleAttribute roleAttribute);
	// 查询排行榜
	List<LoginResult> selectOrderByType(Integer type);
	// 查询水陆大会排行榜
	List<LoginResult> selectSLDH();	
	
	// 查找角色名是否存在
	RoleTable selectRoleTableByRoleName( String rolename );

	// 创建角色
	boolean insertIntoRoleTable( LoginResult loginResult );

	// 查询帮派里的成员
	List<LoginResult> findGangManberByGangID(BigDecimal gang_id);

	// 穿脱装备修改角色属性
	boolean updateRole( RoleTable roleTable );

	// 用户退出时修改角色属性
	void updateRoleWhenExit(LoginResult loginResult );
    //查询用户金钱
	BigDecimal selectMoneyRoleID(@Param("role_id")BigDecimal role_id);
	//修改用户金钱
	int updateMoneyRoleID(@Param("role_id")BigDecimal role_id,@Param("gold")BigDecimal gold);
	
	int updateMoneyUserID(@Param("USER_ID")BigDecimal role_id,@Param("MONEY")BigDecimal MONEY);
	UserTable selectForUserId(BigDecimal USER_ID);
	void updateByPrimaryKey(RoleTable roleTable);
	/**依据角色ID 修改解锁码*/
	int updateRolePwdForRid(RoleTable roleTable);
	/**依据角色ID 修改特权码*/
	int updateRoleGMForRid(RoleTable roleTable);
	//依据角色ID 删除角色
	int deleteRolePwdForRid(RoleTable roleTable);
	/**查询角色帮派信息*/
	RoleTable selectGang(BigDecimal role_id);
	/**修改角色帮派信息*/
	int updateGang(RoleTable roleTable);
	/**清档*/
	int deleteSQL(RoleTable roleTable);
	/**查询最大ID*/
	BigDecimal selectRoleMax();
	
	/** zrikka 2020-0408 **/
	/**查询某个账号的所有角色*/
	List<LoginResult> selectRoleByUserid(@Param("userid") BigDecimal userid, @Param("fuserid") BigDecimal fuserid);
	/**角色状态更新*/
	int updateRoleStatues(@Param("roleid") BigDecimal roleid);
	/**角色信息*/
	LoginResult selectRoleByRoleId(@Param("roleid") BigDecimal roleid);
	/**改变角色归属*/
	int updateRoleBelong(@Param("roleid") BigDecimal roleid, @Param("userid") BigDecimal userid);
	/**根据角色名搜索*/
	LoginResult selectRoleName(String rolename);
	
	/**修改全民竞技积分*/
	void addQMJJ(@Param("roleid")BigDecimal roleid,@Param("add")int add);
	
	/**查询配置*/
	List<Map<String, Object>> selectConfigure();
	/**查询授权user*/
	List<Map<String, Object>> selectadminUserList(Map<String, Object> param);
	/**添加授权user*/
	int insertUser(Map<String, Object> param);
	/**删除授权user*/
	void deleteUser(Map<String, Object> param);
	/**修改额度*/
	void updateUserAmount(Map<String, Object> param);


	/**查询指定用户数*/
	List<LoginResult> selectRoleByRoleNum(@Param("count")int count,@Param("notInStr")String notInStr);
	
	void deleteTableSQL1(RoleTable roleTable);
	void deleteTableSQL2(RoleTable roleTable);
	void deleteTableSQL3(RoleTable roleTable);
	void deleteTableSQL4(RoleTable roleTable);
	void deleteTableSQL5(RoleTable roleTable);
	void deleteTableSQL6(RoleTable roleTable);
	void deleteTableSQL7(RoleTable roleTable);
	void deleteTableSQL8(RoleTable roleTable);
	void deleteTableSQL9(RoleTable roleTable);
	void deleteTableSQL10(RoleTable roleTable);
	void deleteTableSQL11(RoleTable roleTable);
	void deleteTableSQL12(RoleTable roleTable);
	void deleteTableSQL13(RoleTable roleTable);
	void deleteTableSQL14(RoleTable roleTable);
	void deleteTableSQL15(RoleTable roleTable);
	void deleteTableSQL16(RoleTable roleTable);
	void deleteTableSQL17(RoleTable roleTable);
	void deleteTableSQL18(RoleTable roleTable);
	void deleteTableSQL19(RoleTable roleTable);
	void deleteTableSQL20(RoleTable roleTable);
	void deleteTableSQL21(RoleTable roleTable);
	void deleteTableSQL22(RoleTable roleTable);
	void deleteTableSQL23(RoleTable roleTable);
	void deleteTableSQL24(RoleTable roleTable);
	void deleteTableSQL25(RoleTable roleTable);
	void deleteTableSQL26(RoleTable roleTable);
	void deleteTableSQL27(RoleTable roleTable);
	void deleteTableSQL28(RoleTable roleTable);
	void deleteTableSQL29(RoleTable roleTable);
	void deleteTableSQL30(RoleTable roleTable);
	void deleteTableSQL31(RoleTable roleTable);
	void deleteTableSQL32(RoleTable roleTable);
	void deleteTableSQL33(RoleTable roleTable);
	void deleteTableSQL34(RoleTable roleTable);
	void deleteTableSQL35(RoleTable roleTable);
	void deleteTableSQL36(RoleTable roleTable);
	void deleteTableSQL37(RoleTable roleTable);
	void deleteTableSQL38(RoleTable roleTable);
	void deleteTableSQL39(RoleTable roleTable);
	void deleteTableSQL40(RoleTable roleTable);
	void deleteTableSQL41(RoleTable roleTable);
	void deleteTableSQL42(RoleTable roleTable);
	void deleteTableSQL43(RoleTable roleTable);
	void deleteTableSQL44(RoleTable roleTable);
	void deleteTableSQL45(RoleTable roleTable);
	void deleteTableSQL46(RoleTable roleTable);
	//天梯
	void addTTJJ(@Param("roleid") BigDecimal roleid, @Param("add") int add, @Param("state") int state);
	void updateTTJiangli(@Param("TTJIANGLI") String  ttJiangli);
}