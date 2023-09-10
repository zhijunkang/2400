package come.tool.Role;

import java.util.concurrent.ConcurrentHashMap;

import org.come.bean.UseCardBean;
import org.come.entity.PayvipBean;
import org.come.server.GameServer;


public class PrivateData {
	// 记录完成次数
	private String taskComplete;
	//记录任务数据
 	private String taskData;
	//技能集合 技能名字=熟练度|技能名字=熟练度
	private String Skills;
	private String born;
    //定时物品效果使用
    private String TimingGood;
    //重置双倍时间
 	private transient Integer DBExp;
 	
    /**初始化时效道具*/
	public ConcurrentHashMap<String,UseCardBean> initLimit(long money){
		ConcurrentHashMap<String,UseCardBean> map=new ConcurrentHashMap<>();
      	if (this.TimingGood!=null&&!this.TimingGood.equals("")) {
      	    //时效名#时效类型#时效皮肤#剩余时效#时效描述
            String[] v=this.TimingGood.split("\\^");
      		for (int i = 0; i < v.length; i++) {
      			String[] vs=v[i].split("#");
      			map.put(vs[1], new UseCardBean(vs[0], vs[1], vs[2],Long.parseLong(vs[3])*60000,vs.length>4?vs[4]:null));
      		}
      	}
        
      	if (money!=0) {
      		PayvipBean vipBean=GameServer.getVIP(money);
    		if (vipBean!=null) {
    			UseCardBean limit=new UseCardBean("VIP"+vipBean.getGrade(),"SVIP","S"+(19+vipBean.getGrade()),0,vipBean.getIncreationtext());
    			map.put(limit.getType(),limit);
    			if (this.TimingGood!=null&&!this.TimingGood.equals("")) {
    				this.TimingGood=this.TimingGood+"^"+limit.getName()+"#"+limit.getType()+"#"+limit.getSkin()+"#"+limit.getTime()+"#"+limit.getValue();
    			}else {
    				this.TimingGood=limit.getName()+"#"+limit.getType()+"#"+limit.getSkin()+"#"+limit.getTime()+"#"+limit.getValue();
    			}
    		}	
		}	
  		return map;
    }
	public String getTaskComplete() {
		if (this.taskComplete==null) {
			return "";
		}
		return this.taskComplete;
	}
	public void setTaskComplete(String taskComplete) {
		this.taskComplete = taskComplete;
	}
	public String getTaskData() {
		return this.taskData;
	}
	public void setTaskData(String taskData) {
		this.taskData = taskData;
	}
	public Integer getDBExp() {
		if (this.DBExp==null) {
			return 0;
		}
		return this.DBExp;
	}
	public void setDBExp(Integer dBExp) {
		this.DBExp = dBExp;
	}
	public String getSkills() {
		if (this.Skills==null) {return "";}
		return this.Skills;
	}
	public void setSkills(String skills) {
		this.Skills = skills;
	}
	public String getBorn() {
		if (this.born==null) {return "";}
		return this.born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	public String getTimingGood() {
		return this.TimingGood;
	}
	public void setTimingGood(String timingGood) {
		this.TimingGood = timingGood;
	}
	public String[] getSkill(String type) {
		if (this.Skills == null || this.Skills.equals("")) {
			return null;
		}
		String[] vs = this.Skills.split("\\|");
		for (int i = 0; i < vs.length; i++) {
			if (vs[i].startsWith(type)) {
				return vs[i].substring(1).split("#");
			}
		}
		return null;
	}
	public boolean isSkill(String type) {
		if (this.Skills == null || this.Skills.equals("")) {
			return false;
		}
		String[] vs = this.Skills.split("\\|");
		for (int i = 0; i < vs.length; i++) {
			if (vs[i].startsWith(type)) {
				return true;
			}
		}
		return false;
	}
	/** 修改技能 */
	// 技能集合 前缀#技能ID*熟练度#技能ID*熟练度|前缀#技能id*等级
	// S技能 T天演策 F法门 Q其他
	public void setSkills(String type, String skill) {
		if (this.Skills == null || this.Skills.equals("")) {
			if (skill != null && !skill.equals("")) {
				this.Skills = type + skill;
			}
			return;
		}
		StringBuffer buffer = new StringBuffer();
		String[] vs = this.Skills.split("\\|");
		for (int i = 0; i < vs.length; i++) {
			if (!vs[i].startsWith(type)) {
				if (buffer.length() != 0) {
					buffer.append("|");
				}
				buffer.append(vs[i]);
			}
		}
		if (skill != null && !skill.equals("")) {
			if (buffer.length() != 0) {
				buffer.append("|");
			}
			buffer.append(type);
			buffer.append(skill);
		}
		this.Skills = buffer.toString();
	}
}
