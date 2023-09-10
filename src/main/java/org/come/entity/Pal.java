package org.come.entity;

import java.math.BigDecimal;

public class Pal {

	private BigDecimal id;//数据库表id
	private int pId;//伙伴id
	private double grow;//成长 
	private int lvl;//等级
	private long exp;//经验
	private String parts;//装备id
	private BigDecimal roleId;//角色id
	public BigDecimal getId() {
		return this.id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public double getGrow() {
		return this.grow;
	}
	public void setGrow(double grow) {
		this.grow = grow;
	}
	public int getLvl() {
		return this.lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public long getExp() {
		return this.exp;
	}
	public void setExp(long exp) {
		this.exp = exp;
	}
	public String getParts() {
		return this.parts;
	}
	public void setParts(String parts) {
		this.parts = parts;
	}
	public int getpId() {
		return this.pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public BigDecimal getRoleId() {
		return this.roleId;
	}
	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}
	
}
