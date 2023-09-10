package org.come.action.lottery;

import java.math.BigDecimal;

import org.come.server.GameServer;

import come.tool.Good.DropUtil;

public class Draw {

	
	private int did;
	private String name;
	private int integral;
	private BigDecimal money;
	private String goods;
	private DrawBase[] drawBases;
	private BigDecimal goodid;//替代消耗的物品id
	private int moneyType;//货币的类型 0仙玉:1大话币
	
	private String text;
	/**抽出一个DrawBase*/
	public DrawBase rDrawBase(){
		for (int i = 0; i < this.drawBases.length; i++) {
			if (DropUtil.isV(this.drawBases[i].getV())) {
				return this.drawBases[i];
			}
		}
		return this.drawBases[this.drawBases.length-1];
	}
	/**其他填充奖项*/
	public DrawBase rDrawBase2(){
		if (this.drawBases.length==1) {return this.drawBases[0];}
		int v=GameServer.random.nextInt(this.drawBases.length);
		if (DropUtil.isV(60)) {v+=this.drawBases.length;v/=2;}
		return this.drawBases[v];
	}
	public int getDid() {
		return this.did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public DrawBase[] getDrawBases() {
		return this.drawBases;
	}
	public void setDrawBases(DrawBase[] drawBases) {
		this.drawBases = drawBases;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntegral() {
		return this.integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public String getGoods() {
		return this.goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public BigDecimal getMoney() {
		return this.money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public BigDecimal getGoodid() {
		return this.goodid;
	}
	public void setGoodid(BigDecimal goodid) {
		this.goodid = goodid;
	}
	public int getMoneyType() {
		return this.moneyType;
	}
	public void setMoneyType(int moneyType) {
		this.moneyType = moneyType;
	}
	
}
