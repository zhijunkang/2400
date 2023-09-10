package come.tool.FightingData;

import java.util.ArrayList;
import java.util.List;

public class ChangeFighting {
    //改变的血量
	private int Changehp;
    //改变的蓝量	
	private int Changemp;
    //改变后的状态
	private int Changestate;
    //持续回合的类型
    private String Changetype;
    //持续回合的数值
    private double Changevlaue;
    //持续回合的数值2
    private double Changevlaue2;
    //持续回合的回合数	
    private int Changesum;
    //装载的技能 技能取消后产生的反应
    private List<FightingSkill> skills;
    //额外处理类型
    private String Changetype2;
    public ChangeFighting() {
		// TODO Auto-generated constructor stub
    	this.Changehp=0;
    	this.Changemp=0;
    	this.Changestate=0;
    	this.Changevlaue=0;
    	this.Changevlaue2=0;
    	this.Changesum=0;
	}
	public int getChangehp() {
		return this.Changehp;
	}
	public void setChangehp(int changehp) {
		this.Changehp = changehp;
	}
	public int getChangemp() {
		return this.Changemp;
	}
	public void setChangemp(int changemp) {
		this.Changemp = changemp;
	}
	public int getChangestate() {
		return this.Changestate;
	}
	public void setChangestate(int changestate) {
		this.Changestate = changestate;
	}
	public String getChangetype() {
		if (this.Changetype==null) {this.Changetype="";}
		return this.Changetype;
	}
	public void setChangetype(String changetype) {
		this.Changetype = changetype;
	}
	public int getChangesum() {
		return this.Changesum;
	}
	public void setChangesum(int changesum) {
		this.Changesum = changesum;
	}
	public double getChangevlaue() {
		return this.Changevlaue;
	}
	public void setChangevlaue(double changevlaue) {
		this.Changevlaue = changevlaue;
	}
	public double getChangevlaue2() {
		return this.Changevlaue2;
	}
	public void setChangevlaue2(double changevlaue2) {
		this.Changevlaue2 = changevlaue2;
	}
	public List<FightingSkill> getSkills() {
		return this.skills;
	}
	public void setSkills(List<FightingSkill> skills) {
		this.skills = skills;
	}
	public FightingSkill getSkill(int id) {
		if (this.skills==null) {
			return null;
		}
		for (int i = this.skills.size()-1;i>=0; i--) {
			if (this.skills.get(i).getSkillid()==id) {
				return this.skills.get(i);
			}
		}
		return null;
	}
	public void setSkill(FightingSkill skill) {
		if (this.skills==null) {
			this.skills=new ArrayList<>();
		}
		this.skills.add(skill);
	}
	public String getChangetype2() {
		return this.Changetype2;
	}
	public void setChangetype2(String changetype2) {
		this.Changetype2 = changetype2;
	}
	
    
}
