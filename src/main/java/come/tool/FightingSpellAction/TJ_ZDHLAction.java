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
import come.tool.Mixdeal.CreepsMixdeal;




public class TJ_ZDHLAction implements SpellAction{

	@Override
	public void spellAction(ManData manData, FightingSkill skill,FightingEvents events, Battlefield battlefield) {
		manData.setSpellSum(5);
		//获取技能表格数据
		Skill skillXls=GameServer.getSkill("1266");
		//											获取表格的技能目标数
		List<ManData> datas = MixDeal.getdaji((int) skillXls.getValue1(), manData.getCamp(), events, battlefield);
		List<FightingState> Accepterlist = new ArrayList<>();
		
		FightingState Originator = events.getOriginator();
		Originator.setStartState("法术攻击");
		Originator.setSkillsy(skill.getSkillname());
		if (manData.daijia(skill,Originator,battlefield)) {return;}//扣除代价
		//放技能 宝宝说话
		Originator.setText("神锤临凡，直捣黄龙！#167");
		//全屏特效
		Originator.setSkillskin("11268");
		//对敌方造成伤害
		for (int i = 0; i < datas.size(); i++) {
			FightingState fightingState = new FightingState();
			ManData data = datas.get(i);
			ChangeFighting fighting = new ChangeFighting();
			fighting.setChangetype("技能");
			fightingState.setSkillskin("112661");
			//																					获取表格的介质初始值
			int is = (int) (manData.getShanghai()*skillXls.getSkilllevel()*skillXls.getGrow()*skillXls.getValue()+(manData.getMp_z()/50));
			// 伤害
			fighting.setChangehp(-is);
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