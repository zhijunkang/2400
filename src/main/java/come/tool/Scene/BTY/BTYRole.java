package come.tool.Scene.BTY;

import java.math.BigDecimal;

public class BTYRole {

	private BigDecimal Id;
	private String role;
	private int jf;
	private boolean isAward;
	
	/***/
	public void addJF(int jf){
		this.jf+=jf;
	}
	public BTYRole(BigDecimal id, String role) {
		super();
		this.Id = id;
		this.role = role;
	}
	public BigDecimal getId() {
		return this.Id;
	}
	public void setId(BigDecimal id) {
		this.Id = id;
	}
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getJf() {
		return this.jf;
	}
	public void setJf(int jf) {
		this.jf = jf;
	}
	public boolean isAward() {
		return this.isAward;
	}
	public void setAward(boolean isAward) {
		this.isAward = isAward;
	}
	
}
