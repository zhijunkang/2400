package org.come.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 三端
 * 区域表bean
 * 
 * @author zz
 * @time 2019年7月15日16:19:04
 * 
 */
public class Region {

	// 大区域id
	private BigDecimal regionId;
	// 大区域名称
	private String regionName;
	// 大区域创建时间
	private Date regionCreTime;
	// 大区域修改时间
	private Date regionModTime;
	// 区id
	private BigDecimal regionAllId;
	// 区名称
	private String regionAllName;

	public Region() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getRegionId() {
		return this.regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Date getRegionCreTime() {
		return this.regionCreTime;
	}

	public void setRegionCreTime(Date regionCreTime) {
		this.regionCreTime = regionCreTime;
	}

	public Date getRegionModTime() {
		return this.regionModTime;
	}

	public void setRegionModTime(Date regionModTime) {
		this.regionModTime = regionModTime;
	}

	public BigDecimal getRegionAllId() {
		return this.regionAllId;
	}

	public void setRegionAllId(BigDecimal regionAllId) {
		this.regionAllId = regionAllId;
	}

	public String getRegionAllName() {
		return this.regionAllName;
	}

	public void setRegionAllName(String regionAllName) {
		this.regionAllName = regionAllName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Region [regionId=");
		builder.append(this.regionId);
		builder.append(", regionName=");
		builder.append(this.regionName);
		builder.append(", regionCreTime=");
		builder.append(this.regionCreTime);
		builder.append(", regionModTime=");
		builder.append(this.regionModTime);
		builder.append(", regionAllId=");
		builder.append(this.regionAllId);
		builder.append(", regionAllName=");
		builder.append(this.regionAllName);
		builder.append("]");
		return builder.toString();
	}

}
