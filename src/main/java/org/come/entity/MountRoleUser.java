package org.come.entity;

import java.math.BigDecimal;

public class MountRoleUser {

	private BigDecimal mid; // 表ID
	private BigDecimal mountid; // 坐骑ID
	private String mountname; // 坐骑名称
	private String mountlvl; // 坐骑等级
	private String live; // 体力
	private String spri; // 灵性
	private String power; // 力量
	private String bone; // 根骨
	private String exp; // 经验
	private BigDecimal roleid; // 角色ID
	private BigDecimal sid; // 管制的召唤兽ID
	private BigDecimal othrersid; // 管制的召唤兽ID
	private Integer usenumber; // 使用次数
	private Integer proficiency; // 熟练度
	private BigDecimal sid3; ////TODO 管制的召唤兽ID
	private BigDecimal sid4; // 管制的召唤兽ID
	private Integer sid5; // 管制id
	private String rolename;
	private BigDecimal user_id;
	private String username;

	// --
	private Integer start;
	private Integer end;
	private Integer pageNum;
	private String orderBy;

	public MountRoleUser() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getMid() {
		return this.mid;
	}

	public void setMid(BigDecimal mid) {
		this.mid = mid;
	}

	public BigDecimal getMountid() {
		return this.mountid;
	}

	public void setMountid(BigDecimal mountid) {
		this.mountid = mountid;
	}

	public String getMountname() {
		return this.mountname;
	}

	public void setMountname(String mountname) {
		this.mountname = mountname;
	}

	public String getMountlvl() {
		return this.mountlvl;
	}

	public void setMountlvl(String mountlvl) {
		this.mountlvl = mountlvl;
	}

	public String getLive() {
		return this.live;
	}

	public void setLive(String live) {
		this.live = live;
	}

	public String getSpri() {
		return this.spri;
	}

	public void setSpri(String spri) {
		this.spri = spri;
	}

	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getBone() {
		return this.bone;
	}

	public void setBone(String bone) {
		this.bone = bone;
	}

	public String getExp() {
		return this.exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public BigDecimal getRoleid() {
		return this.roleid;
	}

	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}

	public BigDecimal getSid() {
		return this.sid;
	}

	public void setSid(BigDecimal sid) {
		this.sid = sid;
	}

	public BigDecimal getOthrersid() {
		return this.othrersid;
	}

	public void setOthrersid(BigDecimal othrersid) {
		this.othrersid = othrersid;
	}

	public Integer getUsenumber() {
		return this.usenumber;
	}

	public void setUsenumber(Integer usenumber) {
		this.usenumber = usenumber;
	}

	public Integer getProficiency() {
		return this.proficiency;
	}

	public void setProficiency(Integer proficiency) {
		this.proficiency = proficiency;
	}

	public BigDecimal getsid3() {
		return this.sid3;
	}

	public void setsid3(BigDecimal sid3) {
		this.sid3 = sid3;
	}
	
	public BigDecimal getsid4() {
		return this.sid4;
	}

	public void setsid4(BigDecimal sid4) {
		this.sid4 = sid4;
	}
	
	public Integer getSid5() {
		return this.sid5;
	}

	public void setSid5(Integer sid5) {
		this.sid5 = sid5;
	}


	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public BigDecimal getUser_id() {
		return this.user_id;
	}

	public void setUser_id(BigDecimal user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getStart() {
		return this.start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return this.end;
	}
 
	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}
