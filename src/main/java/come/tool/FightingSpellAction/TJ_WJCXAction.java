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
import come.tool.FightingData.ManData;
import come.tool.FightingData.MixDeal;
import come.tool.FightingData.SummonType;




public class TJ_WJCXAction implements SpellAction{

	@Override
	public void spellAction(ManData manData, FightingSkill skill,FightingEvents events, Battlefield battlefield) {
		Skill skillXls=GameServer.getSkill("1264");
		
		//增加冷却
		SummonType.xianzhi(manData, skill);
		//施法前去除隐身
		MixDeal.ys(manData, false, battlefield);
		
//		CreepsMixdeal.addNeiDanSkill(manData, id);
		// TODO Auto-generated method stub
		//新增技能 万剑穿心
//		int nocamp=battlefield.nomy(manData.getCamp());
		//随机1-10目标
		Random rand = new Random();
		int randNumber =rand.nextInt(10 - 1 + 1) + 1;
		List<ManData> datas=MixDeal.getdaji(randNumber, manData.getCamp(), events, battlefield);
		List<FightingState> Accepterlist=new ArrayList<>();
		
		FightingState Originator=events.getOriginator();
		Originator.setStartState("法术攻击");
		Originator.setSkillsy(skill.getSkillname());
		if (manData.daijia(skill,Originator,battlefield)) {return;}//扣除代价
		Originator.setText("剑...来！#2");
		//判断是否触发双倍
		int lj =rand.nextInt(100 - 1 + 1) + 1;
		if(lj<21) {
			int sj =rand.nextInt(datas.size() - 1 + 1) + 1;
			sj = sj-1;
			for (int i = 0; i < datas.size(); i++) {
				//随机目标双倍伤害
				if(sj==i) {
					for(int s=0; s<2;s++) {
						FightingState fightingState=new FightingState();
						ManData data=datas.get(i);
						ChangeFighting fighting=new ChangeFighting();
						fighting.setChangetype("技能");
						fightingState.setSkillskin("30001");
						int is = (int) (manData.getShanghai()*skillXls.getSkilllevel()*skillXls.getGrow()*skillXls.getValue()+(manData.getMp_z()/50));
						fighting.setChangehp(-is);
						FightingPackage.ChangeProcess(fighting, null, data, fightingState,"技能",Accepterlist, battlefield);
					}
				}else {
					FightingState fightingState=new FightingState();
					ManData data=datas.get(i);
					ChangeFighting fighting=new ChangeFighting();
					fighting.setChangetype("技能");
					fightingState.setSkillskin("30001");
					int is = (int) (manData.getShanghai()*skillXls.getSkilllevel()*skillXls.getGrow()*skillXls.getValue()+(manData.getMp_z()/50));
					fighting.setChangehp(-is);
					FightingPackage.ChangeProcess(fighting, null, data, fightingState,"技能",Accepterlist, battlefield);
				}
			}
		}else {
			for (int i = 0; i < datas.size(); i++) {
				FightingState fightingState=new FightingState();
				ManData data=datas.get(i);
				ChangeFighting fighting=new ChangeFighting();
				fighting.setChangetype("技能");
				fightingState.setSkillskin("30001");
				int is = (int) (manData.getShanghai()*skillXls.getSkilllevel()*skillXls.getGrow()*skillXls.getValue()+(manData.getMp_z()/50));
				fighting.setChangehp(-is);
				FightingPackage.ChangeProcess(fighting, null, data, fightingState,"技能",Accepterlist, battlefield);
			}
		}
		//30%几率隐身
		int ysl =rand.nextInt(100 - 1 + 1) + 1;
		if(ysl<31) {
			FightingManData fightingManData = new FightingManData();
			fightingManData.setModel(manData.getModel());
			fightingManData.setManname(manData.getManname());
			fightingManData.setCamp(manData.getCamp());
			fightingManData.setMan(manData.getMan());
			fightingManData.setHp_Current(manData.getHp());
			fightingManData.setHp_Total(manData.getHp_z());
			fightingManData.setMp_Current(manData.getMp());
			fightingManData.setMp_Total(manData.getMp_z());
			fightingManData.setState_1(manData.xz());
			fightingManData.setType(manData.getType());
			fightingManData.setManname(manData.getManname());
			fightingManData.setZs(manData.getZs());
			fightingManData.setMsg(manData.getMsg());
			fightingManData.setYqz(manData.getYqz());
			fightingManData.setNqz(manData.getNqz());
			fightingManData.setStates(manData.ztstlist(fightingManData));
			fightingManData.setId(manData.getId());
			
			
			FightingState fightingState=new FightingState();
			AddState addState = new AddState();
			addState.setStatename("隐身");
			addState.setSurplus(3);
			manData.getAddStates().add(addState);
			fightingManData.setAlpha(0.3f);
			fightingState.setFightingManData(fightingManData);
			Accepterlist.add(fightingState);
			MixDeal.Approach(manData,fightingState,battlefield);
			
//			FightingState Accepter=new FightingState();
//			ChangeFighting changeFighting=new ChangeFighting();
//			changeFighting.setChangetype("清除异常状态");
//			manData.ChangeData(changeFighting, Accepter);
//			changeFighting.setChangetype("隐身");
//			changeFighting.setChangesum(2);
//			manData.ChangeData(changeFighting, Accepter);
			
			Originator.setCamp(manData.getCamp());
			Originator.setMan(manData.getMan());
			Originator.setEndState_1("隐身");
			Originator.setText("我隐...#2");
		}
		
		if (events.getOriginator()!=null) {
			Accepterlist.add(Originator);
		}
		events.setOriginator(null);
		events.setAccepterlist(Accepterlist);
		battlefield.NewEvents.add(events);
	}
}