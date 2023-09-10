package org.come.model;

import java.math.BigDecimal;

import org.come.entity.Goodstable;
/**
 * 角色背包物品bean
 * @author 叶豪芳
 * @date : 2017年11月27日 上午10:06:42
 */
public class GoodModel{
    // 物品ID
    private BigDecimal goodsid;
    // 物品名称
    private String goodsname;
    // 皮肤
    private String skin;
    // 物品类型
    private long type;
    // 贵重
    private Long quality;
	// 物品功能
    private String value;
    // 物品说明
    private String instruction;
    public GoodModel(Goodstable good) {
		// TODO Auto-generated constructor stub
    	this.goodsid=good.getGoodsid();
    	this.goodsname=good.getGoodsname();
    	this.skin=good.getSkin();
    	this.type=good.getType();
    	this.quality=good.getQuality();
    	if (this.type==112||this.type==60001) {
    		this.value=good.getValue();
			if (this.type==60001 || this.type==60002) {
				this.instruction=good.getInstruction();
			}
		}
    	this.instruction=good.getInstruction();
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
	public long getType() {
		return this.type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public Long getQuality() {
		return this.quality;
	}
	public void setQuality(Long quality) {
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

}