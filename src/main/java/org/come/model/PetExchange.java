package org.come.model;

import java.math.BigDecimal;

import org.come.entity.RoleSummoning;
//TODO 兑换召唤兽
public class PetExchange {

	private int eId;//兑换id
	private String type;//分类
	private String consume;//消耗
	private BigDecimal pid;//召唤兽id
	private String name;//召唤兽名称
	private String skin;//皮肤
	private double grow;//成长
	private int hp;//hp
	private int mp;//mp
	private int ap;//ap
	private int sp;//sp
	private String five;//五行
	private String skill;//天生技能
	
	public void initPet(RoleSummoning pet){
		this.name=pet.getSummoningname();
		this.skin=pet.getSummoningskin();
		this.grow=Double.parseDouble(pet.getGrowlevel());
		this.hp=pet.getHp();
		this.mp=pet.getMp();
		this.ap=pet.getAp();
		this.sp=pet.getSp();
		StringBuffer buffer=new StringBuffer();
		if (!pet.getGold().equals("")&&!pet.getGold().equals("0")) {
			if (buffer.length()!=0) {buffer.append(" ");}
			buffer.append("金:");
			buffer.append(pet.getGold());
		}
		if (!pet.getWood().equals("")&&!pet.getWood().equals("0")) {
			if (buffer.length()!=0) {buffer.append(" ");}
			buffer.append("木:");
			buffer.append(pet.getWood());
		}
		if (!pet.getSoil().equals("")&&!pet.getSoil().equals("0")) {
			if (buffer.length()!=0) {buffer.append(" ");}
			buffer.append("土:");
			buffer.append(pet.getSoil());
		}
		if (!pet.getWater().equals("")&&!pet.getWater().equals("0")) {
			if (buffer.length()!=0) {buffer.append(" ");}
			buffer.append("水:");
			buffer.append(pet.getWater());
		}
		if (!pet.getFire().equals("")&&!pet.getFire().equals("0")) {
			if (buffer.length()!=0) {buffer.append(" ");}
			buffer.append("火:");
			buffer.append(pet.getFire());
		}
		this.five=buffer.toString();
		this.skill=pet.getSkill();
	}
	public int geteId() {
		return this.eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getConsume() {
		return this.consume;
	}
	public void setConsume(String consume) {
		this.consume = consume;
	}
	public BigDecimal getPid() {
		return this.pid;
	}
	public void setPid(BigDecimal pid) {
		this.pid = pid;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrow() {
		return this.grow;
	}
	public void setGrow(double grow) {
		this.grow = grow;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return this.mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getAp() {
		return this.ap;
	}
	public void setAp(int ap) {
		this.ap = ap;
	}
	public int getSp() {
		return this.sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public String getFive() {
		return this.five;
	}
	public void setFive(String five) {
		this.five = five;
	}
	public String getSkill() {
		return this.skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
