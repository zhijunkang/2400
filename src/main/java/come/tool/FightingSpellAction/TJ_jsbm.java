package come.tool.FightingSpellAction;

import come.tool.FightingData.*;

import java.util.ArrayList;
import java.util.List;

public class TJ_jsbm implements SpellAction{
	
    @Override
    public void spellAction(ManData manData, FightingSkill skill, FightingEvents events, Battlefield battlefield) {
  

//        state.setEndState_1(addState.getStatename());
        GetqualityUntil.AddR(manData.getQuality(),"抗风",50.9);
        GetqualityUntil.AddR(manData.getQuality(),"抗雷",50.9);
        GetqualityUntil.AddR(manData.getQuality(),"抗水",50.9);
        GetqualityUntil.AddR(manData.getQuality(),"抗火",50.9);
        GetqualityUntil.AddR(manData.getQuality(),"抗鬼火",50.9);
        GetqualityUntil.AddR(manData.getQuality(),"物理吸收",100.1);





//        manData.getAddStates().add(addState);
//        manData.getQuality().addks(v);




    FightingEvents fe2=new FightingEvents();
    FightingState fs2=new FightingState();
    fs2.setStartState(TypeUtil.JN);

    List<FightingState> ac2=new ArrayList<>();
    ChangeFighting fighting=new ChangeFighting();

    fighting.setChangesum(10);
    fighting.setChangevlaue(20);
	fs2.setStartState(TypeUtil.JN);

	fs2.setSkillskin(TypeUtil.TJ_jsbm);
    fighting.setChangesum(5);
	fs2.setStartState("法术攻击");			
	fs2.setEndState_1(TypeUtil.TJ_jsbm);
        

        FightingPackage.ChangeProcess(fighting, manData, manData, fs2, TypeUtil.JN, ac2, battlefield);
    fe2.setAccepterlist(ac2);
    battlefield.NewEvents.add(fe2);

                 }

        
        
    }







