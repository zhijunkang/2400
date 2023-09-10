package org.come.model;

import come.tool.Good.DropModel;

public class Achieve {
	
	private int id;//ID
	private String name;//名称
	private String skin;//皮肤  路径在item文件夹
	private int num;//目标数
	private transient String dropId;//奖励id
	private String color;//展示的颜色
	private transient DropModel dropModel;//奖励id
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkin() {
		return this.skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDropId() {
		return this.dropId;
	}
	public void setDropId(String dropId) {
		this.dropId = dropId;
	}
	public DropModel getDropModel() {
		return this.dropModel;
	}
	public void setDropModel(DropModel dropModel) {
		this.dropModel = dropModel;
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
