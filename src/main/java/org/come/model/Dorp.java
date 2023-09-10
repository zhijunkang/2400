package org.come.model;
/**
 * 抽奖信息
 * @author Administrator
 *
 */
public class Dorp {
	// ID
	private Integer dorpId;
	// 类型
	private String dorpType;
	// 值
	private String dorpValue;
	public Integer getDorpId() {
		return this.dorpId;
	}
	public void setDorpId(Integer dorpId) {
		this.dorpId = dorpId;
	}
	public String getDorpType() {
		return this.dorpType;
	}
	public void setDorpType(String dorpType) {
		this.dorpType = dorpType;
	}
	public String getDorpValue() {
		return this.dorpValue;
	}
	public void setDorpValue(String dorpValue) {
		this.dorpValue = dorpValue;
	}
	
}
