package org.come.extInterBean;

public class ShopBuyRecordResultBean {
	// 物品id
	private String gid;
	// 价格
	private String price;
	// 物品数量
	private String goodnumber;
	// 总金额
	private String numbermoney;
	// 记录时间
	private String recordtime;
	// 购买类型
	private String typename;
	// 账号
	private String username;
	// 角色名
	private String rolename;

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGoodnumber() {
		return this.goodnumber;
	}

	public void setGoodnumber(String goodnumber) {
		this.goodnumber = goodnumber;
	}

	public String getNumbermoney() {
		return this.numbermoney;
	}

	public void setNumbermoney(String numbermoney) {
		this.numbermoney = numbermoney;
	}

	public String getRecordtime() {
		return this.recordtime;
	}

	public void setRecordtime(String recordtime) {
		this.recordtime = recordtime;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
