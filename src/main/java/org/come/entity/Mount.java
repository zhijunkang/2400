package org.come.entity;

import java.math.BigDecimal;
import java.util.List;
/**
 * 坐骑表
 * @author 叶豪芳
 * @date 2017年11月27日 下午7:28:40 
 * 
 */ 
public class Mount implements Cloneable{
	// 表ID
	private BigDecimal mid;
	// 坐骑ID
	private Integer mountid;
	// 坐骑名称
	private String mountname;
	// 坐骑等级
	private Integer mountlvl;
	// 体力
	private Integer live;
	// 灵性
	private Integer spri;
	// 力量
	private Integer power;
	// 根骨
	private Integer bone;
	// 经验
	private Integer exp;
	// 角色ID
	private BigDecimal roleid;
	// 管制的召唤兽
	private BigDecimal sid;
	// 管制的召唤兽  
	private BigDecimal othrersid;
	// 升级所需经验
	private Integer gradeexp;
	// 坐骑技能
	List<MountSkill> mountskill;
	// 使用筋骨提气丹的次数
	private Integer useNumber;
	// 熟练度
	private Integer Proficiency;
	// 
	private Integer moveGrade;//飞行坐骑移动速度
	//TODO 管制的召唤兽
	private BigDecimal sid3;
	private BigDecimal sid4;
	private BigDecimal sid5;
	public BigDecimal getMid() {
		return this.mid;
	}
	public void setMid(BigDecimal mid) {
		this.mid = mid;
	}
	public Integer getMountid() {
		return this.mountid;
	}
	public void setMountid(Integer mountid) {
		this.mountid = mountid;
	}
	public String getMountname() {
		return this.mountname;
	}
	public void setMountname(String mountname) {
		this.mountname = mountname;
	}
	public Integer getMountlvl() {
		return this.mountlvl;
	}
	public void setMountlvl(Integer mountlvl) {
		this.mountlvl = mountlvl;
	}
	public Integer getLive() {
		return this.live;
	}
	public void setLive(Integer live) {
		this.live = live;
	}
	public Integer getSpri() {
		return this.spri;
	}
	public void setSpri(Integer spri) {
		this.spri = spri;
	}
	public Integer getPower() {
		return this.power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getBone() {
		return this.bone;
	}
	public void setBone(Integer bone) {
		this.bone = bone;
	}
	public Integer getExp() {
		return this.exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public BigDecimal getRoleid() {
		return this.roleid;
	}
	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}
	public BigDecimal getSid() {
		return this.sid;
	}
	public void setSid(BigDecimal sid) {
		this.sid = sid;
	}
	public BigDecimal getOthrersid() {
		return this.othrersid;
	}
	public void setOthrersid(BigDecimal othrersid) {
		this.othrersid = othrersid;
	}
	public Integer getGradeexp() {
		return this.gradeexp;
	}
	public void setGradeexp(Integer gradeexp) {
		this.gradeexp = gradeexp;
	}
	public List<MountSkill> getMountskill() {
		return this.mountskill;
	}
	public void setMountskill(List<MountSkill> mountskill) {
		this.mountskill = mountskill;
	}
	public Integer getUseNumber() {
		return this.useNumber;
	}
	public void setUseNumber(Integer useNumber) {
		this.useNumber = useNumber;
	}
	public Integer getProficiency() {
		return this.Proficiency;
	}
	public void setProficiency(Integer proficiency) {
		this.Proficiency = proficiency;
	}
	public BigDecimal getSid3() {
		return this.sid3;
	}
	public void setSid3(BigDecimal sid3) {
		this.sid3 = sid3;
	}	
		public BigDecimal getSid4() {
		return this.sid4;
	}
	public void setSid4(BigDecimal sid4) {
		this.sid4 = sid4;
	}
	
		public BigDecimal getSid5() {
		return this.sid5;
	}
	public void setSid5(BigDecimal sid5) {
		this.sid5 = sid5;
	}
	
	public Integer getMoveGrade() {
		return moveGrade;
	}
	public void setMoveGrade(Integer moveGrade) {
		this.moveGrade = moveGrade;
	}
	@Override
	public Mount clone(){
		try {
			return (Mount) super.clone();		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}