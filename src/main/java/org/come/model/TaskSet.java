package org.come.model;

public class TaskSet {
	
	private int taskSetID;//任务系列ID
	private String taskType;//任务类型
	private int sumcycle;//任务周期      0无  如10 10次为一环
	private int sumlimit;//次数限制      0无限制
	private int sumreceive;//领取次数  0无领取限制 
	private int resetcycle;//重置任务  0无重置 1日2周3月
	private int taskMsgID;//任务领取提示ID
	private String taskMsg;//任务提示
	private transient String robots;//关联的robots集合
	
	public TaskSet() {
		// TODO Auto-generated constructor stub
	}
	/**获取奖励系数*/
	public double XSReward(int ComSum) {
		if (this.sumcycle == 0){
			ComSum = 0;
		}else {
			ComSum = ComSum % this.sumcycle;
		}
		return 0.05 * ComSum;
	}
	public int getTaskSetID() {
		return this.taskSetID;
	}
	public void setTaskSetID(int taskSetID) {
		this.taskSetID = taskSetID;
	}
	public String getTaskType() {
		return this.taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public int getSumcycle() {
		return this.sumcycle;
	}
	public void setSumcycle(int sumcycle) {
		this.sumcycle = sumcycle;
	}
	public int getSumlimit() {
		return this.sumlimit;
	}
	public void setSumlimit(int sumlimit) {
		this.sumlimit = sumlimit;
	}
	public int getSumreceive() {
		return this.sumreceive;
	}
	public void setSumreceive(int sumreceive) {
		this.sumreceive = sumreceive;
	}
	public int getResetcycle() {
		return this.resetcycle;
	}
	public void setResetcycle(int resetcycle) {
		this.resetcycle = resetcycle;
	}
	public int getTaskMsgID() {
		return this.taskMsgID;
	}
	public void setTaskMsgID(int taskMsgID) {
		this.taskMsgID = taskMsgID;
	}
	public String getTaskMsg() {
		return this.taskMsg;
	}
	public void setTaskMsg(String taskMsg) {
		this.taskMsg = taskMsg;
	}
	public String getRobots() {
		return this.robots;
	}
	public void setRobots(String robots) {
		this.robots = robots;
	}
}
