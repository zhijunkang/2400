package org.come.model;

import java.math.BigDecimal;

import org.come.entity.BuyCount;

/**
 * 商城类
 * 
 * @author 叶豪芳
 * @date : 2017年11月29日 下午3:21:29
 */
public class Shop {
	// 物品id
	private String shopid;	
	// 物品id [1]
	private BigDecimal shopiid;
	// 名称
	private String shopname;
	// 类型
	private int shoptype;
	// 价格
	private long shopprice;
	// 皮肤
	private String shopskin;
	// 说明
	private String shoptext;
	//等级条件
	private transient String lvl;
	//最大次数0就是没限制
	private transient int num;
	//价格递增数量
	private transient int priceNum;
	private transient int[] lvls;
	private Boolean isPrice;//变动价格
	private transient BuyCount buyCount;
	public Shop() {
		// TODO Auto-generated constructor stub
	}
	public long getPrice(){
		if (this.priceNum==0) {
			return this.shopprice;
		}
		return this.buyCount.countPrice(1, this.priceNum, this.shopprice);
	}
	public long getPrice(int num){
		if (this.priceNum==0) {
			return this.shopprice*num;
		}
		return this.buyCount.countPrice(num, this.priceNum, this.shopprice);
	}
	public boolean addPrice(int num,long jg){
		if (this.priceNum==0) {
			this.buyCount.addCount(num, jg);
			return false;
		}
		int size=(int) (this.buyCount.getWeekNum()/this.priceNum);
		this.buyCount.addCount(num, jg);
		return this.buyCount.getWeekNum()/this.priceNum!=size;
	}
	public String getShopid() {
		return this.shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public BigDecimal getShopiid() {
		return this.shopiid;
	}
	public void setShopiid(BigDecimal shopiid) {
		this.shopiid = shopiid;
	}
	public String getShopname() {
		return this.shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public int getShoptype() {
		return this.shoptype;
	}
	public void setShoptype(int shoptype) {
		this.shoptype = shoptype;
	}
	public long getShopprice() {
		return this.shopprice;
	}
	public void setShopprice(long shopprice) {
		this.shopprice = shopprice;
	}
	public String getShopskin() {
		return this.shopskin;
	}
	public void setShopskin(String shopskin) {
		this.shopskin = shopskin;
	}
	public String getShoptext() {
		return this.shoptext;
	}
	public void setShoptext(String shoptext) {
		this.shoptext = shoptext;
	}
	public String getLvl() {
		return this.lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int[] getLvls() {
		return this.lvls;
	}
	public void setLvls(int[] lvls) {
		this.lvls = lvls;
	}
	public int getPriceNum() {
		return this.priceNum;
	}
	public void setPriceNum(int priceNum) {
		this.priceNum = priceNum;
	}
	public BuyCount getBuyCount() {
		return this.buyCount;
	}
	public void setBuyCount(BuyCount buyCount) {
		this.buyCount = buyCount;
	}
	public Boolean getIsPrice() {
		return this.isPrice;
	}
	public void setIsPrice(Boolean isPrice) {
		this.isPrice = isPrice;
	}
	
}
