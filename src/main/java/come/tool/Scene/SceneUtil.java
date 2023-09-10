package come.tool.Scene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.crypto.Cipher;

import org.come.bean.LoginResult;
import org.come.model.Configure;
import org.come.server.GameServer;
import org.come.task.MonsterMoveBase;
import org.come.tool.ReadExelTool;
import org.come.until.ReadTxtUtil;

import come.tool.Scene.BTY.BTYScene;
import come.tool.Scene.BWZ.BWZScene;
import come.tool.Scene.DNTG.DNTGScene;
import come.tool.Scene.LTS.LTSScene;
import come.tool.Scene.PKLS.PKLSScene;
import come.tool.Scene.RC.RCScene;
import come.tool.Scene.SLDH.SLDHScene;
import come.tool.Scene.TGDB.TGDBScene;
import come.tool.Scene.ZZS.ZZSScene;

import sun.misc.BASE64Decoder;

public class SceneUtil {
	//蟠桃园
	public static final int BTYID=1001;
	//天宫夺宝
	public static final int TGDBID=1002;
	//种族赛*人
	public static final int ZZSID_0=1003;
	//种族赛*魔
	public static final int ZZSID_1=1004;
	//种族赛*仙
	public static final int ZZSID_2=1005;
	//种族赛*鬼
	public static final int ZZSID_3=1006;
	
	//种族赛*龙
	public static final int ZZSID_4=10061;
		
	//长安保卫战
	public static final int BWZID=1007;
	//擂台赛
	public static final int LTSID=1008;
	//日常开启副本
	public static final int RCID=1009;
	//跨服联赛
	public static final int PKLSID=1010;
	//大闹天宫
	public static final int DNTGID=1011;
	//水陆大会
	public static final int SLDHID=1012;
	
	private static ConcurrentHashMap<Integer,Scene> sceneMap;
	

	
	public static void init(){
		sceneMap = new ConcurrentHashMap();
		sceneMap.put(1009, new RCScene());
		sceneMap.put(1010, new PKLSScene());
		sceneMap.put(1012, new SLDHScene());
		
	}
	
	//TODO 调整活动开启时间
	
	/**判断是否有活动开启*/
	public static void activityOpen(String week,int day,int hour,int minute,int second){
		ConcurrentHashMap<Integer, Configure> s = GameServer.getAllConfigure();
		Configure configure = s.get(1);
		String SLDHSJ = configure.getSldhsjsz();
//		String SLDHSJ = "all";

		if (week.equals(SLDHSJ) || SLDHSJ.equals("all") || SLDHSJ.contains(week)) {//周2晚上19：30  水陆大会
			if (hour==19&&minute==30) {
				Scene scene=sceneMap.get(SLDHID);
				if (scene==null) {
					scene=new SLDHScene();
					sceneMap.put(SLDHID, scene);	
				}
				if (!scene.isEnd()) {
					SLDHScene sldhScene=(SLDHScene) scene;
					sldhScene.open();
				}
			}
		}
		if (week.equals("Monday")) {//周1，晚20：00，天宫寻宝
			if (minute==0) {
				if (hour==20) {
					sceneMap.put(TGDBID, new TGDBScene());			
				}else if (hour==22) {
					sceneMap.remove(TGDBID);
				}
			}
		}else  if (week.equals("Wednesday")) {//周3晚上8：00  种族比武
			if (minute==30) {
				if (hour==19) {
					Scene scene=sceneMap.get(ZZSID_0);
					if (scene==null) {
						sceneMap.put(ZZSID_0, new ZZSScene(0));	
					}
					Scene scene1=sceneMap.get(ZZSID_1);
					if (scene1==null) {
						sceneMap.put(ZZSID_1, new ZZSScene(1));	
					}
					Scene scene2=sceneMap.get(ZZSID_2);
					if (scene2==null) {
						sceneMap.put(ZZSID_2, new ZZSScene(2));	
					}
					Scene scene3=sceneMap.get(ZZSID_3);
					if (scene3==null) {
						sceneMap.put(ZZSID_3, new ZZSScene(3));	
					}
					Scene scene4=sceneMap.get(ZZSID_4);
					if (scene4==null) {
						sceneMap.put(ZZSID_4, new ZZSScene(9));	
					}
				}else if (hour==23) {
					sceneMap.remove(ZZSID_0);
					sceneMap.remove(ZZSID_1);
					sceneMap.remove(ZZSID_2);
					sceneMap.remove(ZZSID_3);
					sceneMap.remove(ZZSID_4);
				}
			}
		}else if (week.equals("Thursday")) {//周4晚上20：00  大闹天宫
			if (hour==19&&minute==30) {
				Scene scene=sceneMap.get(DNTGID);
				if (scene==null||!scene.isEnd()) {
					sceneMap.put(DNTGID, new DNTGScene());	
				}
			}
		}else if (week.equals("Friday")) {//周五晚上蟠桃园
			// 长安保卫战 
			if (hour==20 && minute == 0) {
				Scene scene=sceneMap.get(BTYID);
				if (scene==null||!scene.isEnd()) {
					sceneMap.put(BTYID, new BTYScene());
				}
			}
			
			if (hour==22 && minute == 25) {
				Scene scene=sceneMap.get(BTYID);
				if (scene==null||!scene.isEnd()) {
				    sceneMap.put(BTYID, new BTYScene());
				}
			}
		}else if (week.equals("Saturday")) {//周六
			// 长安保卫战  
			if (hour==12 && minute == 0) {
				Scene scene=sceneMap.get(BWZID);
				if (scene==null||!scene.isEnd()) {
				    sceneMap.put(BWZID, new BWZScene());
				}
			}
			if (hour==15 && minute == 0) {
				Scene scene=sceneMap.get(BWZID);
				if (scene==null||!scene.isEnd()) {
				    sceneMap.put(BWZID, new BWZScene());
				}
				
			}
			if (hour==18 && minute == 0) {
				Scene scene=sceneMap.get(BWZID);
				if (scene==null||!scene.isEnd()) {
				    sceneMap.put(BWZID, new BWZScene());
				}
			}
			
			if (hour==21 && minute == 0) {
				Scene scene=sceneMap.get(BWZID);
				if (scene==null||!scene.isEnd()) {
				    sceneMap.put(BWZID, new BWZScene());
				}
			}
			
			
		} else if (week.equals("Sunday")) {//周日，中午13：30-15:30点，守护蟠桃园，  16:00-18：00，长安保卫战。  20：00  种族比武
			if (hour==19&&minute==30) {
				// 擂台
				Scene scene2=sceneMap.get(SLDHID);
				if (scene2==null) {
					scene2=new SLDHScene();
					sceneMap.put(SLDHID, scene2);	
				}
				if (!scene2.isEnd()) {
					SLDHScene sldhScene=(SLDHScene) scene2;
					sldhScene.open();
				}
			}
			
		}
		if (minute==0) {
			if (hour==0) {
				sceneMap.remove(BTYID);
				sceneMap.remove(BWZID);
				if (week.equals("Tuesday")) {
					Scene scene=sceneMap.remove(DNTGID);
					if (scene!=null) {
						DNTGScene dntgScene=(DNTGScene) scene;
						dntgScene.removeMonsterBean();
					}
				}
			}else if (hour==5) {
				Scene scene=sceneMap.get(RCID);
				if (scene!=null) {
					RCScene rcScene=(RCScene) scene;
					rcScene.clean();
				}
			}
		}
	}
	/**额外开启活动*/
	public static void additionalScene(int Id){
		Scene scene=sceneMap.get(Id);
		if (scene==null||!scene.isEnd()) {
			if (Id==BTYID) {
				sceneMap.put(BTYID, new BTYScene());
			}else if (Id==TGDBID) {
				sceneMap.put(TGDBID, new TGDBScene());
			}else if (Id==BWZID) {
				sceneMap.put(BWZID, new BWZScene());
			}else if (Id==LTSID) {
				sceneMap.put(LTSID, new LTSScene());
			}
		}
	}
	/***/
	public static Scene getScene(int id){
		return sceneMap.get(id);		
	}
	/**获取玩家所在种族赛*/
	public static ZZSScene getZZS(LoginResult loginResult){
		for (int i = 0; i < 5; i++) {
			Scene scene=null;
			if (i==0) {scene=getScene(ZZSID_0);}
			else if (i==1){scene=getScene(ZZSID_1);}
			else if (i==2){scene=getScene(ZZSID_2);}
			else if (i==3){scene=getScene(ZZSID_3);}
			else if (i==4){scene=getScene(ZZSID_4);}
			if (scene!=null) {
				ZZSScene zzsScene=(ZZSScene) scene;
				if (zzsScene.getRole(loginResult)!=null) {
					return zzsScene;
				}
			}
		}
		Scene scene=null;
		if (loginResult.getRace_id().intValue()==10001) {scene=getScene(ZZSID_0);}
		else if (loginResult.getRace_id().intValue()==10002){scene=getScene(ZZSID_1);}
		else if (loginResult.getRace_id().intValue()==10003){scene=getScene(ZZSID_2);}
		else if (loginResult.getRace_id().intValue()==10004){scene=getScene(ZZSID_3);}
		else if (loginResult.getRace_id().intValue()==10005){scene=getScene(ZZSID_4);}
		
		if (scene==null) {return null;}
		return (ZZSScene) scene;
	}
	public static Map<Integer, MonsterMoveBase> getMapMonster(StringBuffer buffer,Map<Integer, MonsterMoveBase> moveMap, long mapId) {
		// TODO Auto-generated method stub
		if (mapId==BTYScene.mapId) {
			Scene scene=sceneMap.get(BTYID);
			if (scene!=null) {return scene.getMapMonster(buffer,moveMap,mapId);}
		}else if (mapId==BWZScene.mapId) {
			Scene scene=sceneMap.get(BWZID);
			if (scene!=null) {return scene.getMapMonster(buffer,moveMap,mapId);}
		}else if (mapId==DNTGScene.mapIdZ||mapId==DNTGScene.mapIdF) {
			Scene scene=sceneMap.get(DNTGID);
			if (scene!=null) {return scene.getMapMonster(buffer,moveMap,mapId);}
		}
		return moveMap;
	}
	public static void ZZSBattleEnd(String m1,String m2,int type){
		for (int i = 0; i < 5; i++) {
			Scene scene=null;
			if (i==0) {scene=getScene(ZZSID_0);}
			else if (i==1){scene=getScene(ZZSID_1);}
			else if (i==2){scene=getScene(ZZSID_2);}
			else if (i==3){scene=getScene(ZZSID_3);}
			else if (i==4){scene=getScene(ZZSID_4);}
			if (scene!=null) {
				ZZSScene zzsScene=(ZZSScene) scene;
				zzsScene.BattleEnd(m1,m2,type);
			}
		}
	}
	/**判断是否需要获取副本信息*/
	public static boolean isSceneMsg(long oldMapId,long mapId){
		if (oldMapId!=mapId) {
			if (mapId==DNTGScene.mapIdZ||mapId==DNTGScene.mapIdF||oldMapId==DNTGScene.mapIdZ||oldMapId==DNTGScene.mapIdF) {
				return true;
			}		
		}
		return false;
	}
	/**获取副本信息*/
	public static String getSceneMsg(LoginResult loginResult,long oldMapId,long mapId){
		if (oldMapId==mapId) {
			return null;
		}
		if (mapId==DNTGScene.mapIdZ||mapId==DNTGScene.mapIdF||oldMapId==DNTGScene.mapIdZ||oldMapId==DNTGScene.mapIdF) {
			if (mapId!=DNTGScene.mapIdZ&&mapId!=DNTGScene.mapIdF) {
				return DNTGID+"";
			}else {
				Scene scene=sceneMap.get(DNTGID);
				if (scene!=null) {
					return scene.getSceneMsg(loginResult,oldMapId,mapId);
				}
			}
		}
		return null;
	}
}
