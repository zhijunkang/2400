package come.tool.Scene.DNTG;

import org.come.model.Robots;
import org.come.server.GameServer;
import org.come.task.MapMonsterBean;
import org.come.task.MonsterHp;
import org.come.task.MonsterUtil;

import come.tool.Scene.SceneUtil;

public class DNTG_NV_Monster {

	private MapMonsterBean bean;
	//积分排行
	private DNTG_NV_Ranking TTRanking;//天宫排行榜
	private DNTG_NV_Ranking HGSRanking;//花果山排行榜
	
	public DNTG_NV_Monster() {
		// TODO Auto-generated constructor stub
		Robots robots=GameServer.getAllRobot().get("917");
		this.bean =new MapMonsterBean(DNTGScene.mapIdZ,MonsterUtil.getIncreasesum(),130,SceneUtil.DNTGID);
		this.bean.setRobotname(robots.getRobotname());this.bean.setRobotid(917);this.bean.setRobotskin(robots.getRobotskin());
		this.bean.setX(5380);this.bean.setY(1380);
		this.bean.setHp(new MonsterHp(1000,true));
		MonsterUtil.addEMonster(this.bean);
		this.TTRanking=new DNTG_NV_Ranking(0);
		this.HGSRanking=new DNTG_NV_Ranking(1);	
	}
	/**获取女武神试炼数据*/
	public void toString(DNTGRole dntgRole,StringBuffer buffer){
//		N2(玩家自身数据)击杀次数$名次|N0/1(阵营排行榜)名称$击杀次数&名称$击杀次数
		buffer.append("|N2");
		buffer.append(dntgRole.getNVNum());
		buffer.append("$");
		if (dntgRole.getCamp()==0) {
			buffer.append(this.TTRanking.getPlace(dntgRole));
		}else {
			buffer.append(this.HGSRanking.getPlace(dntgRole));
		}
		if (this.TTRanking.getRankingSting()!=null) {
			buffer.append("|");
			buffer.append(this.TTRanking.getRankingSting());
		}
		if (this.HGSRanking.getRankingSting()!=null) {
			buffer.append("|");
			buffer.append(this.HGSRanking.getRankingSting());
		}
	}
	/**获取获胜方*/
	public int end(){
		if (this.TTRanking.getSize()>this.HGSRanking.getSize()) {
			return 0;
		}else if (this.HGSRanking.getSize()>this.TTRanking.getSize()) {
			return 1;
		}
		return -1;
	} 
	public MapMonsterBean getBean() {
		return this.bean;
	}
	public void setBean(MapMonsterBean bean) {
		this.bean = bean;
	}
	public DNTG_NV_Ranking getHGSRanking() {
		return this.HGSRanking;
	}
	public void setHGSRanking(DNTG_NV_Ranking hGSRanking) {
		this.HGSRanking = hGSRanking;
	}
	public DNTG_NV_Ranking getTTRanking() {
		return this.TTRanking;
	}
	public void setTTRanking(DNTG_NV_Ranking tTRanking) {
		this.TTRanking = tTRanking;
	}
}
