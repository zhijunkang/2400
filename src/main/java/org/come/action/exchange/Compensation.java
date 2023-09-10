package org.come.action.exchange;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class Compensation {

	//补偿的CDK
	private String CCDK;
	//补偿的礼包
	private BigDecimal goodId;
	//补偿的时间段
	private long Cmin;
	private long Cmax;
	//补偿的范围 K表示ID  V表示 状态  0未领取 1已经领取
	private ConcurrentHashMap<BigDecimal,Integer> Cmap;
	public Compensation() {
		// TODO Auto-generated constructor stub
		this.Cmap=new ConcurrentHashMap<>();
	}
	/**判断是否在包含的时间内*/
	public boolean contain(long time){
		if (time>this.Cmin&&time<this.Cmax) {
			return true;
		}
		return false;
	}
	/**添加*/
	public void addMap(BigDecimal ID){
		if (this.Cmap.get(ID)==null) {
			this.Cmap.put(ID, 0);
		}
	}
	/**记录领取 0表示不在补偿范围内 1表示可以补偿 2表示已经补偿过了*/
	public int receive(BigDecimal ID){
		Integer id=this.Cmap.get(ID);
		if (id==null) {
			return 0;
		}
		if (id==0) {
			this.Cmap.put(ID, 1);
			return 1;
		}
		return 2;
	}
	public String getCCDK() {
		return this.CCDK;
	}
	public void setCCDK(String cCDK) {
		this.CCDK = cCDK;
	}
	public long getCmin() {
		return this.Cmin;
	}
	public void setCmin(long cmin) {
		this.Cmin = cmin;
	}
	public long getCmax() {
		return this.Cmax;
	}
	public void setCmax(long cmax) {
		this.Cmax = cmax;
	}
	public BigDecimal getGoodId() {
		return this.goodId;
	}
	public void setGoodId(BigDecimal goodId) {
		this.goodId = goodId;
	}
	
}
