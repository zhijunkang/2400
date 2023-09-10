package come.tool.Scene.LTS;

import java.util.List;

import org.come.bean.LoginResult;
import org.come.entity.Baby;
import org.come.entity.Fly;
import org.come.entity.Goodstable;
import org.come.entity.Lingbao;
import org.come.entity.Mount;
import org.come.entity.RoleSummoning;
import org.come.entity.UserTable;

public class UserData {

	private UserTable userTable;
	private LoginResult loginResult;
	private List<Goodstable> goodstables;
	private List<RoleSummoning> pets;
	private List<Mount> mounts;
	private List<Lingbao> lingbaos;
	private List<Baby> babys;
	private List<Fly>flys;
	private int I;//区标识
	public UserData(UserTable userTable, LoginResult loginResult,
					List<Goodstable> goodstables, List<RoleSummoning> pets,
					List<Mount> mounts, List<Lingbao> lingbaos, List<Baby> babys, List<Fly> flys) {
		super();
		this.userTable = userTable;
		this.loginResult = loginResult;
		this.goodstables = goodstables;
		this.pets = pets;
		this.mounts = mounts;
		this.lingbaos = lingbaos;
		this.babys = babys;
		this.flys=flys;
	}

	public UserTable getUserTable() {
		return this.userTable;
	}
	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}
	public LoginResult getLoginResult() {
		return this.loginResult;
	}
	public void setLoginResult(LoginResult loginResult) {
		this.loginResult = loginResult;
	}
	public List<Goodstable> getGoodstables() {
		return this.goodstables;
	}
	public void setGoodstables(List<Goodstable> goodstables) {
		this.goodstables = goodstables;
	}
	public List<RoleSummoning> getPets() {
		return this.pets;
	}
	public void setPets(List<RoleSummoning> pets) {
		this.pets = pets;
	}
	public List<Mount> getMounts() {
		return this.mounts;
	}
	public void setMounts(List<Mount> mounts) {
		this.mounts = mounts;
	}
	public List<Lingbao> getLingbaos() {
		return this.lingbaos;
	}
	public void setLingbaos(List<Lingbao> lingbaos) {
		this.lingbaos = lingbaos;
	}
	public List<Baby> getBabys() {
		return this.babys;
	}
	public void setBabys(List<Baby> babys) {
		this.babys = babys;
	}
	public int getI() {
		return this.I;
	}
	public void setI(int i) {
		this.I = i;
	}
	public List<Fly>getFlys(){
		return flys;
	}

	public void setFlys(List<Fly> flys) {
		this.flys = flys;
	}
}
