package come.tool.FightingSpellAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.come.model.Dorp;
import org.come.model.Skill;
import org.come.server.GameServer;

import come.tool.FightingData.AddState;
import come.tool.FightingData.Battlefield;
import come.tool.FightingData.ChangeFighting;
import come.tool.FightingData.FightingEvents;
import come.tool.FightingData.FightingManData;
import come.tool.FightingData.FightingPackage;
import come.tool.FightingData.FightingSkill;
import come.tool.FightingData.FightingState;
import come.tool.FightingData.GroupBuff;
import come.tool.FightingData.ManData;
import come.tool.FightingData.MixDeal;
import come.tool.FightingData.SummonType;
import come.tool.FightingData.TypeUtil;
import come.tool.FightingDataAction.Fabao;
import come.tool.Mixdeal.CreepsMixdeal;




public class TJ_YYSFAction implements SpellAction{
	public List<FightingEvents> NewEvents;
	@Override
	public void spellAction(ManData manData, FightingSkill skill,FightingEvents events, Battlefield battlefield) {
		Random rand = new Random();
		Skill skillXls=GameServer.getSkill("1272");
		//获取 附加状态几率
		int jl = (int) (skillXls.getGrow1()+1);
		SummonType.xianzhi(manData, skill);
		
		List<ManData> datas = MixDeal.getdaji((int) skillXls.getValue1(), manData.getCamp(), events, battlefield);
		List<FightingState> Accepterlist = new ArrayList<>();
		
		FightingState Originator = events.getOriginator();
		Originator.setStartState("法术攻击");
		Originator.setSkillsy(skill.getSkillname());
//		skill.setSkillblue(Integer.parseInt((skillXls.getDielectric())+""));
		if (manData.daijia(skill,Originator,battlefield)) {return;}//扣除代价
		Originator.setText("神罚降临，暂避锋芒！#2");
		Originator.setSkillskin("11274");
		for (int i = 0; i < datas.size(); i++) {
			FightingState fightingState = new FightingState();
			ManData data = datas.get(i);
			ChangeFighting fighting = new ChangeFighting();
			fighting.setChangetype("技能");
			fightingState.setSkillskin("112791");
			int is = (int) (manData.getShanghai()*skillXls.getSkilllevel()*skillXls.getGrow()*skillXls.getValue());
			fighting.setChangehp(-is);
			FightingPackage.ChangeProcess(fighting, null, data, fightingState,"技能",Accepterlist, battlefield);
//			battlefield.TZ_HTSA(data);
			
			//几率 附加回头是岸
			int ysl =rand.nextInt(100 - 1 + 1) + 1;
			if(ysl<jl) {
				skill.setSkilltype(TypeUtil.FB_QW);
//				double jichu=skill.getSkillhurt();
//		    	FightingSkill skill2=data.getAppendSkill(9250);
//		    	if (skill2!=null) {jichu-=skill2.getSkillhurt()/6;}
		    	
//		    	if (skill.getSkilltype().equals(TypeUtil.FB_QW)) {
//		    		skill2=data.getAppendSkill(9205);
//		        	if (skill2!=null) {jichu-=skill2.getSkillhurt();}
//		    		jichu-=data.getQuality().getK_qw();
//				}else if (skill.getSkilltype().equals(TypeUtil.FB_JGE)) {
//					jichu-=data.getQuality().getK_jge();
//				}
//		    	double xs=1+(data.getlvl()-data.getlvl())/150.0;
//		    	jichu*=xs;
//		  	    if (Battlefield.random.nextInt(100)<jichu) {
		  	  		Fabao.state(Accepterlist, fightingState, data, skill, battlefield);
//				}
				
				
//				data.addAddState(TypeUtil.FB_QW,0,0,2);
//				fightingState.setCamp(data.getCamp());
//				fightingState.setMan(data.getMan());
//				fightingState.setEndState_1(TypeUtil.FB_QW);
//				fightingState.setSkillskin("6025");
//				fightingState.setStartState("代价");
//				Accepterlist.add(fightingState);
			}
		}
		if (events.getOriginator()!=null) {
			Accepterlist.add(Originator);
		}
		events.setOriginator(null);
		events.setAccepterlist(Accepterlist);
		battlefield.NewEvents.add(events);
	}
}