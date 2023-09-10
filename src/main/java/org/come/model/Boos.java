package org.come.model;

import come.tool.Good.DropModel;

/**
 * 怪物刷新信息
 * @author 叶豪芳
 * @date 2017年12月27日 下午3:40:35
 * 
 */ 
public class Boos {
	// 刷新表ID
	private String boosid;
	// 类型
	private String boostype;
	// 名称
	private String boosname;
	// 地图名称
	private String boosmapname;
	// 绑定机器人id
	private String boosrobot;
	// 星期几开放
	private String boosweekday;
	// 开始时间
	private int boosstime;
	// 结束时间
	private int boosetime;	
	// 刷怪时间
	private int boosrtime;
	// 刷怪个数
	private int boosnum;	
	// 帮战概率
	private int boosgpk;
	// 世界喊话
	private String boostext;
	// 公告喊话
	private String boosGGtext;
	//掉落
	private String boosDrop;
	//最大次数
	private int boosDropMax;
	//放妖人掉落
	private String fyDrop;
	
	private transient DropModel dropModel;//唯一性掉落
	
	public String getBoosid() {
		return this.boosid;
	}

	public void setBoosid(String boosid) {
		this.boosid = boosid;
	}

	public String getBoostype() {
		return this.boostype;
	}

	public void setBoostype(String boostype) {
		this.boostype = boostype;
	}

	public String getBoosname() {
		return this.boosname;
	}

	public void setBoosname(String boosname) {
		this.boosname = boosname;
	}

	public String getBoosmapname() {
		return this.boosmapname;
	}

	public void setBoosmapname(String boosmapname) {
		this.boosmapname = boosmapname;
	}

	public String getBoosrobot() {
		return this.boosrobot;
	}

	public void setBoosrobot(String boosrobot) {
		this.boosrobot = boosrobot;
	}

	public String getBoosweekday() {
		return this.boosweekday;
	}

	public void setBoosweekday(String boosweekday) {
		this.boosweekday = boosweekday;
	}

	
	public String getBoostext() {
		return this.boostext;
	}

	public void setBoostext(String boostext) {
		this.boostext = boostext;
	}

	public String getBoosGGtext() {
		return this.boosGGtext;
	}

	public void setBoosGGtext(String boosGGtext) {
		this.boosGGtext = boosGGtext;
	}

	public String getBoosDrop() {
		return this.boosDrop;
	}

	public void setBoosDrop(String boosDrop) {
		this.boosDrop = boosDrop;
	}
	public int getBoosDropMax() {
		return this.boosDropMax;
	}
	public void setBoosDropMax(int boosDropMax) {
		this.boosDropMax = boosDropMax;
	}

	public DropModel getDropModel() {
		if (this.dropModel==null) {
			if (this.boosDrop!=null&&!this.boosDrop.equals("")) {
				this.dropModel=new DropModel(this.boosDrop.split("\\|"));
			}
		}
		return this.dropModel;
	}

	public String getFyDrop() {
		return this.fyDrop;
	}

	public void setFyDrop(String fyDrop) {
		this.fyDrop = fyDrop;
	}

	public int getBoosstime() {
		return this.boosstime;
	}

	public void setBoosstime(int boosstime) {
		this.boosstime = boosstime;
	}

	public int getBoosetime() {
		return this.boosetime;
	}

	public void setBoosetime(int boosetime) {
		this.boosetime = boosetime;
	}

	public int getBoosrtime() {
		return this.boosrtime;
	}

	public void setBoosrtime(int boosrtime) {
		this.boosrtime = boosrtime;
	}

	public int getBoosnum() {
		return this.boosnum;
	}

	public void setBoosnum(int boosnum) {
		this.boosnum = boosnum;
	}

	public int getBoosgpk() {
		return this.boosgpk;
	}

	public void setBoosgpk(int boosgpk) {
		this.boosgpk = boosgpk;
	}
}
