package org.come.model;

import java.math.BigDecimal;

import org.come.bean.QuackGameBean;
import org.come.protocol.Agreement;
import org.come.until.GsonUtil;

import come.tool.Role.RoleCard;

/**每日活动*/
public class EventModel {

	private int gId; // 表ID
	private int taskBigType; // 大类
	private String taskName; // 小类
	private int taskId; // 任务ID
	private transient String award;//首杀奖励集合（id|id）
	
	private transient String msg;//排行榜数据
	/**排行榜数据*/
	private transient RoleCard[] roles;
	/**获取奖励*/
	public String getAward(BigDecimal roleid){
		if (this.roles==null) {return null;}
		String[] vs=this.award.split("\\|");
		for (int i = 0; i < this.roles.length; i++) {
			if (this.roles[i]!=null&&this.roles[i].getRoleId().compareTo(roleid)==0) {
				return vs[0];
			}
		}
		return vs[1];
	} 
	/**重置排行榜数据*/
	public void resetRanking(BigDecimal role_id,String rolename){
		if (role_id!=null) {
			if (this.roles==null) {
				this.roles=new RoleCard[]{new RoleCard(role_id, rolename, null),null,null,null,null};
			}else {
				int p=-1;
				for (int i = 0; i < this.roles.length; i++) {
					if (this.roles[i]!=null) {
						if (this.roles[i].getRoleId().compareTo(role_id)==0) {return;}
					}else if (p==-1) {
						p=i;
					}
				}
				if (p==-1) {return;}
				this.roles[p]=new RoleCard(role_id, rolename, null);
			}
		}
		QuackGameBean bean=new QuackGameBean();
		bean.setType(5);
		StringBuffer buffer=new StringBuffer();
		if (this.roles!=null) {
			for (int i = 0; i < this.roles.length; i++) {
				if (this.roles[i]!=null) {
					if (buffer.length()!=0) {buffer.append("|");}
					buffer.append(this.roles[i].getRoleName());
				}
			}	
		}
		bean.setPetmsg(buffer.length()!=0?buffer.toString():null);
		this.msg=Agreement.getAgreement().getfivemsgAgreement(GsonUtil.getGsonUtil().getgson().toJson(bean));
		if (buffer.length()==0) {this.msg=null;}
		
//		StringBuffer buffer=new StringBuffer();
//		for (int i = 0; i < roles.length; i++) {
//			if (roles[i]!=null) {
//				if (buffer.length()!=0) {buffer.append("|");}
//				buffer.append(roles[i].getRoleName());
//			}
//		}
//		msg=buffer.length()!=0?buffer.toString():null;
	}
	public int getgId() {
		return this.gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}

	public int getTaskBigType() {
		return this.taskBigType;
	}
	public void setTaskBigType(int taskBigType) {
		this.taskBigType = taskBigType;
	}

	public String getTaskName() {
		return this.taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getTaskId() {
		return this.taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getAward() {
		return this.award;
	}
	public void setAward(String award) {
		this.award = award;
	}

	public String getMsg() {
		return this.msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public RoleCard[] getRoles() {
		return this.roles;
	}
	public void setRoles(RoleCard[] roles) {
		this.roles = roles;
	}
}
