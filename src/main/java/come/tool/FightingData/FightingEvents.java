package come.tool.FightingData;

import java.util.List;

/**
 * 战斗事件
 * @author Administrator
 *
 */
public class FightingEvents {
    //发起人
	private FightingState Originator;
	// 接受人集合
	private List<FightingState> Accepterlist;
    //当前回合
	private int CurrentRound;
	//战斗编号
	private int Fightingsum;
	public FightingState getOriginator() {
		return this.Originator;
	}
	


	public void setOriginator(FightingState originator) {
		this.Originator = originator;
	}

	public List<FightingState> getAccepterlist() {
		return this.Accepterlist;
	}

	public void setAccepterlist(List<FightingState> accepterlist) {
		this.Accepterlist = accepterlist;
	}
	public int getCurrentRound() {
		return this.CurrentRound;
	}
	public void setCurrentRound(int currentRound) {
		this.CurrentRound = currentRound;
	}
	public int getFightingsum() {
		return this.Fightingsum;
	}
	public void setFightingsum(int fightingsum) {
		this.Fightingsum = fightingsum;
	}
	
	
	
	
}
