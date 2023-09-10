package org.come.entity;

import java.math.BigDecimal;

public class GangBattle {

	//周数
	private BigDecimal week;
	//json数据
	private String value;
	public BigDecimal getWeek() {
		return this.week;
	}
	public void setWeek(BigDecimal week) {
		this.week = week;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
