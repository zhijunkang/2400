package org.come.entity;

import java.math.BigDecimal;

/**
 * 三端
 * 
 * @author zz
 * @time 2019年7月17日14:16:18
 * 
 */
public class RegionResult {

	// 地域名称
	private String RE_NAME;
	// 区域ID
	private BigDecimal RA_ID;
	// 区域名称
	private String RA_NAME;
	//
	private String OT_BELONG;

	public RegionResult() {
		// TODO Auto-generated constructor stub
	}

	public String getRE_NAME() {
		return this.RE_NAME;
	}

	public void setRE_NAME(String rE_NAME) {
		this.RE_NAME = rE_NAME;
	}

	public BigDecimal getRA_ID() {
		return this.RA_ID;
	}

	public void setRA_ID(BigDecimal rA_ID) {
		this.RA_ID = rA_ID;
	}

	public String getRA_NAME() {
		return this.RA_NAME;
	}

	public void setRA_NAME(String rA_NAME) {
		this.RA_NAME = rA_NAME;
	}

	public String getOT_BELONG() {
		return this.OT_BELONG;
	}

	public void setOT_BELONG(String oT_BELONG) {
		this.OT_BELONG = oT_BELONG;
	}

}
