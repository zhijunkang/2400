package come.tool.Scene.BTY;

import org.come.task.MapMonsterBean;

public class BTYMonster{
	
	private int CI;
	private MapMonsterBean bean;
	public BTYMonster(MapMonsterBean bean,int CI) {
		super();
		this.bean = bean;
		this.CI=CI;
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
	public int getCI() {
		return this.CI;
	}
	public void setCI(int cI) {
		this.CI = cI;
	}
}
