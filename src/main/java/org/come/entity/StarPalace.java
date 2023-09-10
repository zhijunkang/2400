package org.come.entity;

import come.tool.Calculation.BaseQl;

public class StarPalace {

	private String type;//字段类型
	private String value;//字段属性
	private BaseQl[] vs;//拆解
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public BaseQl[] getVs() {
		return this.vs;
	}
	public void setVs(BaseQl[] vs) {
		this.vs = vs;
	}
	
}
