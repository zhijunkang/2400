package org.come.bean;

public class QuoteOutBean {
       
	//数据
	private String data;
	//扣除代价类型
	private int type;
	//扣除值
	private long value;
	public String getData() {
		return this.data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getValue() {
		return this.value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	
}
