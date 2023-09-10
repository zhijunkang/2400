package come.tool.FightingData;

import java.util.ArrayList;
import java.util.List;

/**
 * 战斗回合
 * @author Administrator
 *
 */
public class FightingRound {

	//处理后的回合指令
	private List<FightingEvents> Round=new ArrayList<>();
	//当前回合
	private int CurrentRound;
	//战斗编号
	private int Fightingsumber;
		
	public int getCurrentRound() {
		return this.CurrentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.CurrentRound = currentRound;
	}

	public List<FightingEvents> getRound() {
		return this.Round;
	}

	public void setRound(List<FightingEvents> round) {
		this.Round = round;
	}

	public int getFightingsumber() {
		return this.Fightingsumber;
	}

	public void setFightingsumber(int fightingsumber) {
		this.Fightingsumber = fightingsumber;
	}
	
	
}
