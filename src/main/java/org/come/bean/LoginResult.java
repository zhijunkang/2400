package org.come.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import come.tool.Calculation.BaseMeridians;
import come.tool.Calculation.BaseQl;
import come.tool.Calculation.BaseXingpans;

import org.come.entity.RoleSummoning;
import org.come.protocol.ParamTool;
import org.come.server.GameServer;
import org.come.tool.JmSum;

import come.tool.Role.RoleData;
import come.tool.Role.RoleShow;
import come.tool.Scene.LaborDay.LaborRole;
import come.tool.newTeam.TeamRole;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.collections.CollectionUtils;
/**
 * 登入返回角色实体类
 * @author 叶豪芳
 * @date : 2017年11月23日 下午2:58:19
 */
public class LoginResult {
	private Integer ttVictory;
    private Integer ttFail;

    private String TTJIANGLI;
    private BigDecimal ttRecord;
	// 帮派名称
	private String gangname;
	// 角色ID
	private BigDecimal role_id;
	// 种族名称
	private String race_name;
	// 用户ID
	private BigDecimal user_id;
	// 种类ID
	private BigDecimal species_id;
	// 召唤兽ID
	private BigDecimal summoning_id;
    //飞行器ID
    private Integer fly_id;
    private String flyskin;
	// 参战伙伴id
	private String pals;
	// 角色表里的帮派ID
	private BigDecimal gang_id;
	// 坐骑ID
	private Integer mount_id;
	// 队伍ID
	private BigDecimal troop_id;
	// 种族ID
	private BigDecimal race_id;

	private Boolean divineRune = false;//神行符
	// 摆摊ID
	private BigDecimal booth_id;
	//任务id 现在是徽章id
    private Integer skill_id;
	// 血量
	private BigDecimal hp;
	// 蓝量
	private BigDecimal mp;
	// 金币
	private BigDecimal gold;
	// 绑玉
	private BigDecimal savegold;
	// 点卡
	private BigDecimal codecard;
	// 经验
	private BigDecimal experience;
	// 等级
	private Integer grade;
	// 声望
	private BigDecimal prestige;
	// 战绩
	private BigDecimal pkrecord;
	// 角色名字
	private String rolename;
	// 角色称谓
	private String title;
	// 角色本名
	private String localname;
	// 用户名
	private String userName;
	// 密码
	private String userPwd;
	// 状态
	private Integer activity;
	// 性别
	private String sex;
	// 所在坐标
	private Long x;
	private Long y;
	// 所在地图
	private Long mapid;
	// 帮派职务
	private String gangpost;
	// 帮派成就
	private BigDecimal achievement;
	// 帮派贡献
	private BigDecimal contribution;
	// 根骨
	private Integer bone;
	// 灵性
	private Integer spir;
	// 力量
	private Integer power;
	// 敏捷
	private Integer speed;
	// 定力
	private Integer calm;
	// 修为点
	private Integer xiuwei;
	// 已兑换属性点
	private String extraPoint;		
	// 判断是否在战斗中(1、战斗中)
	private Integer fighting;
	// 下线时间
	private String uptime;
	// 背包密码
	private String password;
	// 是否有待产宝宝（为空没有  1、有）
	private Integer havebaby;
	// 洞房时间
	private long makeloveTime;
	//结婚的对象
	private String marryObject;
	//宝宝id
	private BigDecimal babyId;
	//角色技能ID
	private BigDecimal SkillS_Id;
	//宝宝状态
	private String babyState;
	// 累计充值金额
	private Integer money;
	//队伍信息（队长名字|队员一|队员二|.......）
	private String teamInfo;
	//技能集合 技能名字=熟练度|技能名字=熟练度
	private String Skills;
	// 定时物品效果使用
	private String TimingGood;
	// 转生标识字段（0转为0，1转为1以此类推）
	private int TurnAround;
	// 坐牢标志      PK点数=身份标志=做天牢次数=每周坐牢次数
	private String taskDaily;
	private String born;
   	//帮派守护主副抗性字段(抗性)  存储形式(主属性=值|副属性=值)
   	private String resistance;
   	//角色服务器区号
   	private String serverMeString;
   	//记录完成次数
 	private String taskComplete;
   	//记录任务数据
 	private String taskData; 
 	//记录使用的双倍时间 剩余精确到秒 6小时 21600秒
 	private Integer DBExp;
 	//记录积分
 	private String Score;
 	//记录击杀记录
 	private String Kill;
 	// 抽奖时间
 	private Date drawing;
 	//记录帮派积分
 	private Integer bangScore;
	//额外皮肤
  	private String skin;
	private String     meridians; //完整经脉系统
  	private BigDecimal Paysum;// 角色的总充值积分， 
  	private BigDecimal Daypaysum;// 角色的日累计充值 
  	private BigDecimal Dayandpayorno;//连续充值标识 1-7 
  	private int        Dayfirstinorno;//是否最新叠加冲值标识 0 表示没 有叠加，1 表示今日已经叠加
	private int        attachPack;// 扩充背包数量
	private int        hjmax;//战绩系统
	private int        dianka;//点卡系统
  	private BigDecimal Daygetorno;// 每日特惠领取与否 1 表示领取 2 表示没有 
  	private String Vipget;// 特权领取规则 1=1|2|3&&2=1|2|3其中1=表示vip特权,2=表示每日充 值领取等级包，1 表示 1 级，2 表示 2 级，以此类推。 
  	private int lowOrHihtpack;//小资礼包/土豪礼包获取 权限 1 表示小资礼包，2 表示土豪礼包。
  	//展示
    private transient RoleShow roleShow;
    private transient TeamRole teamRole;
    private transient int[] dailys;
    private transient RoleData roleData;
    private transient LaborRole laborRole;
    private String gmshoptype;// 
	private LinkedHashMap<Integer,BaseMeridians> meridiansMap;

	private Integer fmsld;
	
	private String qianDao;//ED=1,10&1,7
	private Long loginTime;
	private Long onlineTime;
	private LoginQD loginQD = new LoginQD();
	
	private String xingpans;
	private LinkedHashMap<Integer,BaseXingpans> xingpansMap;
    private BigDecimal tiantipkrecord;
    private Integer tiantiyisheng;
    private Integer tiantisansheng;
    private Integer tiantilingqu;
    private Integer gradeincrease;//人物等级上限增加
    private Integer gameTimeRemaining;//剩余点卡
    private String gameStartTime;//剩余点卡
    private Integer currentattribute;//当前属性编号
    private List<RoleSummoning> showRoleSummoningList;

	private AutoSwitchBean autoSwitchBean;
    public int[] getDaily(){
		if (this.dailys==null) {
			this.dailys=new int[4];
			try {
				String[] v=this.taskDaily.split("\\|");
				this.dailys[0]=Integer.parseInt(v[0]);
				this.dailys[0]=Integer.parseInt(v[1]);
				this.dailys[0]=Integer.parseInt(v[2]);
				this.dailys[0]=Integer.parseInt(v[3]);		
			} catch (Exception e) {
				
			}
		}
		return this.dailys;
    }
    public String upDaily(int[] dailys){
    	if (dailys.length!=4) {
			return "0|0|0|0";
		}
    	this.dailys=dailys;
    	this.taskDaily=dailys[0]+"|"+dailys[1]+"|"+dailys[2]+"|"+dailys[3];
		return this.taskDaily;
    }
  	/** 获取人物战斗皮肤 */
	public String getBattleSkin(long weapon) {
		StringBuffer buffer=new StringBuffer();
		boolean is=true;
		if (this.skin!=null&&!this.skin.equals("")) {
			String[] vs=this.skin.split("\\|");
			for (int i = 0; i < vs.length; i++) {
				if (vs[i].startsWith("X") || vs[i].startsWith("P")) {
					if (buffer.length()!=0) {
						buffer.append("&");
					}
					String[] ts=vs[i].substring(1).split("_");
					buffer.append("tx/tx");
					buffer.append(ts[0]);
					buffer.append("_");
					buffer.append(ts[1]);
				} else if (vs[i].startsWith("S")) {
					is=false;
					if (buffer.length()!=0) {
						buffer.append("&");
					}
					buffer.append(vs[i].substring(1));
					buffer.append("_1_7");
				} else if (vs[i].startsWith("B")) {//战斗隐藏翅膀
//					if (buffer.length()!=0) {
//						buffer.append("&");
//					}
//					String cb=vs[i].substring(1);
//					buffer.append("tx/");
//					buffer.append(cb);
//					buffer.append("0_-5&tx/");
//					buffer.append(cb);
//					buffer.append("1_5");
				}
			}
		}
		if (is) {
			if (buffer.length()!=0) {buffer.append("&");}
			if (weapon!=0) {
				buffer.append((weapon<<32)|this.species_id.longValue());
			}else {
				buffer.append(this.species_id);
			}
			buffer.append("_1_7");
		}
		if (getSkill_id()!=null) {
			buffer.append("&W");
			buffer.append(getSkill_id());
		}
		return buffer.toString();
	}
  	
  	/**赋值*/
  	public void transfer(LoginResult login){
  		
  		this.species_id=login.species_id;
  		this.summoning_id=login.summoning_id;
  		this.mount_id=login.mount_id;
  		this.race_id=login.race_id;
  		this.race_name=login.race_name;
  		this.localname=login.localname;
  		this.sex=login.sex;
  		this.skill_id=login.skill_id;
  		this.title=login.title;
  		this.x=login.x;
  		this.y=login.y;
  		this.mapid=login.mapid;
  		this.achievement=login.achievement;
  		this.contribution=login.contribution;
  		
  		this.troop_id=login.troop_id;
  		this.fighting=login.fighting;
  		
  		this.savegold=login.savegold;
  		this.password=login.password;
  		
  		this.hp=login.hp;
  		this.mp=login.mp;
  		this.bone=login.bone;
  		this.spir=login.spir;
  		this.power=login.power;
  		this.speed=login.speed;
  		this.calm=login.calm;
  		this.xiuwei=login.xiuwei;
  		this.extraPoint=login.extraPoint;

  		
  		if (this.getGold().compareTo(login.getGold()) > 0) {this.gold=login.gold;}
  		this.experience=login.experience;
  		this.grade=login.grade;
  		this.TurnAround=login.TurnAround;
  		
  		this.havebaby=login.havebaby;
  		this.makeloveTime=login.makeloveTime;
  		this.marryObject=login.marryObject;
  		this.babyId=login.babyId;
  		this.SkillS_Id=login.SkillS_Id;
  		this.babyState=login.babyState;
  		this.teamInfo=login.teamInfo;
  		this.taskDaily=login.taskDaily;
  		this.resistance=login.resistance;
  		this.drawing=login.drawing;
  		this.skin=login.skin;
		this.hjmax = login.hjmax;
		this.meridians = login.meridians;
		this.fmsld=login.fmsld;
		this.gmshoptype=login.gmshoptype;
  	}
	public double getKilltype(String type) {
		if (this.Kill==null||this.Kill.equals(""))return 0;
		String[] v=this.Kill.split("\\|");
		for (int i = 0; i < v.length; i++) {
			String[] v2=v[i].split("=");
			if (v2[0].equals(type))
				return Double.parseDouble(v2[1]);
		}
		return 0;
	}
	public int getJQId(String type) {
		if (this.taskComplete==null||this.taskComplete.equals(""))return 0;
		String[] v=this.taskComplete.split("\\|");
		for (int i = 0; i < v.length; i++) {
			if (v[i].startsWith(type)) {
				return Integer.parseInt(v[i].substring(1));
			}
		}
		return 0;
	}
 	public Integer getBangScore() {
		return this.bangScore;
	}
	public void setBangScore(Integer bangScore) {
		this.bangScore = bangScore;
	}
	public String getScore() {
		return this.Score;
	}
	public void setScore(String score) {
		this.Score = score;
	}
	public String getKill() {
		return this.Kill;
	}
	public void setKill(String kill) {
		this.Kill = kill;
	}
	public Integer getDBExp() {
		return this.DBExp;
	}
	public void setDBExp(Integer dBExp) {
		this.DBExp = dBExp;
	}
	public String getGangname() {
		return this.gangname;
	}
	public void setGangname(String gangname) {
		this.gangname = gangname;
		if (this.roleShow!=null) {
			this.roleShow.setGangname(gangname);
		}
	}
	public BigDecimal getRole_id() {
		return this.role_id;
	}
	public void setRole_id(BigDecimal role_id) {
		this.role_id = role_id;
	}
	public String getRace_name() {
		return this.race_name;
	}
	public void setRace_name(String race_name) {
		this.race_name = race_name;
	}
	public BigDecimal getUser_id() {
		return this.user_id;
	}
	public void setUser_id(BigDecimal user_id) {
		this.user_id = user_id;
	}
	public BigDecimal getSpecies_id() {
		return this.species_id;
	}
	public void setSpecies_id(BigDecimal species_id) {
		this.species_id = species_id;
		if (this.roleShow!=null) {
			this.roleShow.setSpecies_id(species_id);
		}
		if (this.teamRole!=null) {
			this.teamRole.setSpeciesId(species_id);
		}
	}
	public BigDecimal getSummoning_id() {
		return this.summoning_id;
	}
	public void setSummoning_id(BigDecimal summoning_id) {
		this.summoning_id = summoning_id;
	}
	public BigDecimal getGang_id() {
		return this.gang_id;
	}
	public void setGang_id(BigDecimal gang_id) {
		this.gang_id = gang_id;
		if (this.roleShow!=null) {
			this.roleShow.setGang_id(gang_id);
		}
	}
	public Integer getMount_id() {
		return this.mount_id;
	}
	public void setMount_id(Integer mount_id) {
		this.mount_id = mount_id;
		if (this.roleShow!=null) {
			this.roleShow.setMount_id(mount_id);
		}
	}
	public BigDecimal getTroop_id() {
		return this.troop_id;
	}
	public void setTroop_id(BigDecimal troop_id) {
		this.troop_id = troop_id;
		if (this.roleShow!=null) {
			this.roleShow.setTroop_id(troop_id);
		}
	}
	public BigDecimal getRace_id() {
		return this.race_id;
	}
	public void setRace_id(BigDecimal race_id) {
		this.race_id = race_id;
	}
	public BigDecimal getBooth_id() {
		return this.booth_id;
	}
	public void setBooth_id(BigDecimal booth_id) {
		this.booth_id = booth_id;
		if (this.roleShow!=null) {
			this.roleShow.setBooth_id(booth_id);
		}
	}
	public BigDecimal getHp() {
		return this.hp;
	}
	public void setHp(BigDecimal hp) {
		this.hp = hp;
	}
	public BigDecimal getMp() {
		return this.mp;
	}
	public void setMp(BigDecimal mp) {
		this.mp = mp;
	}
	public BigDecimal getGold() {
		return new BigDecimal(JmSum.MZ(this.gold.longValue()));
	}
	static BigDecimal MAX=new BigDecimal("999999999999");//金币上限
	static BigDecimal MIN=new BigDecimal(0);
	public void setGold(BigDecimal gold) {	
		if( gold.compareTo(MAX) > 0 ){
			gold=new BigDecimal("999999999999");//超过没收
		}else if(gold.compareTo(MIN) < 0){
			if( this.userName != null && GameServer.getInlineUserNameMap().get(this.userName) != null ){
				this.gold = new BigDecimal(JmSum.ZM(gold.longValue()));
				ParamTool.ACTION_MAP.get("accountstop").action(GameServer.getInlineUserNameMap().get(this.userName), this.userName);
				return;
			}
		}
		this.gold = new BigDecimal(JmSum.ZM(gold.longValue()));
	}
	public BigDecimal getCodecard() {
		return new BigDecimal(JmSum.MZ(this.codecard.longValue()));
	}
	public void setCodecard(BigDecimal codecard) {
		// 仙玉小于0时，直接封号
//		if(codecard.compareTo(new BigDecimal(0)) < 0){
//			if( this.userName != null && GameServer.getInlineUserNameMap().get(this.userName) != null ){
//				ParamTool.ACTION_MAP.get("accountstop").action(GameServer.getInlineUserNameMap().get(this.userName), this.userName);;
//			}
//		}
		this.codecard = new BigDecimal(JmSum.ZM(codecard.longValue()));
	}
	public BigDecimal getExperience() {
		return new BigDecimal(JmSum.MZ(this.experience.longValue()));
	}
	public void setExperience(BigDecimal experience) {
		this.experience = new BigDecimal(JmSum.ZM(experience.longValue()));
	}
	public Integer getGrade() {
		return (int) JmSum.MZ(this.grade.longValue());
	}
	public void setGrade(Integer grade) {
		this.grade = (int) JmSum.ZM(grade.longValue());
        if (this.roleShow !=null) { this.roleShow.setGrade(grade); }
        if (this.teamRole !=null) { this.teamRole.setGrade(grade); }
        if (this.laborRole!=null) { this.laborRole.setLvl(grade); }
	}
	public BigDecimal getPrestige() {
		return this.prestige;
	}
	public void setPrestige(BigDecimal prestige) {
		this.prestige = prestige;
	}
	public BigDecimal getPkrecord() {
		return this.pkrecord;
	}
	public void setPkrecord(BigDecimal pkrecord) {
		this.pkrecord = pkrecord;
	}
	public String getRolename() {
		return this.rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
		if (this.roleShow!=null) { this.roleShow.setRolename(rolename); }
		if (this.teamRole!=null) { this.teamRole.setName(rolename); }
		if (this.laborRole!=null) { this.laborRole.setName(rolename); }
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
		if (this.roleShow!=null) {
			this.roleShow.setTitle(title);
		}
	}
	public String getLocalname() {
		return this.localname;
	}
	public void setLocalname(String localname) {
		this.localname = localname;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return this.userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getSex() {
		return this.sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Long getX() {
		return this.x;
	}
	public void setX(Long x) {
		this.x = x;
		if (this.roleShow!=null) {
			this.roleShow.setX(x);
		}
	}
	public Long getY() {
		return this.y;
	}
	public void setY(Long y) {
		this.y = y;
		if (this.roleShow!=null) {
			this.roleShow.setY(y);
		}
	}
	public Long getMapid() {
		return this.mapid;
	}
	public void setMapid(Long mapid) {
		this.mapid = mapid;
		if (this.roleShow!=null) {
			this.roleShow.setMapid(mapid);
		}
	}
	public String getGangpost() {
		return this.gangpost;
	}
	public void setGangpost(String gangpost) {
		this.gangpost = gangpost;
	}
	public BigDecimal getAchievement() {
		return this.achievement;
	}
	public void setAchievement(BigDecimal achievement) {
		this.achievement = achievement;
	}
	public BigDecimal getContribution() {
		return this.contribution;
	}
	public void setContribution(BigDecimal contribution) {
		this.contribution = contribution;
	}
	
	public Integer getBone() {
		 return (int) JmSum.MZ(this.bone.longValue());
//		return bone;
	}
	public void setBone(Integer bone) {
		this.bone =(int) JmSum.ZM(bone.longValue());
//		this.bone = bone;
	}
	public Integer getSpir() {
		return (int) JmSum.MZ(this.spir.longValue());
//		return spir;
	}
	public void setSpir(Integer spir) {
		this.spir =(int) JmSum.ZM(spir.longValue());
//		this.spir = spir;
	}
	public Integer getPower() {
		return (int) JmSum.MZ(this.power.longValue());
//		return power;
	}
	public void setPower(Integer power) {
		this.power =(int) JmSum.ZM(power.longValue());
//		this.power = power;
	}
	public Integer getSpeed() {
		return (int) JmSum.MZ(this.speed.longValue());
//		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed =(int) JmSum.ZM(speed.longValue());
//		this.speed = speed;
	}
	public Integer getFighting() {
		return this.fighting;
	}
	public void setFighting(Integer fighting) {
		this.fighting = fighting;
		if (this.roleShow!=null) {
			this.roleShow.setFighting(fighting);
		}
	}
	public String getUptime() {
		return this.uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public BigDecimal getSavegold() {
		return this.savegold;
	}
	public void setSavegold(BigDecimal savegold) {
		this.savegold = savegold;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getHavebaby() {
		return this.havebaby;
	}
	public void setHavebaby(Integer havebaby) {
		this.havebaby = havebaby;
	}
	public long getMakeloveTime() {
		return this.makeloveTime;
	}
	public void setMakeloveTime(long makeloveTime) {
		this.makeloveTime = makeloveTime;
	}
	public String getMarryObject() {
		return this.marryObject;
	}
	public void setMarryObject(String marryObject) {
		this.marryObject = marryObject;
	}



	public BigDecimal getBabyId() {
		return this.babyId;
	}
	public void setBabyId(BigDecimal babyId) {
		this.babyId = babyId;
	}


	public BigDecimal getSkillS_Id() {
		return this.SkillS_Id;
	}
	public void setSkillS_Id(BigDecimal s) {
		this.SkillS_Id = this.SkillS_Id;
	}


	public String getBabyState() {
		return this.babyState;
	}
	public void setBabyState(String babyState) {
		this.babyState = babyState;
	}
	public Integer getMoney() {
		return this.money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getTeamInfo() {
		return this.teamInfo;
	}
	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
		if (this.roleShow!=null) {
			this.roleShow.setTeamInfo(teamInfo);
		}
	}
	public String getSkills() {
		return this.Skills;
	}
	public void setSkills(String skills) {
		this.Skills = skills;
	}
	public String getTimingGood() {
		return this.TimingGood;
	}
	public void setTimingGood(String timingGood) {
		this.TimingGood = timingGood;
	}
	public int getTurnAround() {
		return this.TurnAround;
	}
	public void setTurnAround(int turnAround) {
		this.TurnAround = turnAround;
		if (this.roleShow!=null) {
			this.roleShow.setTurnAround(turnAround);
		}
	}
	public String getTaskDaily() {
		return this.taskDaily;
	}
	public void setTaskDaily(String taskDaily) {
		this.taskDaily = taskDaily;
	}
	public String getBorn() {
		return this.born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	public String getResistance() {
		return this.resistance;
	}
	public void setResistance(String resistance) {
		this.resistance = resistance;
	}
	public String getServerMeString() {
		return this.serverMeString;
	}
	public void setServerMeString(String serverMeString) {
		this.serverMeString = serverMeString;
	}
	public String getTaskComplete() {
		if (this.taskComplete==null) {
			this.taskComplete="";
		}
		return this.taskComplete;
	}
	public void setTaskComplete(String taskComplete) {
		this.taskComplete = taskComplete;
	}
	public String getTaskData() {
		return this.taskData;
	}
	public void setTaskData(String taskData) {
		this.taskData = taskData;
	}
	
	public Integer getActivity() {
		return this.activity;
	}
	public void setActivity(Integer activity) {
		this.activity = activity;
	}
	
	public Date getDrawing() {
		return this.drawing;
	}
	public void setDrawing(Date drawing) {
		this.drawing = drawing;
	}
	public BigDecimal getScoretype(String type) {
		if (this.Score==null||this.Score.equals(""))return new BigDecimal(0);
		String[] v=this.Score.split("\\|");
		for (int i = 0; i < v.length; i++) {
			String[] v2=v[i].split("=");
			if (v2[0].equals(type))
				return new BigDecimal(v2[1]);
		}
		return new BigDecimal(0);
	}
	//获取队伍
	public String getTeam(){
		if (this.teamInfo==null||this.teamInfo.equals("")||this.teamInfo.equals("|")) {
			return this.rolename;
		}else {
			return this.teamInfo;
		}		
	}
	public Integer getSkill_id() {
		return this.skill_id;
	}
	public void setSkill_id(Integer skill_id) {
		this.skill_id = skill_id;
		if (this.roleShow!=null) {
			this.roleShow.setSkill_id(skill_id);
		}
	}
	public String getSkin() {
		return this.skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
		if (this.roleShow!=null) {
			this.roleShow.setSkin(skin);
		}
	}
	public Integer getCalm() {
		return (int) JmSum.MZ(this.calm.longValue());
	}
	public void setCalm(Integer calm) {
		this.calm =(int) JmSum.ZM(calm.longValue());
	}
	public Integer getXiuwei() {
		return (int) JmSum.MZ(this.xiuwei.longValue());
	}
	public void setXiuwei(Integer xiuwei) {
		this.xiuwei =(int) JmSum.ZM(xiuwei.longValue());
	}
	public String getExtraPoint() {
		return this.extraPoint;
	}
	public void setExtraPoint(String extraPoint) {
		this.extraPoint = extraPoint;
	}
	public RoleShow getRoleShow() {
		return this.roleShow;
	}
	public void setRoleShow(RoleShow roleShow) {
		this.roleShow = roleShow;
	}
	public TeamRole getTeamRole() {
		if (this.teamRole==null) {
			this.teamRole=new TeamRole(this);
		}
		return this.teamRole;
	}
	public void initTeamRole(TeamRole teamRole) {
		this.teamRole=teamRole;
		this.teamRole.upTeamRole(this);
	}
	/**获取帮派修炼属性*/
	public String[] getResistance(String type) {
		if (this.resistance==null||this.resistance.equals("")) {
			return null;
		}
		String[] vs=this.resistance.split("\\|");
	    for (int i = 0; i < vs.length; i++) {
	    	if (vs[i].startsWith(type)) {
	    		String[] v=vs[i].split("#");
	    		v[0]=v[0].substring(1);
	    		return v;
	    	}
		}
		return null;
	}
	public String setResistance(int type,String data) {
		String QZ=type==1?"X":"D";
		if (this.resistance==null||this.resistance.equals("")) {
			if (data==null) {
				return "";
			}
			this.resistance=QZ+data;
			return this.resistance;
		}
		String[] vs=this.resistance.split("\\|");
		for (int i = 0; i < vs.length; i++) {
	    	if (vs[i].startsWith(QZ)) {
	    		vs[i]=null;
	    		break;
	    	}
		}
		StringBuffer buffer=new StringBuffer();
		for (int i = 0; i < vs.length; i++) {
			if (vs[i]!=null) {
				if (buffer.length()!=0) {buffer.append("|");}
				buffer.append(vs[i]);	
			}
		}
		if (data!=null) {
			if (buffer.length()!=0) {buffer.append("|");}
			buffer.append(QZ);
			buffer.append(data);
		}
		this.resistance=buffer.toString();
		return this.resistance;
		
	}
	/**F额外分配属性点  T天演策修炼进度   X小成修炼点 D大成修炼点*/
	public int getExtraPointInt(String type) {
		if (this.extraPoint==null||this.extraPoint.equals("")) {
			return 0;
		}
	    String[] vs=this.extraPoint.split("\\|");
	    for (int i = 0; i < vs.length; i++) {
	    	if (vs[i].startsWith(type)) {
	    		return Integer.parseInt(vs[i].substring(1));
	    	}
		}
	    return 0;
	}
	public int getExtraPointInt() {
		if (this.extraPoint==null||this.extraPoint.equals("")) {
			return 0;
		}
	    String[] vs=this.extraPoint.split("\\|");
	    int p=0;
	    for (int i = 0; i < vs.length; i++) {
	    	if (vs[i].startsWith("F")) {
	    		p+=Integer.parseInt(vs[i].substring(1));			
			}
		}
	    return p;
	}
	public void setExtraPoint(String type,int p) {
		type=type.substring(0, 1);
		if (this.extraPoint==null||this.extraPoint.equals("")) {
			this.extraPoint=type+p;
		}
		String[] vs=this.extraPoint.split("\\|");
		for (int i = 0; i < vs.length; i++) {
			if (vs[i].startsWith(type)) {
				vs[i]=type+(Integer.parseInt(vs[i].substring(1))+p);
				StringBuffer buffer=new StringBuffer();
				for (int j = 0; j < vs.length; j++) {
					if (buffer.length()!=0) {buffer.append("|");}
					buffer.append(vs[j]);
				}
				this.extraPoint=buffer.toString();
				return;
			}
		}
		StringBuffer buffer=new StringBuffer();
		for (int j = 0; j < vs.length; j++) {
			if (buffer.length()!=0) {buffer.append("|");}
			buffer.append(vs[j]);
		}
		if (buffer.length()!=0) {buffer.append("|");}
		buffer.append(type);
		buffer.append(p);
		this.extraPoint=buffer.toString();
	}
	public BigDecimal getPaysum() {
		return this.Paysum;
	}
	public void setPaysum(BigDecimal paysum) {
		this.Paysum = paysum;
	}
	public BigDecimal getDaypaysum() {
		return this.Daypaysum;
	}
	public void setDaypaysum(BigDecimal daypaysum) {
		this.Daypaysum = daypaysum;
	}
	public BigDecimal getDayandpayorno() {
		return this.Dayandpayorno;
	}
	public void setDayandpayorno(BigDecimal dayandpayorno) {
		this.Dayandpayorno = dayandpayorno;
	}
	public BigDecimal getDaygetorno() {
		return this.Daygetorno;
	}
	public void setDaygetorno(BigDecimal daygetorno) {
		this.Daygetorno = daygetorno;
	}
	public String getVipget() {
		return this.Vipget;
	}
	public void setVipget(String vipget) {
		this.Vipget = vipget;
	}
//	1=1|2|3&&2=1|2|3其中1=表示vip特权,2=表示每日充 值领取等级包，1 表示 1 级，2 表示 2 级，以此类推
	public void removeVipget(String type){
		if (this.Vipget==null||this.Vipget.equals("")) {
			return;
		}
		StringBuffer buffer=new StringBuffer();
		String[] vs=this.Vipget.split("&&");
		for (int i = 0; i < vs.length; i++) {
			if (vs[i].split("=")[0].equals(type)) {
				vs[i]=null;
			}else {
				if (buffer.length()!=0) {
					buffer.append("&&");
				}
				buffer.append(vs[i]);
			}
		}
		if (buffer.length()==0) {
			this.Vipget=null;
		}else {
			this.Vipget=buffer.toString();	
		}	
	}
	public int getLowOrHihtpack() {
		return this.lowOrHihtpack;
	}
	public void setLowOrHihtpack(int lowOrHihtpack) {
		this.lowOrHihtpack = lowOrHihtpack;
	}
	public int getDayfirstinorno() {
		return this.Dayfirstinorno;
	}
	public String getPals() {
		return this.pals;
	}
	public void setPals(String pals) {
		this.pals = pals;
	}
	public void setDayfirstinorno(int dayfirstinorno) {
		this.Dayfirstinorno = dayfirstinorno;
	}
	public RoleData getRoleData() {
		return this.roleData;
	}
	public void setRoleData(RoleData roleData) {
		this.roleData = roleData;
	}
	public void setLaborRole(LaborRole laborRole) {
		this.laborRole = laborRole;
	}
	public String getMeridians() {
		return this.meridians;
	}
	public void setMeridians(String meridians) {
		this.meridians = meridians;
	}
	/**包裹卡*/
	public int getAttachPack() {return attachPack;}
	public void setAttachPack(int attachPack) {
		this.attachPack = attachPack;
	}
	public int getHjmax() {
		return hjmax;
	}
	public void setHjmax(int hjmax) {
		this.hjmax = hjmax;
	}
	public int getDianka() {
		return dianka;
	}
	public void setDianka(int dianka) {
		this.dianka = dianka;
	}
	/**
	 * 返回某一条经脉的值
	 * @param key
	 * @return
	 */
	public double getMeridiansValue(String key) {
		if (meridiansMap == null) {
			return 0;
		}
		double v = 0;
		for (BaseMeridians meridian : meridiansMap.values()) {
			if (meridian.getKey().equals(key)) {
				v += meridian.getKeyValue();
			}
		}
		return v;
	}
	/**
	 * 计算当前经脉属性返回BaseQl提供战斗包计算
	 * @return
	 */
	public BaseQl[] getBaseQl() {
		if (meridiansMap == null || meridiansMap.size() == 0) {
			return null;
		}
		BaseQl[] base = new BaseQl[meridiansMap.size()];

		for (int i = 0 ; i < meridiansMap.size() ; i++) {
			base[i] = new BaseQl(meridiansMap.get(i + 1).getKey(),meridiansMap.get(i + 1).getKeyValue());
		}
		return base;
	}

	public Integer getFmsld() {
		return fmsld;
	}
	public void setFmsld(Integer fmsld) {
		this.fmsld = fmsld;
	}
	
	public String getXingpans() {
		return xingpans;
	}
	public void setXingpans(String xingpans) {
		this.xingpans = xingpans;
		upXingpans(xingpans);
	}

	public void setXingpans(int num,BaseXingpans xingpans) {
		xingpansMap.put(num,xingpans);
		StringBuilder temp = new StringBuilder();
		for (BaseXingpans xingpan : xingpansMap.values()) {
			if (temp.length() > 0) {
				temp.append("|");
			}
			temp.append(xingpan.toString());
		}
		this.xingpans = temp.toString();
	}

	public BaseXingpans getXingpans(int num) {
		if (xingpansMap == null) {
			xingpansMap = new LinkedHashMap<>();
		}
		return xingpansMap.get(num);
	}

	public void upXingpans(String xingpans){
		if (xingpansMap == null) {
			xingpansMap = new LinkedHashMap<>();
		}
		if (xingpans==null||xingpans.equals("")) {
			return;
		}
		BaseXingpans baseXingpansR=null;
		String[] vs=xingpans.split("\\|");
		for (int i = 0; i < vs.length; i++) {
			String[] vss=vs[i].split("_");
			if (vss.length!=7) {
				continue;
			}
			int bh=Integer.parseInt(vss[0]);
			baseXingpansR=new BaseXingpans(bh,
					vss[1], Integer.parseInt(vss[2]),
					vss[3], Double.parseDouble(vss[4]),
					vss[5], Double.parseDouble(vss[6]));
			xingpansMap.put(bh, baseXingpansR);
		}
	}

	/**
	 * 计算当前星盘属性返回BaseQl提供战斗包计算 星盘
	 * @return
	 */
	public BaseQl[] getBaseQl1() {
		if (xingpans == null) {
			return null;
		}


		String[] vs=xingpans.split("\\|");
		BaseQl[] base = new BaseQl[(vs.length*2)];
		for (int i = 0; i < base.length; i++) {
			if(i<vs.length){
				String[] vss=vs[i].split("_");
				int bh=Integer.parseInt(vss[0]);
				base[i] = new BaseQl(xingpansMap.get(bh).getKey1(),xingpansMap.get(bh).getKeyValue1());
			}else {
				String[] vss=vs[(i-vs.length)].split("_");
				int bh=Integer.parseInt(vss[0]);
				base[i] = new BaseQl(xingpansMap.get(bh).getKey(),xingpansMap.get(bh).getKeyValue());
			}

		}
		return base;
	}


	/**
	 * 返回某一条星盘的值
	 * @param key
	 * @return
	 */
	public double getXingpansValue(String key) {
		if (xingpansMap == null) {
			return 0;
		}
		double v = 0;
		for (BaseXingpans xingpan : xingpansMap.values()) {
			if (xingpan.getKey().equals(key)) {
				v += xingpan.getKeyValue();
			}
		}
		return v;
	}
	
	
	
	public String getQianDao() {
		return qianDao;
	}

	public LoginQD getQianDaoObject()
	{
		if (loginQD == null)
		{
			loginQD = new LoginQD();
		}
		loginQD.init();
		return loginQD;
	}
	public void setQianDao(String qianDao) {
		this.qianDao = qianDao;
	}

	public Long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}

	public Long getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Long onlineTime) {
		this.onlineTime = onlineTime;
	}
	public LoginQD getLoginQD()
	{
		return loginQD;
	}

	public void setLoginQD(LoginQD loginQD)
	{
		this.loginQD = loginQD;
	}

	public Boolean getDivineRune() {
		return divineRune;
	}

	public void setDivineRune(Boolean divineRune) {
		this.divineRune = divineRune;
	}

	public class LoginQD
	{
		private HashSet<Integer> ed=new HashSet<>();

		private HashSet<Integer> lq=new HashSet<>();

		private void init()
		{
			if (StringUtils.isEmpty(qianDao))
			{
				return;
			}
			String[] split = qianDao.split("&");
			String[] eds = split[0].split("=");

			if (eds.length > 1)
			{
				ed = new HashSet<>();
				for (String s : eds[1].split(","))
				{
					ed.add(Integer.valueOf(s));
				}
			}

			String[] lqs = split[1].split("=");
			if (lqs.length > 1)
			{
				lq = new HashSet<>();
				for (String s : lqs[1].split(","))
				{
					lq.add(Integer.valueOf(s));
				}
			}
		}

		private String end()
		{
			if (CollectionUtils.isEmpty(ed) && CollectionUtils.isEmpty(lq))
			{
				return null;
			}
			StringBuffer os = new StringBuffer("ED=");
			if (CollectionUtils.isNotEmpty(ed))
			{
				ed.forEach(e -> {
					os.append(e + ",");
				});
			}
			os.append("&LQ=");
			if (CollectionUtils.isNotEmpty(lq))
			{
				lq.forEach(e -> {
					os.append(e + ",");
				});
			}
			return os.toString().substring(0, os.length() - 1);
		}

		public HashSet<Integer> getEd()
		{
			return ed;
		}

		public HashSet<Integer> getLq()
		{
			return lq;
		}

		public void setEd(HashSet<Integer> ed) {
			this.ed = ed;
		}

		public void setLq(HashSet<Integer> lq) {
			this.lq = lq;
		}
	}

	public String getGmshoptype() {
		return gmshoptype;
	}
	public void setGmshoptype(String gmshoptype) {
		this.gmshoptype = gmshoptype;
	}
	public void saveQiandao()
	{
		qianDao = loginQD.end();
	}
	public Integer getTtVictory() {
		return ttVictory;
	}
	public void setTtVictory(Integer ttVictory) {
		this.ttVictory = ttVictory;
	}
	public Integer getTtFail() {
		return ttFail;
	}
	public void setTtFail(Integer ttFail) {
		this.ttFail = ttFail;
	}
	public String getTTJIANGLI() {
		return TTJIANGLI;
	}
	public void setTTJIANGLI(String tTJIANGLI) {
		TTJIANGLI = tTJIANGLI;
	}
	public BigDecimal getTtRecord() {
		return ttRecord;
	}
	public void setTtRecord(BigDecimal ttRecord) {
		this.ttRecord = ttRecord;
	}
	public BigDecimal getTiantipkrecord() {
		return tiantipkrecord;
	}
	public void setTiantipkrecord(BigDecimal tiantipkrecord) {
		this.tiantipkrecord = tiantipkrecord;
	}
	public Integer getTiantiyisheng() {
		return tiantiyisheng;
	}
	public void setTiantiyisheng(Integer tiantiyisheng) {
		this.tiantiyisheng = tiantiyisheng;
	}
	public Integer getTiantisansheng() {
		return tiantisansheng;
	}
	public void setTiantisansheng(Integer tiantisansheng) {
		this.tiantisansheng = tiantisansheng;
	}
	public Integer getTiantilingqu() {
		return tiantilingqu;
	}
	public void setTiantilingqu(Integer tiantilingqu) {
		this.tiantilingqu = tiantilingqu;
	}
	public Integer getGradeincrease() {
		return gradeincrease;
	}
	public void setGradeincrease(Integer gradeincrease) {
		this.gradeincrease = gradeincrease;
	}
	public Integer getGameTimeRemaining() {
		return gameTimeRemaining;
	}
	public void setGameTimeRemaining(Integer gameTimeRemaining) {
		this.gameTimeRemaining = gameTimeRemaining;
	}
	public String getGameStartTime() {
		return gameStartTime;
	}
	public void setGameStartTime(String gameStartTime) {
		this.gameStartTime = gameStartTime;
	}
	public Integer getCurrentattribute() {
		return currentattribute;
	}
	public void setCurrentattribute(Integer currentattribute) {
		this.currentattribute = currentattribute;
	}
	  public Integer getFly_id(){return fly_id;}
	  public void setFly_id(Integer fly_id){
	        this.fly_id=fly_id;
	        if (roleShow!=null)
	            roleShow.setFly_id(fly_id);
	  }
	  public  String getFlyskin(){return  flyskin;}
	  public  void setFlyskin(String flyskin){
		 this.flyskin=flyskin;
	     if (roleShow!=null)
	         roleShow.setFlyskin(flyskin);
	  }
	//宠物跟随
    public List<RoleSummoning> getShowRoleSummoningList() {
        return showRoleSummoningList;
    }

    public void setShowRoleSummoningList(List<RoleSummoning> showRoleSummoningList) {
        this.showRoleSummoningList = showRoleSummoningList;
        if (roleShow!=null){
            roleShow.setShowRoleSummoningList(showRoleSummoningList);
        }
    }
	public AutoSwitchBean getAutoSwitchBean() {
		return autoSwitchBean;
	}

	public void setAutoSwitchBean(AutoSwitchBean autoSwitchBean) {
		this.autoSwitchBean = autoSwitchBean;
	}
}
