package org.come.bean;

import java.math.BigDecimal;

/**
 * 修改名字
 * @author Administrator
 *
 */
public class ChangeRoleNameBean {
	// 旧名字
	private String oldName;
	
	// 新名字
	private String newName;
	
	// 成功标识
	private boolean flag;
	
	// 消耗物品
	private BigDecimal rgid;

	public String getOldName() {
		return this.oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getNewName() {
		return this.newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public boolean isFlag() {
		return this.flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public BigDecimal getRgid() {
		return this.rgid;
	}

	public void setRgid(BigDecimal rgid) {
		this.rgid = rgid;
	}

}
