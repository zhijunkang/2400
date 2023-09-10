package come.tool.newGang;

import io.netty.channel.ChannelHandlerContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.come.bean.NChatBean;
import org.come.bean.PathPoint;
import org.come.entity.Gang;
import org.come.handler.SendMessage;
import org.come.model.Boos;
import org.come.model.Robots;
import org.come.model.Sghostpoint;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.task.MapMonsterBean;
import org.come.task.MonsterMoveBase;
import org.come.task.MonsterUtil;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

import come.tool.Battle.RewardLimit;
import come.tool.FightingData.Battlefield;

public class GangDomain {
	
	private Object object;
	private Gang gang;
	private GangGroup gangGroup;
	private ConcurrentHashMap<BigDecimal,ChannelHandlerContext> roleMap;
	
	/**帮派强盗使用数据*/
	private int banditsSum;//今日胜利次数
	private int banditsValue;//失败免一轮刷新
	private int banditsTime;//剩余击杀时间
	private List<MapMonsterBean> banditsList;//帮派强盗
	
	private boolean isUp;
	public GangDomain(Gang gang) {
		// TODO Auto-generated constructor stub
		this.object=new Object();
		this.gang=gang;
		this.gangGroup=new GangGroup(gang);
		this.roleMap=new ConcurrentHashMap<>();
		this.isUp=false;
	}
	/**获取帮派强盗数据*/
	public Map<Integer, MonsterMoveBase> getBandits(StringBuffer buffer,Map<Integer, MonsterMoveBase> moveMap){
		synchronized (this) {
			if (this.banditsList==null||this.banditsList.size()==0) {return moveMap;}
			for (int i = 0; i < this.banditsList.size(); i++) {
				MapMonsterBean bean=this.banditsList.get(0);
				if (i==0) {
					if (buffer.length()!=0) {buffer.append("|");} 
			    	buffer.append(bean.getRobotid());
			        buffer.append("#");
			        buffer.append(bean.getRobotname());
			        if (bean.getRobottitle()!=null&&!bean.getRobottitle().equals("")) {
		        	    buffer.append("$");
		         	    buffer.append(bean.getRobottitle());
		            }
			        buffer.append("#");
			        buffer.append(bean.getRobotskin());
			        buffer.append("#");
			        buffer.append(bean.getRobotType()); 
				}
	    		if (bean.getMove()!=null) {
					if (moveMap==null) {moveMap=new HashMap<>();}
					moveMap.put(bean.getMove().getBh(), bean.getMove().getMoveBase());
				}
	    		MonsterUtil.monsterBuffer1(bean, buffer);
			}
			return moveMap;
		}
	}
	/**开启帮派强盗 */
    public boolean banditsOpen(Boos boos,Robots robot,int size,Sghostpoint sghostpoint){
    	synchronized (this) {
    		if (this.banditsValue>0) {this.banditsValue--;return false;}
    		if (this.roleMap.size()<5) {return false;}
    		if ((this.banditsList==null||this.banditsList.size()==0)&&Battlefield.isV(boos.getBoosgpk()-this.banditsSum*2)) {//上一轮未刷新 或者胜利参与刷新
    			this.banditsTime=30;
    			if (this.banditsList==null) {this.banditsList=new ArrayList<>();}
        		int max=sghostpoint.getPoints().length;
        		int robotId=Integer.parseInt(robot.getRobotid());
        		long mapId=GameServer.getMapIds(boos.getBoosmapname());
        		StringBuffer buffer=new StringBuffer();
    	        buffer.append(robot.getRobotid());
    	        buffer.append("#");
    	        buffer.append(robot.getRobotname());
    	        buffer.append("#");
    	        buffer.append(robot.getRobotskin());
    	        buffer.append("#");
    	        buffer.append(0); 
    	        int maxtime=boos.getBoosetime();
    	        //id#名称#皮肤#唯一标识-x-y-状态可有可无
    		    for (int i = 0; i < size; i++) {
    		    	// 每个坐标对应的怪物的bean
    				MapMonsterBean mapMonsterBean = new MapMonsterBean();
    				mapMonsterBean.setI(MonsterUtil.getIncreasesum());
    				//切割坐标获得X,Y//坐标
    				PathPoint point = sghostpoint.getPoints()[MonsterUtil.random.nextInt(max)];
    				mapMonsterBean.setX(point.getX()+MonsterUtil.getPY());
    				mapMonsterBean.setY(point.getY()+MonsterUtil.getPY());	
    				mapMonsterBean.setRobotid(robotId);
    				mapMonsterBean.setRobotname(robot.getRobotname());
    				mapMonsterBean.setRobotskin(robot.getRobotskin());	
    				mapMonsterBean.setRobotType(0);
    				mapMonsterBean.setMap(mapId);
    				mapMonsterBean.setMaxtime(robot.getRobottime());
    				mapMonsterBean.setGangId(this.gang.getGangid());
    				mapMonsterBean.setTsModel(robot.getTsModel());
    				this.banditsList.add(mapMonsterBean);
    				MonsterUtil.allMonster.put(mapMonsterBean.getI(), mapMonsterBean);	
    				MonsterUtil.monsterBuffer1(mapMonsterBean, buffer);
    			    if (i==0) {mapMonsterBean.setBoosId(RewardLimit.isBoosDrop(boos));}
    			}
    			SendMessage.sendMessageToGangMap(this.gang.getGangid(),mapId, Agreement.getAgreement().MonsterRefreshAgreement(buffer.toString()));
    			return true;
    		}
        	return false;	
    	}
	}
	/**帮派强盗结束-1处理玩家击杀成功 0上次未刷新 1上次刷新完成成功 2上次完成失败*/
	public void banditsEnd(MapMonsterBean bean){
		synchronized (this) {
			if (this.banditsList==null) {return;}//如果闯入对象是空的表示判断超时
			if (bean!=null) {
				if (this.banditsList!=null) {
					synchronized (this.banditsList) {
						this.banditsList.remove(bean);
						if (this.banditsList.remove(bean)) {
							int size=this.banditsList.size();
							if (size==0) {
								banditsDraw(true);
							}else if (size<=5||size%8==7) {//小于5只或者剩余数量和8余7 提示剩余数量
								banditsSendMsg();
							}
						}
						
					}	
				}
				return;
			}
			if (this.banditsList.size()!=0) {
				this.banditsTime-=5;
				if (this.banditsTime>0) {//提示剩余数量
					banditsSendMsg();
				}else {//失败
					banditsDraw(false);	
				}
			}
		}
	}
	/**提示帮派强盗数量*/
	public void banditsSendMsg(){
		NChatBean chatBean=new NChatBean();
		chatBean.setId(2);
		chatBean.setMessage("剩余帮派强盗数量:#R"+this.banditsList.size());
		String msg = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson(chatBean));
		SendMessage.sendMessageToGangRoles(this.gang.getGangid(), msg);
	}
	/**帮派强盗奖励 ture 胜利  false 失败*/
	public void banditsDraw(boolean isV){
		if (isV) {
			this.banditsSum++;
			long add=15000;
			addBG(add);//奖励二万帮贡
			NChatBean chatBean=new NChatBean();
			chatBean.setId(2);
			chatBean.setMessage("众人齐心协力共同抗敌,极力清除帮中强盗通过变卖强盗遗留物品为帮派资金增加#R "+add);
			String msg = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson(chatBean));
			SendMessage.sendMessageToGangRoles(this.gang.getGangid(), msg);
		}else {
			//一只扣一千
			this.banditsValue=3;
			long add=this.banditsList.size()*1000;
			if (add>this.gang.getBuilder().longValue()) {add=this.gang.getBuilder().longValue();}
			addBG(-add);
			NChatBean chatBean=new NChatBean();
			chatBean.setId(2);
			chatBean.setMessage("强盗在帮中横行霸道,导致帮派资金被抢走了#R "+add+" #W,希望下次大家齐心协力共同抗敌，与强盗势不两立#23");
			String msg = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson(chatBean));
			SendMessage.sendMessageToGangRoles(this.gang.getGangid(), msg);
			//清空野怪
			long mapId=0;
			StringBuffer buffer=new StringBuffer("M");
			for (int i = 0; i < this.banditsList.size(); i++) {
				MapMonsterBean bean=this.banditsList.get(0);
				MonsterUtil.removeMonster2(bean);
				if (mapId==0) {mapId=bean.getMap();}
				if (buffer.length()>1) {buffer.append("#");}
				buffer.append(bean.getI());
				buffer.append("^2");
			}
			this.banditsList=null;
			if (mapId!=0) {
				SendMessage.sendMessageToGangMap(this.gang.getGangid(),mapId, Agreement.getAgreement().battleStateAgreement(buffer.toString()));
			}
		}
	}
	/**获取对话框*/
	public String getMsg(int type){
		if (type==2022) {//科技
			return this.gangGroup.getKJNpc();
		}else if (type==2023) {//驯养
			return this.gangGroup.getXYNpc();
		}
		return null;
	}
	/**添加帮贡*/
	public void addBG(long add){
		synchronized (this.object) {
			this.gang.setBuilder(new BigDecimal(this.gang.getBuilder().longValue()+add));
			this.isUp=true;
		}
	}
	/**消耗驯养次数*/
	public boolean useXY(){
		synchronized (this.object) {
			int num=this.gangGroup.getXyNum();
			if (num>0) {
				this.gangGroup.setXyNum(num-1);
				this.isUp=true;
				return true;
			}
			return false;
		}
	}
	/**恢复驯养次数*/
	public void upXY(){
		synchronized (this.object) {
			if (this.gangGroup.addXY(1)) {
				this.isUp=true;
			}
		}
	}
	/**提升等级*/
	public String upLvl(int type){
		synchronized (this.object) {
			//47://升级帮派等级 48://升级科技等级 49://升级驯养师等级
		    int lvl=0;
		    int xh=0;
		    String name = null;
		    if (type == 47) {
				lvl = this.gang.getGanggrade().intValue();
				xh = (int) (Math.pow(2, lvl) * 5000);
				name = "帮派等级";
			} else if (type == 48) {
				lvl = this.gangGroup.getKj();
				xh = (int) (Math.pow(2, lvl) * 2000);
				name = "科技等级";
			} else if (type == 49) {
				lvl = this.gangGroup.getXy();
				xh = (int) (Math.pow(2, lvl) * 2000);
				name = "驯养师等级";
			}	
			if (lvl >= 5) {
				return "等级上限5级";
			} else if (type != 47 && lvl >= this.gang.getGanggrade().intValue()) {
				return "不能超过帮派等级";
			}
			if (this.gang.getBuilder().longValue() < xh) {
				return "你的帮派资金不足#G" + xh;
			}
			this.gang.setBuilder(new BigDecimal(this.gang.getBuilder().longValue()-xh));
			if (type == 47) {
				this.gang.setGanggrade(this.gang.getGanggrade().add(new BigDecimal(1)));
			}else if (type == 48) {
				this.gangGroup.setKj(this.gangGroup.getKj()+1);
			}else if (type == 49) {
				this.gangGroup.setXy(this.gangGroup.getXy()+1);
			}
			this.isUp=true;
			return name+"升级成功";
		}
	}
	/**加入一个成员*/
	public void addGangRole(){
		synchronized (this.object) {
			this.gang.setGangnumber(this.gang.getGangnumber().add(new BigDecimal(1)));
			this.isUp=true;
		}
	}
	/**退出一个成员*/
    public void removeGangRole(){
        synchronized (this.object) {
        	this.gang.setGangnumber(this.gang.getGangnumber().subtract(new BigDecimal(1)));
        	this.isUp=true;
		}
	}
    /**更换帮主*/
    public void upGangMaster(String roleName){
    	synchronized (this.object) {
    		this.gang.setGangbelong(roleName);
    		this.isUp=true;
    	}
    }
    public void upGang(){
    	synchronized (this.object) {
    		if (this.isUp) {
    			this.gang.setGangTxt(this.gangGroup.getTxt());
    			AllServiceUtil.getGangService().updateGang(this.gang);
    			this.isUp=false;
			}
    	}
    }
	/**一个成员上线*/
    public void upGangRole(BigDecimal roleId,ChannelHandlerContext ctx){
    	this.roleMap.put(roleId,ctx);
    }
	/**一个成员下线*/
    public void downGangRole(BigDecimal roleId){
    	this.roleMap.remove(roleId);
    }
	public Gang getGang() {
		return this.gang;
	}
	public GangGroup getGangGroup() {
		return this.gangGroup;
	}
	public ConcurrentHashMap<BigDecimal, ChannelHandlerContext> getRoleMap() {
		return this.roleMap;
	}
}
