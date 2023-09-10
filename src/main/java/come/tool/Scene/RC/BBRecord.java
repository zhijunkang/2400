package come.tool.Scene.RC;

import org.come.model.Boos;
import org.come.model.Robots;

public class BBRecord {

	private String[] teams;
	private int size;
	private int BBNum;//宝宝副本胜利次数
	private transient Robots BBrobots;
	private transient Boos BBboos;
	public String getMsg(){		
		if (this.teams==null) {
			return "还没有挑战记录";
		}
		StringBuffer buffer=new StringBuffer();
		buffer.append("当前最高记录:");
		for (int i = 0; i < this.teams.length; i++) {
			if (i!=0) {buffer.append(",");}
			buffer.append(this.teams[i]);
		}
		buffer.append("。该队伍连胜次数为");
		buffer.append(this.size);
		return buffer.toString();	
	}
	public synchronized void UPRecord(int v,String[] names){
		this.BBNum+=names.length;
		if (v>this.size) {this.size=v;this.teams=names;}
	}
	public String[] getTeams() {
		return this.teams;
	}
	public void setTeams(String[] teams) {
		this.teams = teams;
	}
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getBBNum() {
		return this.BBNum;
	}
	public void setBBNum(int bBNum) {
		this.BBNum = bBNum;
	}
	public Robots getBBrobots() {
		return this.BBrobots;
	}
	public void setBBrobots(Robots bBrobots) {
		this.BBrobots = bBrobots;
	}
	public Boos getBBboos() {
		return this.BBboos;
	}
	public void setBBboos(Boos bBboos) {
		this.BBboos = bBboos;
	}
	/**根据挑战完成次数获取比斗奖章的积分*/
	public String getReward(int v){
		int jf=v*(28+(v/4>=10?10:v/4));
		return "比斗奖章="+jf;
	}
}
