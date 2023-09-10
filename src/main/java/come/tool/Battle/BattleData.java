package come.tool.Battle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.come.model.Robots;
import org.come.task.MapMonsterBean;

import come.tool.BangBattle.BangFight;
import come.tool.FightingData.Battlefield;
import come.tool.FightingData.FightingEvents;
import come.tool.FightingData.FightingManData;
import come.tool.FightingData.ManData;
import come.tool.PK.PkMatch;
import come.tool.Scene.SLDH.SLDHGroup;
import come.tool.oneArena.OneArenaRole;
import come.tool.teamArena.TeamArenaGroup;

public class BattleData {
	private Object UPDATE_LOCK = new Object();
	// 战斗编号
	private int BattleNumber;
	// 战斗人和观战人
	private List<String> Participantlist = new ArrayList<>();
	// 战斗状态 0预告 1决策 2战斗播放 3播放结束通知
	private int battleState;
	// 战斗类型
	private int battleType;
	private Battlefield battlefield;
	// 战斗回合
	private int round;
	// 接受的决策
	private Map<Integer, List<FightingEvents>> PolicyMap = new HashMap<>();
	// 战斗播放指令
	private Map<Integer, List<FightingEvents>> BattlefieldPlay = new HashMap<>();
	// 界面展示数据
	private Map<Integer, List<FightingManData>> PlayDatas = new HashMap<>();;
	// 时间戳
	private long Battletime;
	// 计数器
	private int Calculator;
	// 播放所需最小时间
	private long playTime;
	// 第一个播放结束的时间戳
	private long playEndTime;
	// 野怪数据
	private MapMonsterBean monsterBean;
	// 野怪所在地图
	private long mapid;
	// 战局
	private BangFight bangFight;
	// PK
	private PkMatch pkMatch;
	private String bang1;// 挑战者1
	private String bang2;// 挑战者2
	private BigDecimal roleId1;// 挑战者1 id
	private BigDecimal roleId2;// 挑战者2 id
	private String[] team1;
	private String[] team2;
	private Robots robots;
	private String boosID;

	private int maxLvl;// 最高等级
	private int maxSum;// 最高今日战斗次数

	private Integer RCv;// 记录日常的次数
	private Integer BBv;// 记录宝宝副本次数
	
	private int HJv;//记录幻境的次数
	private Integer sceneId;// 副本id;
	private SLDHGroup pkGroup;// 水陆大会分组
	private int winCamp;// 获胜阵营
	private OneArenaRole oneArenaRole1;// 发起
	private OneArenaRole oneArenaRole2;// 被挑战

	private int wssType;

	private TeamArenaGroup teamArenaGroup;// 分组

	public BattleData() {
		// TODO Auto-generated constructor stub
		this.battlefield = new Battlefield(this, this.battleType);
	}

	/** 切换状态 */
	public void changeState(int state) {
		this.battleState = state;
		this.Calculator = 0;
		this.Battletime = System.currentTimeMillis();
		this.playEndTime = 0;
	}

	/**
	 * 战斗预知传入
	 * 
	 * @return
	 */
	public void addPreview(ManData data) {
		if (this.battleState != BattleState.HANDLE_PREVIEW)
			return;
		synchronized (this.UPDATE_LOCK) {
			this.battlefield.fightingdata.add(data);
		}
	}
	public static String[] vs=new String[]{"清心静气","凝神一击","气吞山河","行气如虹","神龙摆尾","知盈处虚","气聚神凝","流风回雪","逆鳞","天罡八卦"};	
	/**
	 * 战斗决策指令
	 * 
	 * @return
	 */
	public void addPolicy(FightingEvents events) {
		if (this.battleState != BattleState.HANDLE_POLICY)
			return;
		int PolicyRound = events.getCurrentRound();
		synchronized (this.UPDATE_LOCK) {
			getRoundPolicy(PolicyRound).add(events);
			if (events.getOriginator() != null && events.getOriginator().getEndState() != null) {
				for (int i = 0; i < vs.length; i++) {
					if (events.getOriginator().getEndState().equals(vs[i])) {
						this.battlefield.elsum++;
						break;
					}
				}
			}
		}
	}

	/**
	 * 接受战斗播放结束
	 * 
	 * @return
	 */
	public void addPlayEnd(int PolicyRound) {
		if (PolicyRound != this.round)
			return;
		this.Calculator++;
		if (this.playEndTime == 0) {
			this.playEndTime = System.currentTimeMillis();
		}
	}

	/**
	 * 获取回合指令
	 * 
	 * @return
	 */
	public List<FightingEvents> getRoundPolicy(int round){
		List<FightingEvents> events=this.PolicyMap.get(round);
		if (events==null){events=new ArrayList<>();this.PolicyMap.put(round, events);}
		return events;
	}

	public int getBattleNumber() {
		return this.BattleNumber;
	}

	public void setBattleNumber(int battleNumber) {
		this.BattleNumber = battleNumber;
	}

	public int getBattleState() {
		return this.battleState;
	}

	public void setBattleState(int battleState) {
		this.battleState = battleState;
	}

	public void addFightingdata(ManData data) {
		this.battlefield.fightingdata.add(data);
	}

	public long getBattletime() {
		return this.Battletime;
	}

	public void setBattletime(long battletime) {
		this.Battletime = battletime;
	}

	public int getBattleType() {
		return this.battleType;
	}

	public void setBattleType(int battleType) {
		this.battleType = battleType;
		this.battlefield.BattleType = battleType;
	}

	public int getRound() {
		return this.round;
	}

	public void setRound(int round) {
		getRoundPolicy(round);
		this.round = round;
	}

	public Battlefield getBattlefield() {
		return this.battlefield;
	}

	public void setBattlefield(Battlefield battlefield) {
		this.battlefield = battlefield;
	}

	public Map<Integer, List<FightingEvents>> getPolicyMap() {
		return this.PolicyMap;
	}

	public void setPolicyMap(Map<Integer, List<FightingEvents>> policyMap) {
		this.PolicyMap = policyMap;
	}

	public Map<Integer, List<FightingEvents>> getBattlefieldPlay() {
		return this.BattlefieldPlay;
	}

	public void setBattlefieldPlay(Map<Integer, List<FightingEvents>> battlefieldPlay) {
		this.BattlefieldPlay = battlefieldPlay;
	}

	public int getCalculator() {
		return this.Calculator;
	}

	public void setCalculator(int calculator) {
		this.Calculator = calculator;
	}

	public List<String> getParticipantlist() {
		return this.Participantlist;
	}

	public void setParticipantlist(List<String> participantlist) {
		this.Participantlist = participantlist;
	}

	public Map<Integer, List<FightingManData>> getPlayDatas() {
		return this.PlayDatas;
	}

	public void setPlayDatas(Map<Integer, List<FightingManData>> playDatas) {
		this.PlayDatas = playDatas;
	}

	public MapMonsterBean getMonsterBean() {
		return this.monsterBean;
	}

	public void setMonsterBean(MapMonsterBean monsterBean) {
		this.monsterBean = monsterBean;
	}

	public long getMapid() {
		return this.mapid;
	}

	public void setMapid(long mapid) {
		this.mapid = mapid;
	}

	public BangFight getBangFight() {
		return this.bangFight;
	}

	public void setBangFight(BangFight bangFight) {
		this.bangFight = bangFight;
	}

	public String getBang1() {
		return this.bang1;
	}

	public void setBang1(String bang1) {
		this.bang1 = bang1;
	}

	public String getBang2() {
		return this.bang2;
	}

	public void setBang2(String bang2) {
		this.bang2 = bang2;
	}

	public BigDecimal getRoleId1() {
		return this.roleId1;
	}

	public void setRoleId1(BigDecimal roleId1) {
		this.roleId1 = roleId1;
	}

	public BigDecimal getRoleId2() {
		return this.roleId2;
	}

	public void setRoleId2(BigDecimal roleId2) {
		this.roleId2 = roleId2;
	}

	public String[] getTeam1() {
		return this.team1;
	}

	public void setTeam1(String[] team1) {
		this.team1 = team1;
	}

	public String[] getTeam2() {
		return this.team2;
	}

	public void setTeam2(String[] team2) {
		this.team2 = team2;
	}

	public Robots getRobots() {
		return this.robots;
	}

	public void setRobots(Robots robots) {
		this.robots = robots;
	}

	public String getBoosID() {
		return this.boosID;
	}

	public void setBoosID(String boosID) {
		this.boosID = boosID;
	}

	public PkMatch getPkMatch() {
		return this.pkMatch;
	}

	public void setPkMatch(PkMatch pkMatch) {
		this.pkMatch = pkMatch;
	}

	public Integer getRCv() {
		return this.RCv;
	}

	public void setRCv(Integer rCv) {
		this.RCv = rCv;
	}

	public Integer getBBv() {
		return this.BBv;
	}

	public void setBBv(Integer bBv) {
		this.BBv = bBv;
	}

	public Integer getSceneId() {
		return this.sceneId;
	}

	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	public int getMaxLvl() {
		return this.maxLvl;
	}

	public void setMaxLvl(int maxLvl) {
		this.maxLvl = maxLvl;
	}

	public long getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(long playTime) {
		this.playTime = playTime;
	}

	public long getPlayEndTime() {
		return this.playEndTime;
	}

	public void setPlayEndTime(long playEndTime) {
		this.playEndTime = playEndTime;
	}

	public SLDHGroup getPkGroup() {
		return this.pkGroup;
	}

	public void setPkGroup(SLDHGroup pkGroup) {
		this.pkGroup = pkGroup;
	}

	public int getWinCamp() {
		return this.winCamp;
	}

	public void setWinCamp(int winCamp) {
		this.winCamp = winCamp;
	}

	public OneArenaRole getOneArenaRole1() {
		return this.oneArenaRole1;
	}

	public void setOneArenaRole1(OneArenaRole oneArenaRole1) {
		this.oneArenaRole1 = oneArenaRole1;
	}

	public OneArenaRole getOneArenaRole2() {
		return this.oneArenaRole2;
	}

	public void setOneArenaRole2(OneArenaRole oneArenaRole2) {
		this.oneArenaRole2 = oneArenaRole2;
	}

	public int getMaxSum() {
		return this.maxSum;
	}

	public void setMaxSum(int maxSum) {
		this.maxSum = maxSum;
	}

	public TeamArenaGroup getTeamArenaGroup() {
		return this.teamArenaGroup;
	}

	public void setTeamArenaGroup(TeamArenaGroup teamArenaGroup) {
		this.teamArenaGroup = teamArenaGroup;
	}

	public int getHJv() {
		return this.HJv;
	}

	public void setHJv(int HJv) {
		this.HJv = HJv;
	}
	
	public int getWssType() {
		return this.wssType;
	}

	public void setWssType(int wssType) {
		this.wssType = wssType;
	}

}
