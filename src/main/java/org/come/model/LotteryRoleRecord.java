package org.come.model;

import java.math.BigDecimal;

/**
 * 全民竞猜
 * 角色竞猜记录
 * @author Administrator
 *
 */
public class LotteryRoleRecord {

	//角色ID
	private BigDecimal role_id;
	// 购买的开奖号码
	private String prizeNumber;
	// 开奖期数
	private int stage;
	// 购买金额
	private int money;
	// 是否中奖
	private String ifWin;
	
	public BigDecimal getRole_id() {
		return role_id;
	}
	public void setRole_id(BigDecimal role_id) {
		this.role_id = role_id;
	}
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getIfWin() {
		return ifWin;
	}
	public void setIfWin(String ifWin) {
		this.ifWin = ifWin;
	}
}
