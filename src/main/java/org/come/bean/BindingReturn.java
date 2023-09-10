package org.come.bean;

import org.come.entity.UserTable;

public class BindingReturn {

	private String type;// 类型
	private String message;// 信息
	private UserTable usertable;// 账号信息

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserTable getUsertable() {
		return this.usertable;
	}

	public void setUsertable(UserTable usertable) {
		this.usertable = usertable;
	}

}
