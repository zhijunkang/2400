package come.tool.Scene.LaborDay;

import java.util.List;

public class LaborRank {
	private int type;//0全服累充  1抽奖次数
	private List<LaborRole> roles;//排行榜的数据
	private LaborRole role;//自己的数据
	private int rank;//自己的名次
	private String value;//额外数据备用字段
	private String value1;//额外数据备用字段
	
	public LaborRank(int type) {
		super();
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<LaborRole> getRoles() {
		return this.roles;
	}
	public void setRoles(List<LaborRole> roles) {
		this.roles = roles;
	}
	public LaborRole getRole() {
		return this.role;
	}
	public void setRole(LaborRole role) {
		this.role = role;
	}
	public int getRank() {
		return this.rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	
}
