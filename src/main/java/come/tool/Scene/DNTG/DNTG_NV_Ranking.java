package come.tool.Scene.DNTG;

import java.util.ArrayList;
import java.util.List;

public class DNTG_NV_Ranking {

	private int camp;
	// 总次数
	private int size;
	// 记录前5
	private List<DNTGRole> roles;
	private int min;// 最低分
	private String rankingSting;// 排行榜描述

	public DNTG_NV_Ranking(int camp) {
		super();
		this.camp = camp;
		this.roles=new ArrayList<>();
	}
	// 积分更改
	public synchronized boolean upRanking(DNTGRole role) {

		role.setNVNum(role.getNVNum() + 1);
		this.size++;
		if (this.min >= role.getNVNum()) {
			return false;
		}
		this.roles.remove(role);
		boolean is = true;
		boolean is2 = false;
		for (int i = 0; i < this.roles.size(); i++) {
			DNTGRole dntgRole = this.roles.get(i);
			if (dntgRole.getNVNum() < role.getNVNum()) {
				is = false;
				this.roles.add(i, role);
				is2 = true;
				break;
			}
		}
		if (is) {
			if (this.roles.size() < 5) {
				this.roles.add(role);
				is2 = true;
			}
		} else if (this.roles.size() > 5) {
			for (int i = this.roles.size() - 1; i >= 5; i--) {
				this.roles.remove(i);
				is2 = true;
			}
		}
		if (is2) {
			// 修改最低分
			this.min = this.roles.get(this.roles.size() - 1).getNVNum();
			// 刷新排行榜数据
			StringBuffer buffer = new StringBuffer();
			buffer.append("N");
			buffer.append(this.camp);
			for (int i = 0; i < this.roles.size(); i++) {
				DNTGRole dntgRole = this.roles.get(i);
				if (i != 0) {
					buffer.append("&");
				}
				buffer.append(dntgRole.getRoleName());
				buffer.append("$");
				buffer.append(dntgRole.getNVNum());
			}
			this.rankingSting = buffer.toString();
		}
		return is2;
	}

	/**获取名次*/
	public int getPlace(DNTGRole role){
		return this.roles.indexOf(role)+1;
	}
	/**获取榜首*/
	public DNTGRole getOne(){
		if (this.roles.size()!=0) {
		    return this.roles.get(0);
		}
		return null;
	}
	public int getCamp() {
		return this.camp;
	}

	public void setCamp(int camp) {
		this.camp = camp;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<DNTGRole> getRoles() {
		return this.roles;
	}

	public void setRoles(List<DNTGRole> roles) {
		this.roles = roles;
	}

	public int getMin() {
		return this.min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public String getRankingSting() {
		return this.rankingSting;
	}

	public void setRankingSting(String rankingSting) {
		this.rankingSting = rankingSting;
	}

}
