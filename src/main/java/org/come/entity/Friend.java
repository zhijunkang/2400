package org.come.entity;

import java.math.BigDecimal;
/**
 * 好友表
 * @author 叶豪芳
 *
 */
public class Friend {
	// 表ID
	private BigDecimal fid;
	// 角色ID
	private BigDecimal roleid;
	// 角色好友ID
	private BigDecimal friendid;
	
	public BigDecimal getFid() {
		return this.fid;
	}
	public void setFid(BigDecimal fid) {
		this.fid = fid;
	}
	public BigDecimal getRoleid() {
		return this.roleid;
	}
	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}
	public BigDecimal getFriendid() {
		return this.friendid;
	}
	public void setFriendid(BigDecimal friendid) {
		this.friendid = friendid;
	}

	
}
