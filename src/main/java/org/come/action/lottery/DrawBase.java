package org.come.action.lottery;

import org.come.server.GameServer;

public class DrawBase {

	private int[] ids;
	private String[] idBooss;//放妖用的
	private int sum;
	private double v;
	public int getId() {
		if (this.ids.length==1) {return this.ids[0];}
		return this.ids[GameServer.random.nextInt(this.ids.length)];
	}
	public String getDropId() {
		if (this.ids!=null) {
			if (this.ids.length==1) {return this.ids[0]+"";}
			return this.ids[GameServer.random.nextInt(this.ids.length)]+"";	
		}else if (this.idBooss!=null) {
			if (this.idBooss.length==1) {return this.idBooss[0];}
			return this.idBooss[GameServer.random.nextInt(this.idBooss.length)];	
		}
		return null;
	}
	public int[] getIds() {
		return this.ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public String[] getIdBooss() {
		return this.idBooss;
	}
	public void setIdBooss(String[] idBooss) {
		this.idBooss = idBooss;
	}
	public int getSum() {
		return this.sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getV() {
		return this.v;
	}
	public void setV(double v) {
		this.v = v;
	}
	
}
