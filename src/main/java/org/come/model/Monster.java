package org.come.model;

import come.tool.FightingData.Ql;

/**
 * 静态怪兽表
 * @author 叶豪芳
 * @date : 2017年11月29日 下午3:59:48
 */
public class Monster {

	private int monsterid;//怪物id
	//名称
	private String monstername;
	//皮肤
	private String monsterskin;
	//等级
	private int monsterlvl;
	//是否法怪
	private String monstertype;
	//初血
	private int monsterhp;
	//初蓝
	private int monstermp;
	//初攻
	private int monsterap;
	//初敏
	private int monstersp;
	//成长
	private double monstergrow;
	//携带称谓限制
	private String monsterget;
	//刷怪几率
	private String monsterratio;
	//宠物对应id
	private String monsterpet;
	//技能
	private String monsterskill;
	//技能熟练度
	private int monstercount;
	//技能几率
	private int monstersr;
	//AI
	private String monsterai;
	//喊话
	private String msg;
	//颜色
	private String color;
	private String K;//抗性
	private String H;//忽视
	private String Q;//强
	private String WX;//五行
	private String SS;//伤害
	private String KB;//狂暴
	private String QT;//其他
	
	//缓存
	private Ql ql;
	public String getMsg() {
		return this.msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getMonsterid() {
		return this.monsterid;
	}
	public void setMonsterid(int monsterid) {
		this.monsterid = monsterid;
	}
	public String getMonstername() {
		return this.monstername;
	}
	public void setMonstername(String monstername) {
		this.monstername = monstername;
	}
	public String getMonsterskin() {
		return this.monsterskin;
	}
	public void setMonsterskin(String monsterskin) {
		this.monsterskin = monsterskin;
	}
	public int getMonsterlvl() {
		return this.monsterlvl;
	}
	public void setMonsterlvl(int monsterlvl) {
		this.monsterlvl = monsterlvl;
	}
	public String getMonstertype() {
		return this.monstertype;
	}
	public void setMonstertype(String monstertype) {
		this.monstertype = monstertype;
	}
	public int getMonsterhp() {
		return this.monsterhp;
	}
	public void setMonsterhp(int monsterhp) {
		this.monsterhp = monsterhp;
	}
	public long getMonstermp() {
		return this.monstermp;
	}
	public void setMonstermp(int monstermp) {
		this.monstermp = monstermp;
	}
	public int getMonsterap() {
		return this.monsterap;
	}
	public void setMonsterap(int monsterap) {
		this.monsterap = monsterap;
	}
	public int getMonstersp() {
		return this.monstersp;
	}
	public void setMonstersp(int monstersp) {
		this.monstersp = monstersp;
	}
	public double getMonstergrow() {
		return this.monstergrow;
	}
	public void setMonstergrow(double monstergrow) {
		this.monstergrow = monstergrow;
	}
	public String getMonsterget() {
		return this.monsterget;
	}
	public void setMonsterget(String monsterget) {
		this.monsterget = monsterget;
	}
	public String getMonsterratio() {
		return this.monsterratio;
	}
	public void setMonsterratio(String monsterratio) {
		this.monsterratio = monsterratio;
	}
	public String getMonsterpet() {
		return this.monsterpet;
	}
	public void setMonsterpet(String monsterpet) {
		this.monsterpet = monsterpet;
	}
	public String getMonsterskill() {
		return this.monsterskill;
	}
	public void setMonsterskill(String monsterskill) {
		this.monsterskill = monsterskill;
	}
	public int getMonstercount() {
		return this.monstercount;
	}
	public void setMonstercount(int monstercount) {
		this.monstercount = monstercount;
	}
	public int getMonstersr() {
		return this.monstersr;
	}
	public void setMonstersr(int monstersr) {
		this.monstersr = monstersr;
	}
	public String getMonsterai() {
		return this.monsterai;
	}
	public void setMonsterai(String monsterai) {
		this.monsterai = monsterai;
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getK() {
		return this.K;
	}
	public void setK(String k) {
		this.K = k;
	}
	public String getH() {
		return this.H;
	}
	public void setH(String h) {
		this.H = h;
	}
	public String getQ() {
		return this.Q;
	}
	public void setQ(String q) {
		this.Q = q;
	}
	public String getWX() {
		return this.WX;
	}
	public void setWX(String wX) {
		this.WX = wX;
	}
	public String getSS() {
		return this.SS;
	}
	public void setSS(String sS) {
		this.SS = sS;
	}
	public String getKB() {
		return this.KB;
	}
	public void setKB(String kB) {
		this.KB = kB;
	}
	public String getQT() {
		return this.QT;
	}
	public void setQT(String qT) {
		this.QT = qT;
	}
	public Ql getQl() {
		return this.ql.clone();
	}
	public void setQl(Ql ql) {
		this.ql = ql;
	}
}
