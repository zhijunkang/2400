package org.come.bean;

/**
 * 灵宝技能
 * @author Administrator
 *
 */
public class LingSkill {
    //技能名称
	private String skillname;
	//技能合计数
	private int skillsum;
	//技能作用人数
	private int Effectsum;	
	//是否为擅长技能
	private boolean shanchang=false;
	
	public String getSkillname() {
		return this.skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public int getSkillsum() {
		return this.skillsum;
	}
	public void setSkillsum(int skillsum) {
		this.skillsum = skillsum;
	}
	public int getEffectsum() {
		return this.Effectsum;
	}
	public void setEffectsum(int effectsum) {
		this.Effectsum = effectsum;
	}

	public boolean isShanchang() {
		return this.shanchang;
	}

	public void setShanchang(boolean shanchang) {
		this.shanchang = shanchang;
	}
	
	
	
}
