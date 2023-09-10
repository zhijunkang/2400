package org.come.bean;

import java.util.List;

public class NPCDialog {

	//描述
	private String msg;
	//功能选项
	private List<String> functions;
	private String type;
	public String getMsg() {
		return this.msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getFunctions() {
		return this.functions;
	}
	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
