package org.come.bean;

public class AccountBinding {

	private String type;// 操作类型 ( binding 进行绑定 / getbinding 获取是否有绑定 )

	private String username;// 账号
	private String password;// 密码
	private String safely;// 安全码
	private String tuiji;// 推荐码

	private String phone;// 手机号
	private String flag;// 账号标识

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSafely() {
		return this.safely;
	}

	public void setSafely(String safely) {
		this.safely = safely;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTuiji() {
		return this.tuiji;
	}

	public void setTuiji(String tuiji) {
		this.tuiji = tuiji;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
