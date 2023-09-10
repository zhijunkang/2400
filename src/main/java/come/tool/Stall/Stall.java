package come.tool.Stall;

import java.math.BigDecimal;
import java.util.List;

//实体信息
public class Stall {	
	//记录摆摊id
	private int id;
	//摊位所在的地图id
	private int mapid;
	//记录摊位人
	private String role;
	private BigDecimal roleid;
	//记录摊位名
	private String stall;
	//记录摊位状态
	private int state;
	//记录摊位的物品信息 24
	private Commodity[] goodstables;
	//记录摆摊的召唤兽
	private Commodity[] pets;
	//记录摊位的信息
	private List<String> msg;
	//记录位置
	private int x;
	private int y;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Commodity[] getGoodstables() {
		return this.goodstables;
	}
	public void setGoodstables(Commodity[] goodstables) {
		this.goodstables = goodstables;
	}
	public Commodity[] getPets() {
		return this.pets;
	}
	public void setPets(Commodity[] pets) {
		this.pets = pets;
	}
	public List<String> getMsg() {
		return this.msg;
	}
	public void setMsg(List<String> msg) {
		this.msg = msg;
	}
	public int getMapid() {
		return this.mapid;
	}
	public void setMapid(int mapid) {
		this.mapid = mapid;
	}
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public BigDecimal getRoleid() {
		return this.roleid;
	}
	public void setRoleid(BigDecimal roleid) {
		this.roleid = roleid;
	}
	public String getStall() {
		return this.stall;
	}
	public void setStall(String stall) {
		this.stall = stall;
	}
	public int getState() {
		return this.state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Commodity getGood(BigDecimal rgid){
		for (int i = 0; i < this.goodstables.length; i++) {
			if (this.goodstables[i]!=null) {
				if (this.goodstables[i].getGood().getRgid().compareTo(rgid)==0) {
					return this.goodstables[i];
				}
			}
		}
		return null;
	}
	public Commodity getPet(BigDecimal rgid){
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i]!=null) {
				if (this.pets[i].getPet().getSid().compareTo(rgid)==0) {
					return this.pets[i];
				}
			}
		}
		return null;
	}
	//购买成功处理
	public void Buy(Commodity commodity){
		for (int i = 0; i < this.goodstables.length; i++) {
			if (this.goodstables[i]!=null) {
				if (this.goodstables[i]==commodity) {
					this.goodstables[i]=null;
					return;
				}
			}
		}
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i]!=null) {
				if (this.pets[i]==commodity) {
					this.pets[i]=null;
					return;
				}
			}
		}
	}
}
