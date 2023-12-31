package come.tool.Scene.DNTG;

import org.come.bean.UseCardBean;
import org.come.protocol.Agreement;
import org.come.until.GsonUtil;

import come.tool.Stall.AssetUpdate;

public class DNTGBuff {

	private int bh;
	private long endTime;
	private UseCardBean useCardBean;
	private String sendCard;
	public DNTGBuff(int v,long time) {
		// TODO Auto-generated constructor stub
		this.bh=v;
		this.endTime=System.currentTimeMillis()+(time*1000*60);
		if (this.bh<=2) {
			this.useCardBean=new UseCardBean("大闹先锋",DNTGScene.DNTGBUFF,"770",this.endTime,toString());	
			AssetUpdate assetUpdate=new AssetUpdate(AssetUpdate.USEGOOD);
			assetUpdate.setUseCard(this.useCardBean);
			this.sendCard=Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate));
		}else if (this.bh==3) {
			this.useCardBean=new UseCardBean("大闹先锋统帅",DNTGScene.DNTGBUFF,"770",this.endTime,toString());	
			AssetUpdate assetUpdate=new AssetUpdate(AssetUpdate.USEGOOD);
			assetUpdate.setUseCard(this.useCardBean);
			this.sendCard=Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(assetUpdate));
		}
	}
	public boolean isTime(){
		return System.currentTimeMillis()>this.endTime;
	}
	@Override
	public String toString(){
		if (this.bh==0) {
			return "积分收益增加10%";	
		}else if (this.bh==1) {
			return "金币收益增加20%";	
		}else if (this.bh==2) {
			return "玩家对敌方的建筑物多造成2点伤害";	
		}else if (this.bh==3) {
			return "积分收益增加10%|金币收益增加20%|玩家对敌方的建筑物多造成2点伤害";	
		}
		return null;
	}
	public int getBh() {
		return this.bh;
	}
	public void setBh(int bh) {
		this.bh = bh;
	}
	public long getEndTime() {
		return this.endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public UseCardBean getUseCardBean() {
		return this.useCardBean;
	}
	public void setUseCardBean(UseCardBean useCardBean) {
		this.useCardBean = useCardBean;
	}
	public String getSendCard() {
		return this.sendCard;
	}
	public void setSendCard(String sendCard) {
		this.sendCard = sendCard;
	}
}
