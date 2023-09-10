package come.tool.Scene.DNTG;

import java.math.BigDecimal;

import org.come.model.Skill;

public class DNTGRole {
	private static final long TIME=20000;//操作的时间间隔	
	private BigDecimal roleId;//角色id
	private String roleName;//角色名
	private int camp;//阵营标识
	private int DNJB;//大闹金币
	private int DNJF;//大闹积分	
	private int useDNJF;//可用大闹积分
	private String SLJC;//神力加持
	private int NVNum;//击杀女武神次数
	private long time;//操作时间
	
	private boolean isA;//是否领取奖励
	public DNTGRole(BigDecimal roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.camp = -1;
		this.isA=false;
		this.time=System.currentTimeMillis()+TIME;
	}
	public BigDecimal getRoleId() {
		return this.roleId;
	}
	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getCamp() {
		return this.camp;
	}
	public void setCamp(int camp) {
		this.camp = camp;
	}
	public int getDNJB() {
		return this.DNJB;
	}
	public void setDNJB(int dNJB) {
		this.DNJB = dNJB;
	}
	public int getDNJF() {
		return this.DNJF;
	}
	public void setDNJF(int dNJF) {
		this.DNJF = dNJF;
	}
	public String getSLJC() {
		return this.SLJC;
	}
	public void setSLJC(String sLJC) {
		this.SLJC = sLJC;
	}
	public String upSLJC(Skill skill,int KJValue) {
//		LID$LVL&ID$LVL
		if (this.SLJC==null||this.SLJC.equals("")) {
			if (skill.getDielectric()>this.DNJB) {
				return "金币不足";
			}
			if (skill.getCamp()>KJValue) {
				return "科技值不足"+skill.getCamp();
			}
			this.DNJB-=skill.getDielectric();
			this.SLJC=skill.getSkillid()+"$1";
			return null;
		}
		boolean is=true;
		StringBuffer buffer=new StringBuffer();
		String[] vs=this.SLJC.split("&");
		for (int i = 0; i < vs.length; i++) {
			if (buffer.length()!=0) {
				buffer.append("&");
			}
			if (vs[i].startsWith(skill.getSkillid()+"$")) {
				is=false;
				String[] v=vs[i].split("\\$");	
				int lvl=Integer.parseInt(v[1]);
				if (lvl>=skill.getSkilllevel()) {
					return "已达到等级上限";
				}
				lvl+=1;
				if (lvl*skill.getDielectric()>this.DNJB) {
					return "金币不足";
				}
				if (lvl*skill.getCamp()>KJValue) {
					return "科技值不足"+lvl*skill.getCamp();
				}
				this.DNJB-=lvl*skill.getDielectric();
				buffer.append(skill.getSkillid());
				buffer.append("$");
				buffer.append(lvl);
			}else {
				buffer.append(vs[i]);
			}
		}
		if (is) {
			if (skill.getDielectric()>this.DNJB) {
				return "金币不足";
			}
			if (skill.getCamp()>KJValue) {
				return "科技值不足"+skill.getCamp();
			}
			this.DNJB-=skill.getDielectric();
			if (buffer.length()!=0) {
				buffer.append("&");
			}
			buffer.append(skill.getSkillid());
			buffer.append("$1");	
		}
		this.SLJC=buffer.toString();
		return null;
	}
	public void addDNJB(int add) {
		this.DNJB+=add;
	}
	public void addDNJF(int add) {
		this.DNJF+=add;
		this.useDNJF+=add;
	}
	public int getNVNum() {
		return this.NVNum;
	}
	public void setNVNum(int nVNum) {
		this.NVNum = nVNum;
	}
	
	public boolean isA() {
		return this.isA;
	}
	public void setA(boolean isA) {
		this.isA = isA;
	}
	/**判断剩余的操作时间*/
	public String isTime(long nTime){
		nTime=this.time-nTime;
		nTime/=1000;
		if (nTime>0) {return this.roleName+"还需要休息"+nTime+"秒";}
		return null;
	}
	public long getTime() {
		return this.time;
	}
	public void setTime(long time) {
		this.time = time+TIME;
	}
	public int getUseDNJF() {
		return this.useDNJF;
	}
	public void setUseDNJF(int useDNJF) {
		this.useDNJF = useDNJF;
	}
}
