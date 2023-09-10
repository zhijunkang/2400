package org.come.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Roleorder {
    /**
     * 表ID
     */
    private BigDecimal orderid;

    /**
     * 商品ID
     */
    private BigDecimal saleid;

    /**
     * 下单时间
     */
    private Date buytime;

    /**
     * 状态（1未付钱  2超时 3已付钱 4已取货）
     */
    private Integer status;

    /**
     * 角色ID
     */
    private BigDecimal roleid;

    /**
     * 订单编号
     */
    private String ordernumber;
	/**
	 * 商品名称
	 */
	private String salename;

	/**
	 * 皮肤
	 */
	private String saleskin;

	/**
	 * 价格
	 */
	private BigDecimal saleprice;
	
    /**
     * 类型
     */
    private Integer saletype;

    /**
     * 对应数据库表ID
     */
    private BigDecimal otherid;
    
    
    public Integer getSaletype() {
		return this.saletype;
	}

	public void setSaletype(Integer saletype) {
		this.saletype = saletype;
	}

	public BigDecimal getOtherid() {
		return this.otherid;
	}

	public void setOtherid(BigDecimal otherid) {
		this.otherid = otherid;
	}

	/**
     * 表ID
     * @return ORDERID 表ID
     */
    public BigDecimal getOrderid() {
        return this.orderid;
    }

    /**
     * 表ID
     * @param orderid 表ID
     */
    public void setOrderid(BigDecimal orderid) {
        this.orderid = orderid;
    }

    /**
     * 商品ID
     * @return SALEID 商品ID
     */
    public BigDecimal getSaleid() {
        return this.saleid;
    }

    /**
     * 商品ID
     * @param saleid 商品ID
     */
    public void setSaleid(BigDecimal saleid) {
        this.saleid = saleid;
    }

    /**
     * 下单时间
     * @return BUYTIME 下单时间
     */
    public Date getBuytime() {
        return this.buytime;
    }

    /**
     * 下单时间
     * @param buytime 下单时间
     */
    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    /**
     * 状态（1未付钱  2超时 3已付钱 4已取货）
     * @return STATUS 状态（1未付钱  2超时 3已付钱 4已取货）
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 状态（1未付钱  2超时 3已付钱 4已取货）
     * @param status 状态（1未付钱  2超时 3已付钱 4已取货）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 角色ID
     * @return ROLEID 角色ID
     */
    public BigDecimal getRoleid() {
        return this.roleid;
    }

    /**
     * 角色ID
     * @param roleid 角色ID
     */
    public void setRoleid(BigDecimal roleid) {
        this.roleid = roleid;
    }

    /**
     * 订单编号
     * @return ORDERNUMBER 订单编号
     */
    public String getOrdernumber() {
        return this.ordernumber;
    }

    /**
     * 订单编号
     * @param ordernumber 订单编号
     */
    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

	public String getSalename() {
		return this.salename;
	}

	public void setSalename(String salename) {
		this.salename = salename;
	}

	public String getSaleskin() {
		return this.saleskin;
	}

	public void setSaleskin(String saleskin) {
		this.saleskin = saleskin;
	}

	public BigDecimal getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(BigDecimal saleprice) {
		this.saleprice = saleprice;
	}
    
}