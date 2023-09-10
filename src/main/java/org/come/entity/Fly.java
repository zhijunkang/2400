package org.come.entity;

import java.math.BigDecimal;
import java.util.List;

public class Fly implements Cloneable {
    // 表ID
    private BigDecimal mid;
    // 飞行器ID
    private Integer flytid;
    // 飞行器名称
    private String flyname;
    //飞行器阶位
    private Integer flystate;
    // 飞行器等级
    private Integer flylvl;
    // 经验
    private Integer exp;
    // 角色ID
    private BigDecimal roleid;
    //飞行器
    private Integer skin;
    // 升级所需经验
    private Integer gradeexp;
    // 飞行器技能
    List<FlySkill> flyskill;
    // 燃料
    private Long fuel;
    public BigDecimal getMid() {
        return mid;
    }
    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }
    public Integer getFlytid() {
        return flytid;
    }
    public void setFlytid(Integer mountid) {
        this.flytid = mountid;
    }
    public String getFlyname() {
        return flyname;
    }
    public void setFlyname(String mountname) {
        this.flyname = mountname;
    }
    public Integer getFlylvl() {
        return flylvl;
    }
    public void setFlylvl(Integer mountlvl) {
        this.flylvl = mountlvl;
    }

    public Integer getExp() {
        return exp;
    }
    public void setExp(Integer exp) {
        this.exp = exp;
    }
    public Integer getSkin(){
        return skin;
    }
    public void setSkin(Integer skin){
        this.skin=skin;
    }
    public BigDecimal getRoleid() {
        return roleid;
    }
    public void setRoleid(BigDecimal roleid) {
        this.roleid = roleid;
    }



    public Integer getGradeexp() {
        return gradeexp;
    }
    public void setGradeexp(Integer gradeexp) {
        this.gradeexp = gradeexp;
    }
    public List<FlySkill> getFlyskill() {
        return flyskill;
    }
    public void setMountskill(List<FlySkill> flyskill) {
        this.flyskill = flyskill;
    }
    public  Integer getFlystate(){return flystate;}
    public void setFlystate(Integer flystate){this.flystate=flystate;}

    @Override
    public Fly clone(){
        try {
            return (Fly) super.clone();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
	public Long getFuel() {
		if(fuel == null) {
			fuel = 0L;
		}
		return fuel;
	}
	public void setFuel(Long fuel) {
		this.fuel = fuel;
	}
	public void setFlyskill(List<FlySkill> flyskill) {
		this.flyskill = flyskill;
	}

}
