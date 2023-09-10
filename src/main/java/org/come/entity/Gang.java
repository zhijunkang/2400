package org.come.entity;

import java.math.BigDecimal;
/**
 * 帮派bean
 * @author 叶豪芳
 * @date : 2017年11月27日 上午10:05:53
 */
public class Gang {	
	//帮派ID
    private BigDecimal gangid;
    //帮派名称
    private String gangname;
    //成员数量
    private BigDecimal gangnumber;
    //建设值
    private BigDecimal builder;
    //帮派财产
    private BigDecimal property;
	//等级
    private BigDecimal ganggrade;
    //创始人
    private String founder;
    //帮主
    private String gangbelong;
    //帮派宗旨
    private String introduction;
    //建筑情况
    private transient String gangTxt;
    public BigDecimal getGangid() {
        return this.gangid;
    }

    public void setGangid(BigDecimal gangid) {
        this.gangid = gangid;
    }

    public String getGangname() {
        return this.gangname;
    }

    public void setGangname(String gangname) {
        this.gangname = gangname == null ? null : gangname.trim();
    }

    public BigDecimal getGangnumber() {
        return this.gangnumber;
    }

    public void setGangnumber(BigDecimal gangnumber) {
        this.gangnumber = gangnumber;
    }

    public BigDecimal getBuilder() {
        return this.builder;
    }

    public void setBuilder(BigDecimal builder) {
        this.builder = builder;
    }
    
    public BigDecimal getProperty() {
		return this.property;
	}

	public void setProperty(BigDecimal property) {
		this.property = property;
	}
    
    public BigDecimal getGanggrade() {
        return this.ganggrade;
    }

    public void setGanggrade(BigDecimal ganggrade) {
        this.ganggrade = ganggrade;
    }

    public String getFounder() {
        return this.founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getGangbelong() {
        return this.gangbelong;
    }

    public void setGangbelong(String gangbelong) {
        this.gangbelong = gangbelong == null ? null : gangbelong.trim();
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

	public String getGangTxt() {
		return this.gangTxt;
	}

	public void setGangTxt(String gangTxt) {
		this.gangTxt = gangTxt;
	}
    
}