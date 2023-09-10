package come.tool.Scene.TGDB;

import org.come.task.MapMonsterBean;

public class TGDBMonster{

	private MapMonsterBean bean;
	//记录怪物层次
	private int I;
	//记录剩余击杀次数
	private int hp;
	//判断当前正在击杀的队伍数量
	private int num;
	public MapMonsterBean getBean() {
		return this.bean;
	}
	public void setBean(MapMonsterBean bean) {
		this.bean = bean;
	}
	public int getI() {
		return this.I;
	}
	public void setI(int i) {
		this.I = i;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
