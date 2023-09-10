package org.come.entity;

import org.come.until.AllServiceUtil;

/**购买统计*/
public class BuyCount {
	private long Bid;//表id
	private int Ptype;//商店类型  0商城  1npc商店
	private int shopId;//商品id
	private int shopType;//商品分类
	private long totalNum;//总销售
	private long totalPrice;//总消耗货币
	private long weekNum;//周销售
	private long weekPrice;//周消耗货币
	private long dayNum;//日销售
	private long dayPrice;//日消耗货币
	
	private Boolean isUP=false;//是否被修改
	/**添加销售记录*/
	public void addCount(int sum,long price){
		synchronized (this.isUP) {
			this.totalNum+=sum;
			this.weekNum+=sum;
			this.dayNum+=sum;
			this.totalPrice+=price;
			this.weekPrice+=price;
			this.dayPrice+=price;
			this.isUP=true;
		}
	}
	/**每日刷新 day=2是周一*/
	public void Reset(int day){
		synchronized (this.isUP) {
			if (this.dayNum!=0||(day==2&&this.weekNum!=0)) {
				this.isUP=true;
			}
			this.dayNum=0;
			this.dayPrice=0;
			if (day==2) {
				this.weekNum=0;
				this.weekPrice=0;
			}		
		}
	}
	/**保存数据库*/
	public void upData(){
		synchronized (this.isUP) {
			if (this.isUP) {
				AllServiceUtil.getBuyCountServeice().updateBuyCount(this);
				this.isUP=false;
			}
		}
	}
	/**涨价商品价格获取 原则每次涨价幅度5% 不上限  购买数量  涨价所需购买次数    单价*/
	public long countPrice(int num,int priceNum,long shopPrice){
		synchronized (this.isUP) {
			long price=0;
			for (int i = 0; i < num;) {
				if ((this.weekNum+i)%priceNum==0) {
					int size=num-i;
					if (size>priceNum) {
						size=priceNum;
					}
					price+=(shopPrice*(1+(this.weekNum+i)/priceNum*0.05))*size;
					i+=size;
				}else {
					price+=(shopPrice*(1+(this.weekNum+i)/priceNum*0.05));
					i++;
				}
			}
			return price;	
		}
	}
	public long getBid() {
		return this.Bid;
	}
	public void setBid(long bid) {
		this.Bid = bid;
	}
	public int getPtype() {
		return this.Ptype;
	}
	public void setPtype(int ptype) {
		this.Ptype = ptype;
	}
	public int getShopId() {
		return this.shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getShopType() {
		return this.shopType;
	}
	public void setShopType(int shopType) {
		this.shopType = shopType;
	}
	public long getTotalNum() {
		return this.totalNum;
	}
	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}
	public long getTotalPrice() {
		return this.totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getWeekNum() {
		return this.weekNum;
	}
	public void setWeekNum(long weekNum) {
		this.weekNum = weekNum;
	}
	public long getWeekPrice() {
		return this.weekPrice;
	}
	public void setWeekPrice(long weekPrice) {
		this.weekPrice = weekPrice;
	}
	public long getDayNum() {
		return this.dayNum;
	}
	public void setDayNum(long dayNum) {
		this.dayNum = dayNum;
	}
	public long getDayPrice() {
		return this.dayPrice;
	}
	public void setDayPrice(long dayPrice) {
		this.dayPrice = dayPrice;
	}
	
}
