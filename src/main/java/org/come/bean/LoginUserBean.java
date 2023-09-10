package org.come.bean;
/**
 * 登入bean
 * @author 叶豪芳
 * @date : 2017年11月27日 上午10:07:13
 */
public class LoginUserBean {
	
	private String username;
	private String password;
   	//脚色服务器区号
   	private String serverMeString;
	
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
	public String getServerMeString() {
		return this.serverMeString;
	}
	public void setServerMeString(String serverMeString) {
		this.serverMeString = serverMeString;
	}


	private String yanCode;//通信验证码

	public String getYanCode() {
		return yanCode;
	}

	public void setYanCode(String yanCode) {
		this.yanCode = yanCode;
	}

	public Boolean getMobile() {
		return isMobile;
	}

	public void setMobile(Boolean mobile) {
		isMobile = mobile;
	}

	private Boolean isMobile;//是否移动端请求




}
