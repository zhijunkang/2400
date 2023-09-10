package org.come.model;

import java.math.BigDecimal;

import org.come.entity.BuyCount;

public class Lshop implements Cloneable{

	private int id;//id
	private BigDecimal Gid;//物品id
	private int type;//货币类型(0:大话币,1:仙玉)
	private BigDecimal money;//价格
	private int lNum;//限购数量
	private int maxNum;//单次最大购买数
	private int num;//已购买数
	private transient BuyCount buyCount;
	public boolean addPrice(int num,long jg){
		this.buyCount.addCount(num, jg);
		return false;
	}
	public int addNum(int size){
    	if (this.maxNum==0) {return size;}
    	if (this.num>=this.maxNum) {return 0;}
    	this.num+=size;
    	if (this.num>this.maxNum) {
    		size=this.num-this.maxNum;
    		this.num=this.maxNum;
    		return size;
		}
		return size;
    }
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getGid() {
		return this.Gid;
	}
	public void setGid(BigDecimal gid) {
		this.Gid = gid;
	}
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public BigDecimal getMoney() {
		return this.money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	
	public int getlNum() {
		return this.lNum;
	}
	public void setlNum(int lNum) {
		this.lNum = lNum;
	}
	public int getMaxNum() {
		return this.maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public BuyCount getBuyCount() {
		return this.buyCount;
	}
	public void setBuyCount(BuyCount buyCount) {
		this.buyCount = buyCount;
	}
	@Override
	public Lshop clone(){
		try {
			Lshop lshop=(Lshop) super.clone();		
			lshop.buyCount=this.buyCount;
			return lshop;		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
