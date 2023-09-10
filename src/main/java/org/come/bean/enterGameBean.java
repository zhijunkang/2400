package org.come.bean;

import java.util.List;

import org.come.entity.Baby;
import org.come.entity.Fly;
import org.come.entity.Goodstable;
import org.come.entity.Lingbao;
import org.come.entity.Mount;
import org.come.entity.PackRecord;
import org.come.entity.Pal;
import org.come.entity.RoleAttribute;
import org.come.entity.RoleSummoning;

import come.tool.Role.PrivateData;
import come.tool.Role.RoleShow;
import come.tool.Role.RoleSystem;
import come.tool.Stall.Stall;
import come.tool.Stall.StallBean;

public class enterGameBean {
	// 旧角色信息
	private LoginResult loginResult;
	//私密数据
	private PrivateData privateData;
	private List<RoleShow> roleShows;
	// 物品信息
	private List<Goodstable> list;
	// 召唤兽列表
	private List<RoleSummoning> roleSummonings;
	// 坐骑列表
	private List<Mount> mounts;
	// 飞行器
	private  List<Fly>flys;
	//怪物集合
	private String monster;
	//灵宝集合
	private List<Lingbao> lingbaos;
	//宝宝集合
	private List<Baby> babys;
	//伙伴集合
	private List<Pal> pals;
	// 记录摆摊
	private List<StallBean> stallBeans;
	// 记录玩家的摆摊的数据
	private Stall stall;
	// 背包记忆
	private PackRecord packRecord;
	//玩家系统设置
	private RoleSystem roleSystem;
	//副本数据
	private String sceneMsg;
	//多属性数据
	private RoleAttribute roleAttribute;
	public String getSceneMsg() {
		return this.sceneMsg;
	}
	public void setSceneMsg(String sceneMsg) {
		this.sceneMsg = sceneMsg;
	}
	public List<RoleShow> getRoleShows() {
		return this.roleShows;
	}
	public void setRoleShows(List<RoleShow> roleShows) {
		this.roleShows = roleShows;
	}
	public List<Goodstable> getList() {
		return this.list;
	}
	public void setList(List<Goodstable> list) {
		this.list = list;
	}
	public List<RoleSummoning> getRoleSummonings() {
		return this.roleSummonings;
	}
	public void setRoleSummonings(List<RoleSummoning> roleSummonings) {
		this.roleSummonings = roleSummonings;
	}
	public List<Mount> getMounts() {
		return this.mounts;
	}
	public void setMounts(List<Mount> mounts) {
		this.mounts = mounts;
	}
	
	public String getMonster() {
		return this.monster;
	}
	public void setMonster(String monster) {
		this.monster = monster;
	}
	public List<Lingbao> getLingbaos() {
		return this.lingbaos;
	}
	public void setLingbaos(List<Lingbao> lingbaos) {
		this.lingbaos = lingbaos;
	}
	public List<Baby> getBabys() {
		return this.babys;
	}
	public void setBabys(List<Baby> babys) {
		this.babys = babys;
	}
	public List<StallBean> getStallBeans() {
		return this.stallBeans;
	}
	public void setStallBeans(List<StallBean> stallBeans) {
		this.stallBeans = stallBeans;
	}
	public Stall getStall() {
		return this.stall;
	}
	public void setStall(Stall stall) {
		this.stall = stall;
	}
	public PackRecord getPackRecord() {
		return this.packRecord;
	}
	public void setPackRecord(PackRecord packRecord) {
		this.packRecord = packRecord;
	}
	public RoleSystem getRoleSystem() {
		return this.roleSystem;
	}
	public void setRoleSystem(RoleSystem roleSystem) {
		this.roleSystem = roleSystem;
	}
	public LoginResult getLoginResult() {
		return this.loginResult;
	}
	public void setLoginResult(LoginResult loginResult) {
		this.loginResult = loginResult;
	}
	public PrivateData getPrivateData() {
		return this.privateData;
	}
	public void setPrivateData(PrivateData privateData) {
		this.privateData = privateData;
	}
	public List<Pal> getPals() {
		return this.pals;
	}
	public void setPals(List<Pal> pals) {
		this.pals = pals;
	}
	public RoleAttribute getRoleAttribute() {
		return roleAttribute;
	}
	public void setRoleAttribute(RoleAttribute roleAttribute) {
		this.roleAttribute = roleAttribute;
	}
	public List<Fly> getFlys(){return  flys;}
	public void  setFlys(List<Fly>flys){this.flys=flys;}
}
