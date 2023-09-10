package org.come.entity;

public class WingTraining {

	//id
	private int id;
    //备注
	private String text;
	//类型集合
	private String type;
	//基础值
	private String base;
	//值
	private long value;
	//拆解位置
	private int un;
	//
	private double[] bases;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBase() {
		return this.base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public long getValue() {
		return this.value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public int getUn() {
		return this.un;
	}
	public void setUn(int un) {
		this.un = un;
	}
	public double[] getBases() {
		return this.bases;
	}
	public void setBases(double[] bases) {
		this.bases = bases;
	}
	
}
