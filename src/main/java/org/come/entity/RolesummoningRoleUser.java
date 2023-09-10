package org.come.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.come.model.Configure;
import org.come.server.GameServer;
import org.come.tool.JmSum;

/**
 * 修改zeng-190711
 * 
 * @author zz
 * 
 */
public class RolesummoningRoleUser {

	// 召唤兽ID
	private String summoningid;
	// 召唤兽名称
	private String summoningname;
	// 皮肤
	private String summoningskin;
	// 宝宝类型
	private String ssn;
	// 是否物理怪
	private String stye;
	// 血量
	private int hp;
	// 蓝量
	private int mp;
	// 伤害
	private int ap;
	// 敏捷
	private int sp;
	// 最高成长率
	private String growlevel = "0";
	// 抗性
	private String resistance;
	// 技能
	private String skill = "";
	// 金
	private String gold;
	// 木
	private String wood;
	// 土
	private String soil;
	// 水
	private String water;
	// 火
	private String fire;
	// 变色方案
	private String ColorScheme;
	// 角色ID
	private BigDecimal roleid;
	// 根骨
	private Integer bone = 0;
	// 灵性
	private Integer spir = 0;
	// 力量
	private Integer power = 0;
	// 敏捷
	private Integer speed = 0;
	// 定力
	private Integer calm;
	// 等级
	private Integer grade = 0;
	// 经验
	private BigDecimal exp;
	// 忠诚度
	private Integer faithful;
	// 亲密值
	private Long friendliness;
	// ID
	private BigDecimal sid;

	// 有几个召唤兽技能框解开了封印（初始值为1）
	private Integer openSeal = 1;
	// 内丹 id|id
	private String innerGoods;
	// 龙骨
	private int dragon;
	// 技能 静态表id|静态表id|静态表id...
	private String petSkills;
	// 转身
	private int turnRount;
	// // 等级血量
	// private int gradehp;
	// // 等级蓝量
	// private int grademp;
	// 内丹抗性
	private String NedanResistance;
	// 被点化次数
	private int revealNum;
	// 使用神兽飞升丹的次数
	private int flyupNum;
	// 神兽技能id
	private String beastSkills;
	// 召唤兽增加四种属性几率字段
	private String fourattributes = "";
	// 召唤兽技能属性
	private String skillData = "";
	// 坐骑抗性
	private String zqk = "";
	// 炼妖抗性
	private String lyk = "";
	// 炼妖次数
	private int alchemynum = 0;
	// 使用超级元气丹的次数
	private Integer growUpDanNum = 0;
	// 龙涎丸使用次数
	private int draC;
	// 培养值
	private int trainNum;
	// 召唤兽是否有加锁
	private int petlock;

	private BigDecimal price;
	private String basisap = "0";
	private String basissp = "0";
	// 当前血量
	private int basishp;
	// 当前蓝量
	private int basismp;
	private String extrahp;
	private String extramp;
	private String extraap;
	private String extrasp;
	private String rolename;
	private BigDecimal user_id;
	private String username;

	private Integer start;
	private Integer end;
	private Integer pageNow;
	private String orderBy;

	public int getSI2(String type) {
		if (this.fourattributes == null || this.fourattributes.equals(""))
			return 0;
		String[] v = this.fourattributes.split("\\|");
		for (int i = 0; i < v.length; i++) {
			String[] v1 = v[i].split("=");
			if (v1[0].equals(type))
				return (int) Double.parseDouble(v1[1]);
		}
		return 0;
	}

	/** 扫表获得的数据 进行偏移 */
	public void SB() {
		setHp(this.hp);
		setMp(this.mp);
		setAp(this.ap);
		setSp(this.sp);
	}

	public int getPetlock() {
		return this.petlock;
	}

	public void setPetlock(int petlock) {
		this.petlock = petlock;
	}

	public int getTrainNum() {
		return this.trainNum;
	}

	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}

	public int getTurnRount() {
		return this.turnRount;
	}

	public void setTurnRount(int turnRount) {
		this.turnRount = turnRount;
	}

	public BigDecimal getSid() {
		return this.sid;
	}

	public void setSid(BigDecimal sid) {
		this.sid = sid;
	}

	public String getSummoningid() {
		return this.summoningid;
	}

	public void setSummoningid(String summoningid) {
		this.summoningid = summoningid;
	}

	public String getSummoningskin() {
		return this.summoningskin;
	}

	public void setSummoningskin(String summoningskin) {
		this.summoningskin = summoningskin;
	}

	public String getStye() {
		return this.stye;
	}

	public void setStye(String stye) {
		this.stye = stye;
	}

	public int getBasishp() {
		return this.basishp;
	}

	public void setBasishp(int basishp) {
		this.basishp = basishp;
	}

	public int getBasismp() {
		return this.basismp;
	}

	public void setBasismp(int basismp) {
		this.basismp = basismp;
	}

	public String getGrowlevel() {
		return this.growlevel;
	}

	public void setGrowlevel(String growlevel) {
		this.growlevel = growlevel;
	}

	public String getResistance() {
		return this.resistance;
	}

	public void setResistance(String resistance) {
		this.resistance = resistance;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getGold() {
		if (this.gold == null || this.gold.equals("")) {
			return "0";
		}
		return this.gold;
	}

	public void setGold(String gold) {
		this.gold = gold;
	}

	public String getWood() {
		if (this.wood == null || this.wood.equals("")) {
			return "0";
		}
		return this.wood;
	}

	public void setWood(String wood) {
		this.wood = wood;
	}

	public String getSoil() {
		if (this.soil == null || this.soil.equals("")) {
			return "0";
		}
		return this.soil;
	}

	public void setSoil(String soil) {
		this.soil = soil;
	}

	public String getWater() {
		if (this.water == null || this.water.equals("")) {
			return "0";
		}
		return this.water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getFire() {
		if (this.fire == null || this.fire.equals("")) {
			return "0";
		}
		return this.fire;
	}

	public void setFire(String fire) {
		this.fire = fire;
	}

	public String getSummoningname() {
		return this.summoningname;
	}

	public void setSummoningname(String summoningname) {
		this.summoningname = summoningname;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public BigDecimal getRoleid() {
		return this.roleid;
	}

	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}

	public Integer getFaithful() {
		return this.faithful;
	}

	public void setFaithful(Integer faithful) {
		this.faithful = faithful;
	}

	public Integer getOpenSeal() {
		return this.openSeal;
	}

	public void setOpenSeal(Integer openSeal) {
		this.openSeal = openSeal;
	}

	public String getInnerGoods() {
		return this.innerGoods;
	}

	public void setInnerGoods(String innerGoods) {
		this.innerGoods = innerGoods;
	}

	public int getDragon() {
		return this.dragon;
	}

	public void setDragon(int dragon) {
		this.dragon = dragon;
	}

	public String getPetSkills() {
		return this.petSkills;
	}

	public void setPetSkills(String petSkills) {
		this.petSkills = petSkills;
	}

	public String getNedanResistance() {
		return this.NedanResistance;
	}

	public void setNedanResistance(String nedanResistance) {
		this.NedanResistance = nedanResistance;
	}

	public int getRevealNum() {
		return this.revealNum;
	}

	public void setRevealNum(int revealNum) {
		this.revealNum = revealNum;
	}

	public int getFlyupNum() {
		return this.flyupNum;
	}

	public void setFlyupNum(int flyupNum) {
		this.flyupNum = flyupNum;
	}

	public String getBeastSkills() {
		return this.beastSkills;
	}

	public void setBeastSkills(String beastSkills) {
		this.beastSkills = beastSkills;
	}

	public String getFourattributes() {
		return this.fourattributes;
	}

	public void setFourattributes(String fourattributes) {
		this.fourattributes = fourattributes;
	}

	public String getSkillData() {
		return this.skillData;
	}

	public void setSkillData(String skillData) {
		this.skillData = skillData;
	}

	public String getZqk() {
		return this.zqk;
	}

	public void setZqk(String zqk) {
		this.zqk = zqk;
	}

	public String getLyk() {
		return this.lyk;
	}

	public void setLyk(String lyk) {
		this.lyk = lyk;
	}

	public int getAlchemynum() {
		return this.alchemynum;
	}

	public void setAlchemynum(int alchemynum) {
		this.alchemynum = alchemynum;
	}

	public Integer getGrowUpDanNum() {
		return this.growUpDanNum;
	}

	public void setGrowUpDanNum(Integer growUpDanNum) {
		this.growUpDanNum = growUpDanNum;
	}

	public String getColorScheme() {
		return this.ColorScheme;
	}

	public void setColorScheme(String colorScheme) {
		this.ColorScheme = colorScheme;
	}

	public int getDraC() {
		return this.draC;
	}

	public void setDraC(int draC) {
		this.draC = draC;
	}

	public int getHp() {
		return (int) JmSum.MZ(this.hp);
		// return hp;
	}

	public void setHp(int hp) {
		this.hp = (int) JmSum.ZM(hp);
		// this.hp = hp;
	}

	public int getMp() {
		return (int) JmSum.MZ(this.mp);
		// return mp;
	}

	public void setMp(int mp) {
		this.mp = (int) JmSum.ZM(mp);
		// this.mp = mp;
	}

	public int getAp() {
		return (int) JmSum.MZ(this.ap);
		// return ap;
	}

	public void setAp(int ap) {
		this.ap = (int) JmSum.ZM(ap);
		// this.ap = ap;
	}

	public int getSp() {
		return (int) JmSum.MZ(this.sp);
		// return sp;
	}

	public void setSp(int sp) {
		this.sp = (int) JmSum.ZM(sp);
		// this.sp = sp;
	}

	public Integer getBone() {
		return (int) JmSum.MZ(this.bone);
		// return bone;
	}

	public void setBone(Integer bone) {
		this.bone = (int) JmSum.ZM(bone);
		// this.bone = bone;
	}

	public Integer getSpir() {
		return (int) JmSum.MZ(this.spir);
		// return spir;
	}

	public void setSpir(Integer spir) {
		this.spir = (int) JmSum.ZM(spir);
		// this.spir = spir;
	}

	public Integer getPower() {
		return (int) JmSum.MZ(this.power);
		// return power;
	}

	public void setPower(Integer power) {
		this.power = (int) JmSum.ZM(power);
		// this.power = power;
	}

	public Integer getSpeed() {
		return (int) JmSum.MZ(this.speed);
		// return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = (int) JmSum.ZM(speed);
		// this.speed = speed;
	}

	public Integer getCalm() {
		if (this.calm == null) {
			setCalm(0);
		}
		return (int) JmSum.MZ(this.calm);
	}

	public void setCalm(Integer calm) {
		this.calm = (int) JmSum.ZM(calm);
	}

	public Integer getGrade() {
		// return (int) JmSum.MZ(grade);
		return this.grade;
	}

	public void setGrade(Integer grade) {
		// this.grade = (int) JmSum.ZM(grade);
		this.grade = grade;
	}

	public BigDecimal getExp() {
		return new BigDecimal(JmSum.MZ(this.exp.longValue()));
		// return exp;
	}

	public void setExp(BigDecimal exp) {
		this.exp = new BigDecimal(JmSum.ZM(exp.longValue()));
		// this.exp = exp;
	}

	public Long getFriendliness() {
		if (this.friendliness == null)
			setFriendliness(0L);
		return JmSum.MZ(this.friendliness);
		// return friendliness;
	}

	public void setFriendliness(Long friendliness) {
		ConcurrentHashMap<Integer, Configure> s = GameServer.getAllConfigure();
		Configure configure = s.get(1);
		if (friendliness > Integer.parseInt(configure.getZhsqmsx()))
			friendliness = Long.parseLong(configure.getZhsqmsx());
		this.friendliness = JmSum.ZM(friendliness);
		// this.friendliness = friendliness;
	}

	/** 获取召唤兽装备的物品id集合 */
	public List<BigDecimal> getGoods() {
		if ((this.innerGoods == null || this.innerGoods.equals("")) && (this.stye == null || this.stye.length() <= 1)) {
			return null;
		}
		List<BigDecimal> goods = new ArrayList<>();
		if (this.innerGoods != null && !this.innerGoods.equals("")) {
			String[] v = this.innerGoods.split("\\|");
			for (int i = 0; i < v.length; i++) {
				if (!v[i].equals("")) {
					goods.add(new BigDecimal(v[i]));
				}
			}
		}
		if (this.stye != null && this.stye.length() > 1) {
			String[] v = this.stye.split("\\|");
			for (int i = 1; i < v.length; i++) {
				String[] vs = v[i].split("-");
				if (vs.length >= 2) {
					goods.add(new BigDecimal(vs[1]));
				}
			}
		}
		return goods;
	}

	@Override
	public RoleSummoning clone() {
		try {
			return (RoleSummoning) super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBasisap() {
		return this.basisap;
	}

	public void setBasisap(String basisap) {
		this.basisap = basisap;
	}

	public String getBasissp() {
		return this.basissp;
	}

	public void setBasissp(String basissp) {
		this.basissp = basissp;
	}

	public String getExtrahp() {
		return this.extrahp;
	}

	public void setExtrahp(String extrahp) {
		this.extrahp = extrahp;
	}

	public String getExtramp() {
		return this.extramp;
	}

	public void setExtramp(String extramp) {
		this.extramp = extramp;
	}

	public String getExtraap() {
		return this.extraap;
	}

	public void setExtraap(String extraap) {
		this.extraap = extraap;
	}

	public String getExtrasp() {
		return this.extrasp;
	}

	public void setExtrasp(String extrasp) {
		this.extrasp = extrasp;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public BigDecimal getUser_id() {
		return this.user_id;
	}

	public void setUser_id(BigDecimal user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getStart() {
		return this.start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return this.end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getPageNow() {
		return this.pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}
