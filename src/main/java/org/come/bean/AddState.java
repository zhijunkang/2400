package org.come.bean;
/**
 * 附加状态
 * @author Administrator
 *
 */
public class AddState {

	//附加状态名
	private String statename;
	//状态效果
	private double stateEffect;
	//持续到的回合
	private int Surplus;

	public String getStatename() {
		return this.statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public int getSurplus() {
		return this.Surplus;
	}

	public void setSurplus(int surplus) {
		this.Surplus = surplus;
	}

	public double getStateEffect() {
		return this.stateEffect;
	}

	public void setStateEffect(double stateEffect) {
		this.stateEffect = stateEffect;
	}


	
	
}
