package come.tool.BangBattle;

/**
 * 建筑
 * @author Administrator
 *
 */
public class Build {
    //空闲
	public static int IDLE=0;
    //充能
	public static int ENERGY=1;
	//被殴打
	public static int BEATEN=2;
    //攻击
	public static int ATTACK=3;
    //门
	public static int TOWER_DOOR=0;
    //火
	public static int TOWER_FIRE=1;
    //冰
	public static int TOWER_ICE=2;
	//龙门
	public static int TOWER_LONG=3;	 
	
	//箭塔
	public static int  DNTG_JT=4; 
	//生产
	public static int  DNTG_CY=5;	 
	//大本营
	public static int DNTG_DBY=6; 
				
	
	//编号
	private int bh;
	//塔剩余体力值
    private int hp;
    private int maxhp;
	//塔类型
    private int type;
    //状态
	private int state;
	//时间
	private long time;
	//操作人
	private String RoleName;
	
	//判断操作到时间
	public boolean istime(){
		this.time++;
		if (this.type==TOWER_LONG) {
			if (this.time>=30){
				this.time=0;
				this.state=IDLE;
				return true;
			}
		}else {
			if (this.time>=10){
				this.time=0;
				this.state=IDLE;
				return true;
			}
		}
		return false;
	}
	//初始化
	public Build(int type,int bh) {
		// TODO Auto-generated constructor stub
		this.bh=bh;
		if (type==TOWER_DOOR)this.hp=6000;
		else this.hp=600;
		
		this.maxhp=this.hp;
		this.type=type;	
		
	}
	public Build(int type,int bh,int hp) {
		// TODO Auto-generated constructor stub
		this.bh=bh;
		this.type=type;	
		this.hp=hp;
		this.maxhp=hp;
	}
	public int getBh() {
		return this.bh;
	}
	public void setBh(int bh) {
		this.bh = bh;
	}
	public int getHp() {
		return this.hp;
	}
	public boolean setHp(int hp) {
		if (hp>this.maxhp) {
			this.hp=this.maxhp;
		    return false;
		}
//		int v=getSurvival();
		if (hp<=0) {
		  this.hp=0;	
		}else {
		  this.hp = hp;	
		}
		return true;
//		if (type==TOWER_DOOR) {
//			return true;
//		}
//		return !(v==getSurvival());
	}
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return this.state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public long getTime() {
		return this.time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getRoleName() {
		if (this.RoleName==null)this.RoleName="";
		return this.RoleName;
	}
	public void setRoleName(String roleName) {
		this.RoleName = roleName;
	}
	public String getName() {
		switch (this.type) {
		case 0:
			return "城门";
		case 1:
			return "火塔";
		case 2:
			return "冰塔";
		case 3:
			return "龙神大炮";	
		default:
			break;
		}
		return "";
	}
	//获取的生存情况
	public int getSurvival(){
		if (this.type==0) {
			if (this.hp>3000)return 0;
			else if (this.hp>0) return 1;
			else return 2;
		}else {
			if (this.hp>300)return 0;
			else if (this.hp>0) return 1;
			else return 2;
		}
	}
}
