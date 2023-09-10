package come.tool.Role;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.come.bean.LoginResult;
import org.come.bean.PathPoint;
import org.come.entity.RoleSummoning;

public class RoleShow {
	// 所在坐标
	private Long x;
	private Long y;
	// 所在地图
	private Long mapid;
	private List<PathPoint> Player_Paths;
	
	// 角色ID
	private BigDecimal role_id;
    //角色表里的帮派ID
	private BigDecimal gang_id;
	// 帮派名称
	private String gangname;
	// 种类ID
	private BigDecimal species_id;
	// 摆摊ID
	private BigDecimal booth_id;
    //任务id 现在是徽章id
    private Integer skill_id;
    //转生标识字段（0转为0，1转为1以此类推）
	private int TurnAround=0;
	// 等级
	private Integer grade;
	// 角色名字
	private String rolename;
	// 角色称谓
	private String title;	
	//判断是否在战斗中(1、战斗中)
	private Integer fighting;
	// 坐骑ID
	private Integer mount_id;
	
	//队伍ID
	private BigDecimal troop_id;	
	//队伍信息（队长名字|队员一|队员二|.......）
    private String teamInfo;
	//额外皮肤
  	private String skin;
	//飞行器ID
	private Integer fly_id;
	//飞行器皮肤
	private  String flyskin;
	private List<RoleSummoning> showRoleSummoningList;//宠物跟随
	private Boolean divineRune = false;//神行

	public RoleShow() {
		// TODO Auto-generated constructor stub
	}
	public RoleShow(LoginResult loginResult) {
		super();
		if (this.Player_Paths==null) {
			this.Player_Paths=new ArrayList<>();
		}else {
			this.Player_Paths.clear();
		}
		this.x = loginResult.getX();
		this.y = loginResult.getY();
		this.mapid = loginResult.getMapid();
		this.role_id = loginResult.getRole_id();
		this.gang_id = loginResult.getGang_id();
		this.gangname = loginResult.getGangname();
		this.species_id = loginResult.getSpecies_id();
		this.booth_id = loginResult.getBooth_id();
		this.skill_id = loginResult.getSkill_id();
		this.TurnAround = loginResult.getTurnAround();
		this.grade = loginResult.getGrade();
		this.rolename = loginResult.getRolename();
		this.title    = loginResult.getTitle();
		this.fighting = loginResult.getFighting();
		this.mount_id = loginResult.getMount_id();
		this.troop_id = loginResult.getTroop_id();
		this.teamInfo = loginResult.getTeamInfo();
		this.skin = loginResult.getSkin();
		this.fly_id=loginResult.getFly_id();
		this.flyskin=loginResult.getFlyskin();
	}
	public List<PathPoint> getPlayer_Paths() {
		return this.Player_Paths;
	}
	public void setPlayer_Paths(List<PathPoint> player_Paths) {
		this.Player_Paths = player_Paths;
	}
	public BigDecimal getRole_id() {
		return this.role_id;
	}
	public void setRole_id(BigDecimal role_id) {
		this.role_id = role_id;
	}
	public BigDecimal getGang_id() {
		return this.gang_id;
	}
	public void setGang_id(BigDecimal gang_id) {
		this.gang_id = gang_id;
	}
	public String getGangname() {
		return this.gangname;
	}
	public void setGangname(String gangname) {
		this.gangname = gangname;
	}
	public BigDecimal getSpecies_id() {
		return this.species_id;
	}
	public void setSpecies_id(BigDecimal species_id) {
		this.species_id = species_id;
	}
	public BigDecimal getTroop_id() {
		return this.troop_id;
	}
	public void setTroop_id(BigDecimal troop_id) {
		this.troop_id = troop_id;
	}
	public BigDecimal getBooth_id() {
		return this.booth_id;
	}
	public void setBooth_id(BigDecimal booth_id) {
		this.booth_id = booth_id;
	}
	public Integer getSkill_id() {
		return this.skill_id;
	}
	public void setSkill_id(Integer skill_id) {
		this.skill_id = skill_id;
	}
	public int getTurnAround() {
		return this.TurnAround;
	}
	public void setTurnAround(int turnAround) {
		this.TurnAround = turnAround;
	}
	public Integer getGrade() {
		return this.grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getRolename() {
		return this.rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Long getX() {
		return this.x;
	}
	public void setX(Long x) {
		this.x = x;
	}
	public Long getY() {
		return this.y;
	}
	public void setY(Long y) {
		this.y = y;
	}
	public Long getMapid() {
		return this.mapid;
	}
	public void setMapid(Long mapid) {
		this.mapid = mapid;
	}
	public String getTeamInfo() {
		return this.teamInfo;
	}
	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
	}
	public Integer getFighting() {
		return this.fighting;
	}
	public void setFighting(Integer fighting) {
		this.fighting = fighting;
	}
	public String getSkin() {
		return this.skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public Integer getMount_id() {
		return this.mount_id;
	}
	public void setMount_id(Integer mount_id) {
		this.mount_id = mount_id;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public  Integer getFly_id(){return  fly_id;}
	public void setFly_id(Integer fly_id){
  		this.fly_id=fly_id;
	}
	public  String getFlyskin(){return flyskin;}
	public  void setFlyskin(String flyskin){this.flyskin=flyskin;}
	public List<RoleSummoning> getShowRoleSummoningList() {
		return showRoleSummoningList;
	}

	public void setShowRoleSummoningList(List<RoleSummoning> showRoleSummoningList) {
		this.showRoleSummoningList = showRoleSummoningList;
	}
	public Boolean getDivineRune() {
		return divineRune;
	}//神行符
	public void setDivineRune(Boolean divineRune) {
		this.divineRune = divineRune;
	}
}
