package org.come.entity;

import java.math.BigDecimal;

public class GoodsRoleUser {

	private BigDecimal goodsid;
	private String goodsname;
	private String skin;
	private Integer type;// 1 装备 2.当铺 0背包
	private String quality;
	private String value;
	private String instruction;
	private BigDecimal rgid;
	private BigDecimal role_id;
	private String status;
	private String usetime;
	private String defineprice;
	private String mapname;
	private String mapx;
	private String mapy;
	private String price;
	private String codecard;
	private String goodlock;
	private String rolename;
	private BigDecimal user_id;
	private String username;

	// --
	private Integer pageNow;
	private Integer start;
	private Integer end;
	private String orderBy;

	public GoodsRoleUser() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(BigDecimal goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getSkin() {
		return this.skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getQuality() {
		return this.quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public BigDecimal getRgid() {
		return this.rgid;
	}

	public void setRgid(BigDecimal rgid) {
		this.rgid = rgid;
	}

	public BigDecimal getRole_id() {
		return this.role_id;
	}

	public void setRole_id(BigDecimal role_id) {
		this.role_id = role_id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsetime() {
		return this.usetime;
	}

	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}

	public String getDefineprice() {
		return this.defineprice;
	}

	public void setDefineprice(String defineprice) {
		this.defineprice = defineprice;
	}

	public String getMapname() {
		return this.mapname;
	}

	public void setMapname(String mapname) {
		this.mapname = mapname;
	}

	public String getMapx() {
		return this.mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	public String getMapy() {
		return this.mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCodecard() {
		return this.codecard;
	}

	public void setCodecard(String codecard) {
		this.codecard = codecard;
	}

	public String getGoodlock() {
		return this.goodlock;
	}

	public void setGoodlock(String goodlock) {
		this.goodlock = goodlock;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public BigDecimal getUser_id() {
		return this.user_id;
	}

	public void setUser_id(BigDecimal user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getStart() {
		return this.start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return this.end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getPageNow() {
		return this.pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}
