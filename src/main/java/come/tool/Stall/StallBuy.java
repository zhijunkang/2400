package come.tool.Stall;

import java.math.BigDecimal;

public class StallBuy {
	//购买的摊位id
	private int id;
	//购买的玩家id
	private BigDecimal roleid;
	//购买的类型
	private int type;
	//购买的id
	private BigDecimal buyid; 
    //购买的数量
	private int sum;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getRoleid() {
		return this.roleid;
	}
	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public BigDecimal getBuyid() {
		return this.buyid;
	}
	public void setBuyid(BigDecimal buyid) {
		this.buyid = buyid;
	}
	public int getSum() {
		return this.sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}
