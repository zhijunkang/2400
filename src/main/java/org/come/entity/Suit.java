package org.come.entity;

import come.tool.Calculation.BaseSkill;

/**
 * 套装
 */
public class Suit {
	
	private int SuitID; //套装id
	private String Sname; //套装名
	private int Sysex; //适用性别
	private String HaveParts; //拥有部件
	private String HaveSkill; //拥有技能
	private String Introduce; //介绍
	private transient int[] Parts;//缓存部件数组
	private transient BaseSkill[] Suits;//缓存部件数组
	public BaseSkill[] getSuits() {
		if (this.HaveSkill!=null&&!this.HaveSkill.equals("")) {
			String[] vs=this.HaveSkill.split("\\|");
			this.Suits=new BaseSkill[vs.length];
			for (int i = 0; i < vs.length; i++) {
				String[] v=vs[i].split("-");
				this.Suits[i]=new BaseSkill(Integer.parseInt(v[1]),Integer.parseInt(v[0]));
			}
		}
		return this.Suits;
	}
	public int getSuitID() {
		return this.SuitID;
	}
	public void setSuitID(int suitID) {
		this.SuitID = suitID;
	}
	public String getSname() {
		return this.Sname;
	}
	public void setSname(String sname) {
		this.Sname = sname;
	}
	public int getSysex() {
		return this.Sysex;
	}
	public void setSysex(int sysex) {
		this.Sysex = sysex;
	}
	public String getHaveParts() {
		return this.HaveParts;
	}
	public void setHaveParts(String haveParts) {
		this.HaveParts = haveParts;
	}
	public String getHaveSkill() {
		return this.HaveSkill;
	}
	public void setHaveSkill(String haveSkill) {
		this.HaveSkill = haveSkill;
	}
	public String getIntroduce() {
		return this.Introduce;
	}
	public void setIntroduce(String introduce) {
		this.Introduce = introduce;
	}
	public int[] getParts() {
		return this.Parts;
	}
	public void setParts(int[] parts) {
		this.Parts = parts;
	}
	
}
