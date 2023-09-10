package org.come.bean;

public class ConfirmBean {
	//47://升级帮派等级 48://升级科技等级 49://升级驯养师等级
	//101购买竞技场次数
	//102二次确认拆卸
	private int type;//类型
	private String MSG;//提示语
	private String value;//额外数据
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMSG() {
		return this.MSG;
	}
	public void setMSG(String mSG) {
		this.MSG = mSG;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
