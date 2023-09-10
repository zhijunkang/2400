package org.come.model;
//天资
public class Talent {
	//id
	private int id;
	//天资名称
	private String TalentName;
	//阵营关系
	private int camp;
	//要求
	private String demand;
	//失败率
	private double fail;
	//触发概率
	private double touch;
	//技能属性
	private String value;
	//技能描述
	private String text;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTalentName() {
		return this.TalentName;
	}
	public void setTalentName(String talentName) {
		this.TalentName = talentName;
	}
	public int getCamp() {
		return this.camp;
	}
	public void setCamp(int camp) {
		this.camp = camp;
	}
	public String getDemand() {
		return this.demand;
	}
	public void setDemand(String demand) {
		this.demand = demand;
	}
	public double getFail() {
		return this.fail;
	}
	public void setFail(double fail) {
		this.fail = fail;
	}
	public double getTouch() {
		return this.touch;
	}
	public void setTouch(double touch) {
		this.touch = touch;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
