package org.come.model;

import java.util.List;

import come.tool.Good.DropModel;
import come.tool.Good.TSModel;

/**
 * 地图怪物信息
 * @author 叶豪芳
 * @date 2017年12月28日 上午3:50:16
 * 
 */ 
public class Robots {
	private String robotid;// 怪物ID
	private String robotname;// 怪物名称
	private String robotskin;// 皮肤
//	private String robottitle;// 皮肤
	private transient int robottime;// 存在时间
	private transient String robotlvl;// 怪物等级
	private transient String robotboss;// 主怪
	private transient String robotmonster;// 小怪
	private transient String robotcount;// 数量
	private transient String robotreward;// 掉落类型
	private transient String unknow;
	private transient String lvllimit;//等级限制
	private transient int robotType;//掉落类型
	private transient int dropLimit;//掉落限制
	private transient TSModel tsModel;//掉落限制

	private transient int[] lvls;
	private transient List<Integer> taskIds;
	private transient List<String> monsterList;
	private transient DropModel dropModel;
	private transient boolean isJL;//是否需要记录次数
	
	private transient int robotID;//robotID
	
	public String getRobotid() {
		return this.robotid;
	}
	public void setRobotid(String robotid) {
		this.robotid = robotid;
	}
	public String getRobotname() {
		return this.robotname;
	}
	public void setRobotname(String robotname) {
		this.robotname = robotname;
	}
	public String getRobotskin() {
		return this.robotskin;
	}
	public void setRobotskin(String robotskin) {
		this.robotskin = robotskin;
	}
	public int getRobottime() {
		return this.robottime;
	}
	public void setRobottime(int robottime) {
		this.robottime = robottime;
	}
	public String getRobotlvl() {
		if (this.robotlvl==null||this.robotlvl.equals(""))this.robotlvl="0";
		return this.robotlvl;
	}
	public void setRobotlvl(String robotlvl) {
		this.robotlvl = robotlvl;
	}
	public String getRobotboss() {
		return this.robotboss;
	}
	public void setRobotboss(String robotboss) {
		this.robotboss = robotboss;
	}
	public String getRobotmonster() {
		return this.robotmonster;
	}
	public void setRobotmonster(String robotmonster) {
		this.robotmonster = robotmonster;
	}
	public String getRobotcount() {
		return this.robotcount;
	}
	public void setRobotcount(String robotcount) {
		this.robotcount = robotcount;
	}
	public String getRobotreward() {
		return this.robotreward;
	}
	public void setRobotreward(String robotreward) {
		this.robotreward = robotreward;
	}
	public String getUnknow() {
		return this.unknow;
	}
	public void setUnknow(String unknow) {
		this.unknow = unknow;
	}
	public String getLvllimit() {
		return this.lvllimit;
	}
	public void setLvllimit(String lvllimit) {
		this.lvllimit = lvllimit;
	}
	public int[] getLvls() {
		return this.lvls;
	}
	public void setLvls(int[] lvls) {
		this.lvls = lvls;
	}
	public int getRobotType() {
		return this.robotType;
	}
	public void setRobotType(int robotType) {
		this.robotType = robotType;
	}
	public List<Integer> getTaskIds() {
		return this.taskIds;
	}
	public void setTaskIds(List<Integer> taskIds) {
		this.taskIds = taskIds;
	}
	public List<String> getMonsterList() {
		return this.monsterList;
	}
	public void setMonsterList(List<String> monsterList) {
		this.monsterList = monsterList;
	}
	public DropModel getDropModel() {
		return this.dropModel;
	}
	public void setDropModel(DropModel dropModel) {
		this.dropModel = dropModel;
		if (dropModel!=null) {
			if (dropModel.getExps()!=null||dropModel.getMaxGood()!=null) {
				this.isJL=true;
			}
		}
	}
	public boolean isJL() {
		return this.isJL;
	}
	public void setJL(boolean isJL) {
		this.isJL = isJL;
	}
	public int getDropLimit() {
		return this.dropLimit;
	}
	public void setDropLimit(int dropLimit) {
		this.dropLimit = dropLimit;
	}
	public TSModel getTsModel() {
		return this.tsModel;
	}
	public void setTsModel(TSModel tsModel) {
		this.tsModel = tsModel;
	}
	public int getRobotID() {
		return this.robotID;
	}
	public void setRobotID(int robotID) {
		this.robotID = robotID;
	}
//	public String getRobottitle() {
//		return robottitle;
//	}
//	public void setRobottitle(String robottitle) {
//		this.robottitle = robottitle;
//	}

	
}
