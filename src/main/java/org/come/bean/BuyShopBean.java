package org.come.bean;

public class BuyShopBean {
	private int sum;
	//0表示商城 1npc商店  3限购
	private int ate;
	//限购npc标识
	private Integer nId;
	//id
	private String cd;
	public int getSum() {
		return this.sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAte() {
		return this.ate;
	}
	public void setAte(int ate) {
		this.ate = ate;
	}
	public String getCd() {
		return this.cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public Integer getnId() {
		return this.nId;
	}
	public void setnId(Integer nId) {
		this.nId = nId;
	}
	
}
