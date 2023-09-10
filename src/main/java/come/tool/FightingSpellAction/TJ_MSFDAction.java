package come.tool.FightingSpellAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import come.tool.Mixdeal.CreepsMixdeal;




public class TJ_MSFDAction implements SpellAction{

	@Override
	public void spellAction(ManData manData, FightingSkill skill,FightingEvents events, Battlefield battlefield) {


		List<ManData> datas = MixDeal.getdaji(5, manData.getCamp(), events, battlefield);
		List<FightingState> Accepterlist = new ArrayList<>();
		
		FightingState Originator = events.getOriginator();
		Originator.setStartState("法术攻击");
		Originator.setSkillsy(skill.getSkillname());
		if (manData.daijia(skill,Originator,battlefield)) {return;}//扣除代价
		Originator.setText("韭菜何在！#24");
		Originator.setSkillskin("7012");
		
		for (int i = 0; i < datas.size(); i++) {
			FightingState fightingState = new FightingState();
			ManData data = datas.get(i);
			ChangeFighting fighting = new ChangeFighting();
			fighting.setChangetype("技能");
//			fightingState.setSkillskin("7012");
			fighting.setChangehp(-manData.getMp_z()*5);
			FightingPackage.ChangeProcess(fighting, null, data, fightingState,"技能",Accepterlist, battlefield);
		}
		if (events.getOriginator()!=null) {
			Accepterlist.add(Originator);
		}
		events.setOriginator(null);
		events.setAccepterlist(Accepterlist);
		battlefield.NewEvents.add(events);
	}
}