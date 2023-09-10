package come.tool.PK;

import java.math.BigDecimal;

public class PalacePkBean {
	
	private int PId;//战书ID
	private String username;//要挑战的人物姓名
	private int type;//类型   0正常皇宫PK  1是擂台赛     
	private int Ntype;//NPC类型
	private BigDecimal gold;//下注的金币数
	private BigDecimal xianyu; //下注的仙玉数
	private BigDecimal exp;//下注的经验数
	private String sendStr;//铃铛内容
	private int choices = 0;//勾选下战书和铃铛
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public BigDecimal getGold() {
		return this.gold;
	}
	public void setGold(BigDecimal gold) {
		this.gold = gold;
	}
	public BigDecimal getXianyu() {
		return this.xianyu;
	}
	public void setXianyu(BigDecimal xianyu) {
		this.xianyu = xianyu;
	}
	public BigDecimal getExp() {
		return this.exp;
	}
	public void setExp(BigDecimal exp) {
		this.exp = exp;
	}
	public int getNtype() {
		return this.Ntype;
	}
	public void setNtype(int ntype) {
		this.Ntype = ntype;
	}
	public int getPId() {
		return this.PId;
	}
	public void setPId(int pId) {
		this.PId = pId;
	}
	public String getSendStr() {
		return this.sendStr;
	}
	public void setSendStr(String sendStr) {
		this.sendStr = sendStr;
	}
	public int getChoices() {
		return this.choices;
	}
	public void setChoices(int choices) {
		this.choices = choices;
	}
	
	
}
