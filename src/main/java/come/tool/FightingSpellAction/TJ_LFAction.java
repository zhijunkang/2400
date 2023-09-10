package come.tool.FightingSpellAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import come.tool.FightingDataAction.DataActionType;
import come.tool.Mixdeal.CreepsMixdeal;




public class TJ_LFAction implements SpellAction{

	@Override
	public void spellAction(ManData manData, FightingSkill skill,FightingEvents events, Battlefield battlefield) {

		Skill skillXls=GameServer.getSkill("1268");
		
		
		List<ManData> datas = MixDeal.getdaji((int) skillXls.getValue1(), manData.getCamp(), events, battlefield);
		List<FightingState> Accepterlist = new ArrayList<>();
		
		FightingState Originator = events.getOriginator();
		Originator.setStartState("法术攻击");
		Originator.setSkillsy(skill.getSkillname());
		if (manData.daijia(skill,Originator,battlefield)) {return;}//扣除代价
		Originator.setText("群魔乱世，雷罚净化！#24");
		Originator.setSkillskin("11276");
		
		for (int i = 0; i < datas.size(); i++) {
			FightingState fightingState2 = new FightingState();
			ManData data2 = datas.get(i);
			ChangeFighting fighting2 = new ChangeFighting();
			fighting2.setChangetype("技能");
			fightingState2.setSkillskin("112661");
			int is = (int) (manData.getShanghai()*skillXls.getSkilllevel()*skillXls.getGrow()*skillXls.getValue()+(manData.getMp_z()/50));
			fighting2.setChangehp(-is);
			FightingPackage.ChangeProcess(fighting2, null, data2, fightingState2,"技能",Accepterlist, battlefield);
			
			FightingState fightingState = new FightingState();
			ManData data = datas.get(i);
			ChangeFighting fighting = new ChangeFighting();
			fighting.setChangetype("技能");
			fighting.setChangehp(-is/2);
			FightingPackage.ChangeProcess(fighting, null, data, fightingState,"至圣",Accepterlist, battlefield);
			
		}
		if (events.getOriginator()!=null) {
			Accepterlist.add(Originator);
		}
		events.setOriginator(null);
		events.setAccepterlist(Accepterlist);
		battlefield.NewEvents.add(events);
	}
}