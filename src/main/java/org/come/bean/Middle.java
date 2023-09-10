package org.come.bean;

import java.math.BigDecimal;

/**
 * 中量级
 * @author Administrator
 * 后续大改做为中量级数据广播
 */
public class Middle {

	//标识 后续这改成id
	private String rolename;
   	//记录完成次数
 	private String taskComplete;
    //坐牢标志  PK点数=身份标志=做天牢次数=每周坐牢次数
   	private String taskDaily;
   	private BigDecimal Dayandpayorno;
   	private BigDecimal Daypaysum;
   	private BigDecimal Daygetorno;
   	private String Vipget;
   	private int Dayfirstinorno;
   	public String getRolename() {
		return this.rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getTaskComplete() {
		return this.taskComplete;
	}
	public void setTaskComplete(String taskComplete) {
		this.taskComplete = taskComplete;
	}
	public String getTaskDaily() {
		return this.taskDaily;
	}
	public void setTaskDaily(String taskDaily) {
		this.taskDaily = taskDaily;
	}
	public BigDecimal getDayandpayorno() {
		return this.Dayandpayorno;
	}
	public void setDayandpayorno(BigDecimal dayandpayorno) {
		this.Dayandpayorno = dayandpayorno;
	}
	public BigDecimal getDaypaysum() {
		return this.Daypaysum;
	}
	public void setDaypaysum(BigDecimal daypaysum) {
		this.Daypaysum = daypaysum;
	}
	public BigDecimal getDaygetorno() {
		return this.Daygetorno;
	}
	public void setDaygetorno(BigDecimal daygetorno) {
		this.Daygetorno = daygetorno;
	}
	public String getVipget() {
		return this.Vipget;
	}
	public void setVipget(String vipget) {
		this.Vipget = vipget;
	}
	public int getDayfirstinorno() {
		return this.Dayfirstinorno;
	}
	public void setDayfirstinorno(int dayfirstinorno) {
		this.Dayfirstinorno = dayfirstinorno;
	}
}
