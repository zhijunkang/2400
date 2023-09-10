package org.come.model;

/**
 * 全民竞猜
 * @author Administrator
 *
 */
public class LotteryData {

	// 开奖号码
	private String prizeNumber;
	// 开奖期数
	private int stage = 0;
	// 中奖总人数
	private int total;
	// 总金额
	private int totalMoney;
	public String getPrizeNumber() {
		return prizeNumber;
	}
	public void setPrizeNumber(String prizeNumber) {
		this.prizeNumber = prizeNumber;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
	
}
