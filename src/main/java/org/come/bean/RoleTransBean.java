package org.come.bean;

import java.util.List;

import org.come.entity.Mount;

import come.tool.Role.PrivateData;
import org.come.entity.RoleAttribute;

public class RoleTransBean {

	private LoginResult loginResult;
	private PrivateData privateData;
	private List<Mount> mounts;
	RoleAttribute roleAttribute;
	public LoginResult getLoginResult() {
		return this.loginResult;
	}
	public void setLoginResult(LoginResult loginResult) {
		this.loginResult = loginResult;
	}
	public PrivateData getPrivateData() {
		return this.privateData;
	}
	public void setPrivateData(PrivateData privateData) {
		this.privateData = privateData;
	}
	public List<Mount> getMounts() {
		return this.mounts;
	}
	public void setMounts(List<Mount> mounts) {
		this.mounts = mounts;
	}

	public RoleAttribute getRoleAttribute() {
		return roleAttribute;
	}

	public void setRoleAttribute(RoleAttribute roleAttribute) {
		this.roleAttribute = roleAttribute;
	}
}
