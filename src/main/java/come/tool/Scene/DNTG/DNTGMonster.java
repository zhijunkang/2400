package come.tool.Scene.DNTG;

import org.come.task.MapMonsterBean;

public class DNTGMonster {

	
	private MapMonsterBean bean;
	//阵营
	private int camp;
	//攻击的对象
	private int value;
	private int hurt;//伤害
	public DNTGMonster(MapMonsterBean bean,int camp,int value,int hurt) {
		super();
		this.bean = bean;
		this.camp=camp;
		this.value=value;
		this.hurt=hurt;
	}
	/**移动*/
	public boolean move(){
		if (this.bean.getType()!=0||this.bean.getMove()==null) {return false;}
		return this.bean.getMove().isMove(1000);
	}
	public MapMonsterBean getBean() {
		return this.bean;
	}
	public void setBean(MapMonsterBean bean) {
		this.bean = bean;
	}
	public int getCamp() {
		return this.camp;
	}
	public void setCamp(int camp) {
		this.camp = camp;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getHurt() {
		return this.hurt;
	}
	public void setHurt(int hurt) {
		this.hurt = hurt;
	}
}
