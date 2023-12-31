package org.come.task;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

import org.come.model.Lshop;

import come.tool.Good.FYModel;
import come.tool.Good.TSModel;


/**
 * 地图怪物bean
 * @author 叶豪芳
 * @date 2017年12月28日 上午1:31:02
 * 
 */ 
public class MapMonsterBean{
	// 怪物坐标
	private Long map;
	private Integer x;
	private long y;
	// 怪物ID
	private Integer robotid;
	// 怪物名称
	private String robotname;
	// 皮肤
	private String robotskin;
	// 怪物称谓
	private String robottitle;
	//怪物类型 0正常明雷怪   1 地上宝盒   2神秘商铺   3是限时回收   4地煞星魂
	//大闹天宫100-199   
	//101天庭大本营     102-104  天庭箭塔          105天庭集市      
	//111花果山大本营 112-114  花果山箭塔      115花果山集市  
	//120天庭进攻怪     121           花果山进攻怪   
	//130女武神试炼     131           上古传送门      132上古宝箱
	private int robotType;
	// 唯一标识
	private Integer i;
	// 状态标识
	private int type=0;
    private int maxtime;
    private String boosId;
    //刷新的类型 0系统刷新 1放妖刷新  
    private int SX;
    private ConcurrentHashMap<String,Lshop> shops;
    private String shopMsg;
    private long   createTime;
    private MonsterMove   move;//移动模式
    private MonsterMatch  match;//匹配模式
    private MonsterFollow follow;//跟随模式;
    private MonsterHp  hp;//血条模式
    private MonsterExp exp;//经验累加模式
	private TSModel tsModel;//死亡处理
    private FYModel fyModel;//放妖人额外奖励
    private BigDecimal gangId;//强盗模式
    public MapMonsterBean() {
		// TODO Auto-generated constructor stub
	}
	public MapMonsterBean(Long map, Integer i, int robotType,int SX) {
		super();
		this.map = map;
		this.i = i;
		this.robotType = robotType;
		this.SX = SX;
	}
	public int getSX() {
		return this.SX;
	}
	public void setSX(int sX) {
		this.SX = sX;
	}
	public int getMaxtime() {
		return this.maxtime;
	}
	public void setMaxtime(int maxtime) {
		this.maxtime = maxtime;
	}
	public boolean isMaxtime(int JG) {
		this.maxtime-=JG;
		return this.maxtime<=0;
	}
	
	public Long getMap() {
		return this.map;
	}
	public void setMap(Long map) {
		this.map = map;
	}
	public Integer getX() {
		return this.x;
	}
	public void setX(Integer x) {
		if (x!=null&&x<=0) {
			x=1;
		}
		this.x = x;
	}
	public long getY() {
		return this.y;
	}
	public void setY(long l) {
//		if (l != null && l<=0) {
		if (l<=0) {
			l=1;
		}
		this.y = l;
	}
	public String getRobotname() {
		return this.robotname;
	}
	public void setRobotname(String robotname) {
		this.robotname = robotname;
	}
	public String getRobotskin() {
		return this.robotskin;
	}
	public void setRobotskin(String robotskin) {
		this.robotskin = robotskin;
	}
	public Integer getI() {
		return this.i;
	}
	public void setI(Integer i) {
		this.i = i;
	}
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Integer getRobotid() {
		return this.robotid;
	}
	public void setRobotid(Integer robotid) {
		this.robotid = robotid;
	}
	public int getRobotType() {
		return this.robotType;
	}
	public void setRobotType(int robotType) {
		this.robotType = robotType;
	}
	public String getBoosId() {
		return this.boosId;
	}
	public void setBoosId(String boosId) {
		this.boosId = boosId;
	}
	public ConcurrentHashMap<String, Lshop> getShops() {
		return this.shops;
	}
	public void setShops(ConcurrentHashMap<String, Lshop> shops) {
		this.shops = shops;
	}
	public String getShopMsg() {
		return this.shopMsg;
	}
	public void setShopMsg(String shopMsg) {
		this.shopMsg = shopMsg;
	}
	public String getRobottitle() {
		return this.robottitle;
	}
	public void setRobottitle(String robottitle) {
		this.robottitle = robottitle;
	}
	public long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public MonsterMatch getMatch() {
		return this.match;
	}
	public void setMatch(MonsterMatch match) {
		this.match = match;
	}
	public MonsterFollow getFollow() {
		return this.follow;
	}
	public void setFollow(MonsterFollow follow) {
		this.follow = follow;
	}
	public MonsterHp getHp() {
		return this.hp;
	}
	public void setHp(MonsterHp hp) {
		this.hp = hp;
	}
	public MonsterMove getMove() {
		return this.move;
	}
	public void setMove(MonsterMove move) {
		this.move = move;
	}
	public MonsterExp getExp() {
		return this.exp;
	}
	public void setExp(MonsterExp exp) {
		this.exp = exp;
	}
	public TSModel getDieTsModel() {
		if (this.tsModel==null) {return null;}
		synchronized (this) {
			TSModel model=this.tsModel;
			this.tsModel=null;
			return model;
		}
	}
	public void setTsModel(TSModel tsModel) {
		this.tsModel = tsModel;
		if (this.tsModel!=null) {
			this.match=this.tsModel.getMatch();
			this.exp=this.tsModel.getExp();
		}
	}
	
	public FYModel getDieFyModel() {
		if (this.fyModel==null) {return null;}
		synchronized (this) {
			FYModel model=this.fyModel;
			this.fyModel=null;
			return model;
		}
	}
	public void setFyModel(FYModel fyModel) {
		this.fyModel = fyModel;
	}
	public static long PROTECTTIME=180;
	/**判断是否在保护期内*/
	public String isCreateTime(){
		if (this.createTime==0) {return null;}
		long time=PROTECTTIME-((System.currentTimeMillis()-this.createTime)/1000);
		if (time>0) {
			return "剩余"+time+"秒的保护期";
		}
		this.createTime=0;
		return null;
	}
	public BigDecimal getGangId() {
		return this.gangId;
	}
	public void setGangId(BigDecimal gangId) {
		this.gangId = gangId;
	}
}
