package come.tool.PK;
/**
 * PK投注
 * @author Administrator
 */
public class PKStake {
    private long charge;//手续费
 	private long money; //下注金钱
 	private long xianYu;//下注仙玉
 	private long exp;   //下注经验
	public PKStake(long charge, long money, long xianYu) {
		super();
		this.charge = charge;
		this.money = money;
		this.xianYu = xianYu;
	}
	public PKStake(long charge, long money, long xianYu, long exp) {
		super();
		this.charge = charge;
		this.money = money;
		this.xianYu = xianYu;
		this.exp = exp;
	}
    public void qk(){
    	this.charge=0;
    	this.money=0;
    	this.xianYu=0;
    	this.exp=0;
    }
	
	public long getCharge() {
		return this.charge;
	}
	public void setCharge(long charge) {
		this.charge = charge;
	}
	public long getMoney() {
		return this.money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public long getXianYu() {
		return this.xianYu;
	}
	public void setXianYu(long xianYu) {
		this.xianYu = xianYu;
	}
	public long getExp() {
		return this.exp;
	}
	public void setExp(long exp) {
		this.exp = exp;
	}
}
