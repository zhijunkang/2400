package org.come.bean;

import java.math.BigDecimal;

/**
 * 购买物品的bean
 * @author 叶豪芳
 * @date 2017年12月24日 下午2:56:07
 * 
 */ 
public class BuyGoodsBean {
	// 数量
	private int sum;
	// 0表示商城 1npc商店
	private int Originate;
	// ID
	private BigDecimal goodId;
	// 单价
	private BigDecimal price;
	//人物的积分数据
	private String Score;
	public String getScore() {
		return this.Score;
	}
	public void setScore(String score) {
		this.Score = score;
	}
	public int getSum() {
		return this.sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getOriginate() {
		return this.Originate;
	}
	public void setOriginate(int originate) {
		this.Originate = originate;
	}
	public BigDecimal getGoodId() {
		return this.goodId;
	}
	public void setGoodId(BigDecimal goodId) {
		this.goodId = goodId;
	}
	public BigDecimal getPrice() {
		return this.price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
