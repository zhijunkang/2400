package org.come.entity;

import java.math.BigDecimal;

/**
 * 坐骑技能
 * @author Administrator
 *
 */
public class MountSkill {
	
	private BigDecimal skillid;
	private String skillname;
	private BigDecimal mid;
	public BigDecimal getSkillid() {
		return this.skillid;
	}
	public void setSkillid(BigDecimal skillid) {
		this.skillid = skillid;
	}
	public String getSkillname() {
		return this.skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public BigDecimal getMid() {
		return this.mid;
	}
	public void setMid(BigDecimal mid) {
		this.mid = mid;
	}


}
