package org.come.bean;

import java.math.BigDecimal;

/**
 * 账号表
 * 
 * @author zengr
 * 
 */
public class Account {

	private BigDecimal ac_id;// 表id
	private String ac_account; // 账号
	private String ac_pasw; // 密码
	private String ac_safely; // 安全码
	private String ac_tuijian; // 推荐码
	private String ac_phone; // 手机号
	private String ac_flag;// 标识
	private String ac_loginip;// 登录ip
	private String ac_regip;// 注册ip

	public BigDecimal getAc_id() {
		return this.ac_id;
	}

	public void setAc_id(BigDecimal ac_id) {
		this.ac_id = ac_id;
	}

	public String getAc_account() {
		return this.ac_account;
	}

	public void setAc_account(String ac_account) {
		this.ac_account = ac_account;
	}

	public String getAc_pasw() {
		return this.ac_pasw;
	}

	public void setAc_pasw(String ac_pasw) {
		this.ac_pasw = ac_pasw;
	}

	public String getAc_safely() {
		return this.ac_safely;
	}

	public void setAc_safely(String ac_safely) {
		this.ac_safely = ac_safely;
	}

	public String getAc_tuijian() {
		return this.ac_tuijian;
	}

	public void setAc_tuijian(String ac_tuijian) {
		this.ac_tuijian = ac_tuijian;
	}

	public String getAc_phone() {
		return this.ac_phone;
	}

	public void setAc_phone(String ac_phone) {
		this.ac_phone = ac_phone;
	}

	public String getAc_flag() {
		return this.ac_flag;
	}

	public void setAc_flag(String ac_flag) {
		this.ac_flag = ac_flag;
	}

	public String getAc_loginip() {
		return this.ac_loginip;
	}

	public void setAc_loginip(String ac_loginip) {
		this.ac_loginip = ac_loginip;
	}

	public String getAc_regip() {
		return this.ac_regip;
	}

	public void setAc_regip(String ac_regip) {
		this.ac_regip = ac_regip;
	}

}
