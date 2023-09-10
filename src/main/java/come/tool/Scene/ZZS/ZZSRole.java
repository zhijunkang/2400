package come.tool.Scene.ZZS;

import io.netty.channel.ChannelHandlerContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.come.handler.SendMessage;
import org.come.protocol.Agreement;
import org.come.server.GameServer;

public class ZZSRole {

	private BigDecimal Id;
	private String role;
	//状态   0正常   1匹配  3淘汰赛资格   4被淘汰 
	private int I;
	//积分
	private int jf;
	//记录参赛场次
	private int CYnum;
	//记录获胜场次
	private int HSnum;
	//记录连胜场次
	private int LSnum;
	//淘汰赛战败场次
	private int ZBnum;
	private List<ZZSAward> awards;
	private long time;
	public ZZSRole(BigDecimal id, String role) {
		super();
		this.Id = id;
		this.role = role;
	}
	/**战绩刷新 积分变更返回true*/
	public boolean Battle(boolean is,int type){
		this.CYnum++;
		if (is) {
			int add=0;
			if (type==31) {
				add=5+this.LSnum;
			}else {
				add=10;
			}
			ChannelHandlerContext ctx=GameServer.getRoleNameMap().get(this.role);
			if (ctx!=null) {
				SendMessage.sendMessageToSlef(ctx,Agreement.getAgreement().PromptAgreement("你获得"+add+"点积分"));	
			}
			this.jf+=add;
			this.HSnum++;
			this.LSnum++;
			addAward();
			return true;
		}else {
			this.LSnum=0;
			if (type==32) {this.ZBnum++;}
			addAward();
			return false;
		}
	}
	/**判断是否添加奖励  5参与奖励 5胜奖励  3连胜奖励*/
	public void addAward(){
		if (this.CYnum>=5) {addAward(1);}
		if (this.HSnum>=5) {addAward(2);}
		if (this.LSnum>=3) {addAward(3);}
	}
	/**添加奖励*/
	public void addAward(int type){
		if (this.awards==null) {
			this.awards=new ArrayList<>();
		}
		for (int i = this.awards.size()-1; i >=0; i--) {
			if (this.awards.get(i).getType()==type) {
				return;
			}
		}
		String msg=null;
		if (type==1) {
			msg=Agreement.getAgreement().PromptAgreement("获得5场参与奖励,请找NPC领取");
		}else if (type==2) {
			msg=Agreement.getAgreement().PromptAgreement("获得5场胜利奖励,请找NPC领取");
		}else if (type==3) {
			msg=Agreement.getAgreement().PromptAgreement("获得3场连胜奖励,请找NPC领取");
		}else if (type==4) {
			msg=Agreement.getAgreement().PromptAgreement("获得十强奖励,请找NPC领取");
		}else if (type==5) {
			msg=Agreement.getAgreement().PromptAgreement("获得第一名奖励,请找NPC领取");
		}
		if (msg!=null) {
			ChannelHandlerContext ctx=GameServer.getRoleNameMap().get(this.role);
			if (ctx!=null) {
				SendMessage.sendMessageToSlef(ctx,msg);			
			}		
		}
		this.awards.add(new ZZSAward(type));
	}
	
	public BigDecimal getId() {
		return this.Id;
	}
	public void setId(BigDecimal id) {
		this.Id = id;
	}
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getI() {
		return this.I;
	}
	public void setI(int i) {
		this.I = i;
	}
	public int getJf() {
		return this.jf;
	}
	public void setJf(int jf) {
		this.jf = jf;
	}
	public int getCYnum() {
		return this.CYnum;
	}
	public void setCYnum(int cYnum) {
		this.CYnum = cYnum;
	}
	public int getHSnum() {
		return this.HSnum;
	}
	public void setHSnum(int hSnum) {
		this.HSnum = hSnum;
	}
	public int getLSnum() {
		return this.LSnum;
	}
	public void setLSnum(int lSnum) {
		this.LSnum = lSnum;
	}
	public int getZBnum() {
		return this.ZBnum;
	}
	public void setZBnum(int zBnum) {
		this.ZBnum = zBnum;
	}
	public List<ZZSAward> getAwards() {
		return this.awards;
	}
	public void setAwards(List<ZZSAward> awards) {
		this.awards = awards;
	}
	public long getTime() {
		return this.time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
}
