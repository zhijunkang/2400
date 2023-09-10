package org.come.task;

import org.come.server.GameServer;

import come.tool.Good.DropModel;

public class MonsterExp {
	private int maxSize;//最大次数
	private long exp;//每次累加经验
	private int size;
	public MonsterExp(int maxSize, long exp) {
		super();
		this.maxSize = maxSize;
		this.exp = exp;
	}
	public String addEXP(MapMonsterBean bean,String name){
		if (this.size<this.maxSize) {this.size++;}
		StringBuffer buffer=new StringBuffer();
		buffer.append("#G");
		buffer.append(bean.getRobotname());
		buffer.append("#Y在#c00FFFF");
		buffer.append(GameServer.getMapName(bean.getMap()+""));
		buffer.append("(");
		buffer.append(bean.getX()/20);
		buffer.append(",");
		buffer.append(bean.getY()/20);
		buffer.append(")击杀#R");
		buffer.append(name);
		buffer.append("#Y为首的队伍。积累");
		buffer.append(this.exp*this.size/10000);
		buffer.append("万经验,等待其他队伍来战");
		return buffer.toString();
	}
	/**获取*/
	public DropModel getDropModel(int sum){
		if (this.size==0) {return null;}
		return new DropModel("经验="+(this.exp*this.size/sum));
	}
	public int getMaxSize() {
		return this.maxSize;
	}
	public long getExp() {
		return this.exp;
	}
}
