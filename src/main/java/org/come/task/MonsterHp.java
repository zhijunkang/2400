package org.come.task;

public class MonsterHp {

	private long hp;//当前生命值
	private long hpMax;//最大生命值
	private boolean isMuch;//true表示多人同时挑战   false 单人挑战
	public MonsterHp() {
		// TODO Auto-generated constructor stub
	}
	public MonsterHp(long hp,boolean isMuch) {
		super();
		this.hp = hp;
		this.hpMax = hp;
		this.isMuch = isMuch;
	}
	/***/
	public void addHp(long add){
		this.hp+=add;
	}
	public long getHp() {
		return this.hp;
	}
	public void setHp(long hp) {
		this.hp = hp;
	}
	public long getHpMax() {
		return this.hpMax;
	}
	public void setHpMax(long hpMax) {
		this.hpMax = hpMax;
	}
	public boolean isMuch() {
		return this.isMuch;
	}
	public void setMuch(boolean isMuch) {
		this.isMuch = isMuch;
	}
	
	
	
}
