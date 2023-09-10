package org.come.readUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.come.readBean.AllMeridians;
import org.come.action.lottery.Draw;
import org.come.bean.Bbuy;
import org.come.bean.NpcShopBean;
import org.come.bean.RobotsBean;
import org.come.bean.RoleTxBean;
import org.come.entity.Fly;
import org.come.entity.Goodstable;
import org.come.entity.Keju;
import org.come.entity.Lingbao;
import org.come.entity.Mount;
import org.come.entity.Present;
import org.come.entity.RoleSummoning;
import org.come.entity.StarPalace;
import org.come.entity.Suit;
import org.come.entity.WingTraining;
import org.come.model.Achieve;
import org.come.model.Alchemy;
import org.come.model.Boos;
import org.come.model.ColorScheme;
import org.come.model.Configure;
import org.come.model.Decorate;
import org.come.model.Door;
import org.come.model.Dorp;
import org.come.model.Eshop;
import org.come.model.EventModel;
import org.come.model.GMshopItem;
import org.come.model.Gamemap;
import org.come.model.Gem;
import org.come.model.GodStone;
import org.come.model.GoodsExchange;
import org.come.model.Lshop;
import org.come.model.Monster;
import org.come.model.Newequip;
import org.come.model.Npctable;
import org.come.model.PalData;
import org.come.model.PalEquip;
import org.come.model.PetExchange;
import org.come.model.QianDao;
import org.come.model.Robots;
import org.come.model.Sghostpoint;
import org.come.model.Shop;
import org.come.model.Skill;
import org.come.model.Talent;
import org.come.model.TaskData;
import org.come.model.TaskSet;
import org.come.model.Title;
import org.come.model.Xianqi;
import org.come.model.aCard;
import org.come.model.ItemExchange;
import org.come.readBean.*;
import org.come.server.GameServer;
import org.come.task.MonsterUtil;
import org.come.task.RefreshMonsterTask;
import org.come.tool.NewAESUtil;
import org.come.until.CreateTextUtil;
import org.come.until.GsonUtil;

/*   4:    */ import come.tool.Scene.DNTG.DNTGAward;

import come.tool.BangBattle.BangFight;

import come.tool.Scene.DNTG.DNTGAward;

public class ReadPoolUtil {

	public static boolean readTypeTwo(StringBuffer buffer,int type){
//		if(!GameServer.mcCode.equals(GameServer.getProperty())) {
//			return false;
//		}
//		System.out.println("更新编号："+type);
		if (type==0) {//0召唤兽表
			System.out.println("正在读取：pet.xls");
			ConcurrentHashMap<BigDecimal, RoleSummoning> map=ReadPetUtil.allPetId("pet", buffer);
			if (map!=null) {GameServer.setAllPet(map);}
			System.out.println("正在读取：item.xls");
			ConcurrentHashMap<BigDecimal, Goodstable> map1=ReadItemUtil.allitemId("item", buffer);
			if (map1!=null) {GameServer.setAllitem(map1);}
			return map!=null&&map1!=null;
		}else if (type==1) {//1召唤兽装备
			System.out.println("正在读取：palEquip.xls");
			ConcurrentHashMap<Long, PalEquip> map=ReadPetUtil.allPalEquip("palEquip", buffer);
			if (map!=null) {GameServer.setAllPalEquip(map);}
			return map!=null;
		}else if (type==2) {//2召唤兽兑换
			System.out.println("正在读取：petExchange.xls");
			ConcurrentHashMap<Integer, PetExchange> map=ReadPetUtil.allPetExchangeMap("petExchange", buffer);
			if (map!=null) {
				GameServer.setAllPetExchange(map);
			    String msg=ReadPetUtil.createTxtPetExchange(map);//生成txt
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\petExchange.txt", msg);
			}
			return map!=null;
		}else if (type==3) {//3地图
			System.out.println("正在读取：map.xls");
			ConcurrentHashMap<String, Gamemap> map=ReadMapUtil.selectAllMap("map", buffer);
			if (map!=null) {
				GameServer.setGameMap(map);
			    String msg=ReadMapUtil.createTxtMap(map);//生成txt
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\map.txt", msg);
			}
			return map!=null;
		}else if (type==4) {//4Npc
			System.out.println("正在读取：npc.xls");
			ConcurrentHashMap<String,Npctable> map=ReadMapUtil.selectallNpc("npc", buffer);
			if (map!=null) {
				GameServer.setNpcMap(map);
			    String msg=ReadMapUtil.createTxtNpc(map);//生成txt
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\npc.txt", msg);
			}
			return map!=null;
		}else if (type==5) {//5传送表
			System.out.println("正在读取：door.xls");
			ConcurrentHashMap<Integer,Door> map=ReadMapUtil.selectDoors("door", buffer);
			if (map!=null) {
				GameServer.setDoorMap(map);
				String msg=ReadMapUtil.createTxtDoor(map);//生成txt
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\door.txt", msg);
			}
			return map!=null;
		}else if (type==6) {//TaskSet//TaskData
			System.out.println("正在读取：taskSet.xls");
			ConcurrentHashMap<Integer, TaskSet>  allTaskSet =ReadTaskSetUtil.selectTaskSet("taskSet",buffer);
			if (allTaskSet==null) {return false;}
			GameServer.setAllTaskSet(allTaskSet);
			System.out.println("正在读取：taskData.xls");
			ConcurrentHashMap<Integer, TaskData> allTaskData=ReadTaskSetUtil.selectTaskData("taskData",buffer);
			if (allTaskData==null) {return false;}
			GameServer.setAllTaskData(allTaskData);
			AllTask allTask=new AllTask();
			allTask.setAllTaskData(allTaskData);
			allTask.setAllTaskSet(allTaskSet);
			String msg = GsonUtil.getGsonUtil().getgson().toJson(allTask);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\task.txt", msg);
			return true;
		}else if (type==7) {//7伙伴数据
			System.out.println("正在读取：palData.xls");
			ConcurrentHashMap<Integer, PalData> allPalData=ReadPalDataUtil.selectPalData("palData",buffer);
			if (allPalData==null) {return false;}
			GameServer.setAllPalData(allPalData);
			AllPal allPal=new AllPal();
			allPal.setAllPalData(allPalData);
			String msg = GsonUtil.getGsonUtil().getgson().toJson(allPal);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\pal.txt", msg);
			return true;
		}else if (type==8) {//8Boos表
			System.out.println("正在读取：boos.xls");
			List<Boos> map=ReadBoosUtil.selectBoos("boos", buffer);
			if (map==null) {return false;}
			MonsterUtil.setBooses(map);
			GameServer.boosesMap=ReadBoosUtil.boosesMap(map);
			return true;
		}else if (type==9) {//9monster表
			System.out.println("正在读取：monster.xls");
			ConcurrentHashMap<String, Monster> map=ReadBoosUtil.getMonster("monster", buffer);
			if (map!=null) {GameServer.setMonsterMap(map);}
			return map!=null;
		}else if (type==10) {//10robot表
			System.out.println("正在读取：robots.xls");
			ConcurrentHashMap<String, Robots> map=ReadBoosUtil.getRobot("robots", buffer);
			if (map==null) {return false;}
			GameServer.setAllRobot(map);
			RobotsBean robotsBean = new RobotsBean();
			Map<String, Robots> getShop=new HashMap<>();
			for (Robots robots:map.values()) {
				getShop.put(robots.getRobotid(), robots);
			}
			robotsBean.setRobotsMap(getShop);
			String msg = GsonUtil.getGsonUtil().getgson().toJson(robotsBean);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\robots.txt", msg);
			return true;
		}else if (type==11) {//11item表
			System.out.println("正在读取：item.xls");
			ConcurrentHashMap<BigDecimal, Goodstable> map=ReadGoodsUtil.getAllGoodsMap("item", buffer);
			if (map!=null) {
				GameServer.setAllGoodsMap(map);
				String msg=ReadGoodsUtil.createGoods(map);
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\goods.txt", msg);
			}
			return map!=null;
		}else if (type==12) {//装备升级
			System.out.println("正在读取：newequip.xls");
			ConcurrentHashMap<String, List<Newequip>> map = ReadNewequipUtil.getAllNewequip("newequip", buffer);
			if (map!=null) {GameServer.setSameNewequipMap(map);}
			return map!=null;
		}else if (type==13) {//洗练信息
			System.out.println("正在读取：alchemy.xls");
			ConcurrentHashMap<String, List<Alchemy>> map = ReadNewequipUtil.getAllAlchemy("alchemy", buffer);
			if (map!=null) {GameServer.setAllAlchemy(map);}
			return map!=null;
		}else if (type==14) {//重铸信息
			System.out.println("正在读取：decorate.xls");
			ConcurrentHashMap<String, List<Decorate>> map = ReadNewequipUtil.getAllDecorate("decorate", buffer);
			if (map!=null) {GameServer.setAllDecorate(map);}
			return map!=null;
		}else if (type==15) {//神兵石信息
			System.out.println("正在读取：godstone.xls");
			ConcurrentHashMap<String, List<GodStone>> map = ReadNewequipUtil.selectGodStones("godstone", buffer);
			if (map!=null) {GameServer.setGodMap(map);}
			return map!=null;
		}else if (type==16) {//伙伴装备信息
			System.out.println("正在读取：palEquip.xls");
			ConcurrentHashMap<Long, PalEquip> map = ReadPalDataUtil.selectPalEquip("palEquip", buffer);
			if (map!=null) {GameServer.setAllPalEquip(map);}
			return map!=null;
		}else if (type==17) {//npc商店
			System.out.println("正在读取：shop.xls");
			RefreshMonsterTask.upBuyCount(-1, false);
			ConcurrentHashMap<String, Shop> map=ReadShopUtil.getAllShop("shop", buffer);
			if (map==null) {return false;}
			GameServer.setAllShopGoods(map);
			Map<String, List<Shop>> allShopList=ReadShopUtil.getShop(map);
			NpcShopBean bean=new NpcShopBean();
			bean.setNpcShopMap(allShopList);
			String msg = GsonUtil.getGsonUtil().getgson().toJson(bean);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\npcshop.txt", msg);
			return true;
		}else if (type==18) {//商城
			System.out.println("正在读取：eshop.xls");
			RefreshMonsterTask.upBuyCount(-1, false);
			ConcurrentHashMap<String, Eshop> map=ReadShopUtil.getAllEshopGoods("eshop", buffer);
			if (map==null) {return false;}
			GameServer.setAllEshopGoods(map);
			String msg =ReadShopUtil.getEShop(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\eshop.txt", msg);
			return true;
		}else if (type==19) {//限购商城
			System.out.println("正在读取：lShop.xls");
			RefreshMonsterTask.upBuyCount(-1, false);
			ConcurrentHashMap<String, Lshop> map=ReadShopUtil.selectLShops("lShop", buffer);
			if (map==null) {return false;}
			GameServer.setAllLShopGoods(map);
			return true;
		}else if (type==20) {//刷怪表
			System.out.println("正在读取：sghostpoint.xls");
			ConcurrentHashMap<String, List<Sghostpoint>> map=ReadSghostpointUtil.getMonsterTask("sghostpoint", buffer);
			if (map==null) {return false;}
			GameServer.setMonsterpointMap(map);
			return true;
		}else if (type==21) {//仙器
			System.out.println("正在读取：xianqi.xls");
			ConcurrentHashMap<String, List<Xianqi>> map=ReadXianqiUtil.getAllXianqi("xianqi", buffer);
			if (map==null) {return false;}
			GameServer.setGetAllXianqi(map);
			GameServer.setXianqiTypeValue(ReadXianqiUtil.getXianqiType(map));
			return true;
		}else if (type==22) {//灵宝
			System.out.println("正在读取：lingbao.xls");
			ConcurrentHashMap<String, Lingbao> map=ReadLingbaoUtil.getAllLingbao("lingbao", buffer);
			if (map==null) {return false;}
			GameServer.setAllLingbao(map);
			return true;
		}else if (type==23) {//灵宝符石
			System.out.println("正在读取：lingbaofushi.xls");
			ConcurrentHashMap<BigDecimal, Goodstable> map=ReadLingbaoUtil.getAllLingbaoFushi("lingbaofushi", buffer);
			if (map==null) {return false;}
			GameServer.setAllLingbaoFushi(map);
			return true;
		}else if (type==24) {//宝石表
			System.out.println("正在读取：gem.xls");
			ConcurrentHashMap<String, Gem> map=ReadGemUtil.selectGem("gem", buffer);
			if (map==null) {return false;}
			GameServer.setGems(map);
			return true;
		}else if (type==25) {//技能表
			System.out.println("正在读取：skill.xls");
			ConcurrentHashMap<String, Skill> map=ReadSkillUtil.getSkill("skill", buffer);
			if (map==null) {return false;}
			GameServer.setGetSkill(map);
			String msg =ReadSkillUtil.createSkill(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\skill.txt", msg);
			return true;
		}else if (type==26) {//dorp表
			System.out.println("正在读取：drop.xls");
			ConcurrentHashMap<String, Dorp> map=ReadDorpUtil.allDorpInfoByID("drop", buffer);
			if (map==null) {return false;}
			GameServer.setAllDorp(map);
			// 刷新帮战的掉落// 2053 胜利方秒数奖励// 2054 胜利方300秒后奖励// 2055 失败方秒数奖励// 2056 失败方300秒后奖励
			Dorp dorp = map.get("2053");
			if (dorp != null) {BangFight.SLEXP = dorp.getDorpValue();}
			dorp = map.get("2054");
			if (dorp != null) {BangFight.SLJL = dorp.getDorpValue();}
			dorp = map.get("2055");
			if (dorp != null) {BangFight.SBEXP = dorp.getDorpValue();}
			dorp = map.get("2056");
			if (dorp != null) {BangFight.SBJL = dorp.getDorpValue();}
			return true;
		}else if (type==27) {//大闹奖励表
			System.out.println("正在读取：dntg.xls");
			ConcurrentHashMap<Integer, DNTGAward> map=ReadDorpUtil.selectDNTGAwards("dntg", buffer);
			if (map==null) {return false;}
			GameServer.setAllDntg(map);
			return true;
		}else if (type==28) {//回收表
			System.out.println("正在读取：bbuy.xls");
			ConcurrentHashMap<Integer, Bbuy> map=ReadBbuyUtil.selecBbuys("bbuy", buffer);
			if (map==null) {return false;}
			GameServer.setAllBbuys(map);
			String msg =ReadBbuyUtil.createBbuy(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\bbuy.txt", msg);
			return true;
		}else if (type==29) {//套装表
			System.out.println("正在读取：suit.xls");
			ConcurrentHashMap<Integer, Suit> map=ReadSuitUtil.selecSuits("suit", buffer);
			if (map==null) {return false;}
			GameServer.setAllSuits(map);
			String msg =ReadSuitUtil.createSkill(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\suit.txt", msg);
			return true;
		}else if (type==30) {//特效
			System.out.println("正在读取：tx.xls");
			ConcurrentHashMap<Integer, RoleTxBean> map=ReadTxUtil.selectDecoration("tx", buffer);
			if (map==null) {return false;}
			GameServer.setAllTXs(map);
			String msg =ReadTxUtil.createTX(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\tx.txt", msg);
			return true;
		}else if (type==31) {//创建角色赠送
			System.out.println("正在读取：present.xls");
			List<Present> map=ReadPresentUtil.selectPresents("present", buffer);
			if (map==null) {return false;}
			GameServer.setPresents(map);
			return true;
		}else if (type==32) {//经验表
			System.out.println("正在读取：exp.xls");
			ConcurrentHashMap<Integer, Long> map=ReadExpUtil.getExp("exp", buffer);
			if (map==null) {return false;}
			GameServer.setExpMap(map);
			String msg =ReadExpUtil.createExp(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\exp.txt", msg);
			return true;
		}else if (type==33) {//坐骑表
			System.out.println("正在读取：mount.xls");
			ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Mount>> map=ReadMountUtil.getAllMount("mount", buffer);
			if (map==null) {return false;}
			GameServer.setAllMount(map);
			return true;
		}else if (type==34) {//颜色表
			System.out.println("正在读取：color.xls");
			ConcurrentHashMap<String, ColorScheme> map=ReadColorUtil.selectcolors("color", buffer);
			if (map==null) {return false;}
			GameServer.setAllColor(map);
			String msg =ReadColorUtil.createcolor(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\color.txt", msg);
			return true;
		}else if (type==35) {//天资表
			System.out.println("正在读取：child.xls");
			ConcurrentHashMap<Integer, Talent> map=ReadTalentsUtil.selectTalents("child", buffer);
			if (map==null) {return false;}
			GameServer.setAlltalent(map);
			String msg =ReadTalentsUtil.createTalent(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\talent.txt", msg);
			return true;
		}else if (type==36) {//奖池
			System.out.println("正在读取：draw.xls");
			ConcurrentHashMap<Integer, Draw> map=ReadDrawUtil.selectDraw("draw", buffer);
			if (map==null) {return false;}
			GameServer.setAllDraws(map);
			return true;
		}else if (type==37) {//变身卡
			System.out.println("正在读取：acard.xls");
			ConcurrentHashMap<Integer, aCard> map=ReadACardUtil.selectACards("acard", buffer);
			if (map==null) {return false;}
			GameServer.setAllACard(map);
			String msg =ReadACardUtil.createACards(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\acard.txt", msg);
			return true;
		}else if (type==38) {//称谓表
			System.out.println("正在读取：title.xls");
			List<Title> map=ReadTitleUtil.selectTitles("title", buffer);
			if (map==null) {return false;}
			String msg =ReadTitleUtil.createTitle(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\title.txt", msg);
			GameServer.setAlltitle(ReadTitleUtil.getTitle2(map));
			return true;
		}else if (type==39) {//任务活动表
			System.out.println("正在读取：event.xls");
			ConcurrentHashMap<Integer, EventModel> map=ReadEventUtil.selectEvents("event", buffer);
			if (map==null) {return false;}
			GameServer.setAllevent(map);
			String msg =ReadEventUtil.createEvent(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\event.txt", msg);
			return true;
		}else if (type==40) {//翅膀表
			System.out.println("正在读取：wingTraining.xls");
			ConcurrentHashMap<Long, WingTraining> map=ReadWingTrainingUtil.selectWingTraining("wingTraining", buffer);
			if (map==null) {return false;}
			GameServer.setAllWingTraining(map);
			return true;
		}else if (type==41) {//星阵
			System.out.println("正在读取：starPalace.xls");
			ConcurrentHashMap<String, StarPalace> map=ReadStarPalaceUtil.selectStarPalace("starPalace", buffer);
			if (map==null) {return false;}
			GameServer.setAllStarPalace(map);
			String[] allKey = new String[map.size()];
			allKey = map.keySet().toArray(allKey);
			String[] allStarPalaceKey = new String[map.size() - 9];
			int v = 0;
			List<String> list = new ArrayList<>();
			list.add("朱雀");
			list.add("青龙");
			list.add("白虎");
			list.add("玄武");
			list.add("金牛");
			list.add("苍狼");
			list.add("赤马");
			list.add("黄鹤");
			list.add("火猿");
			System.out.println(allStarPalaceKey.length+":"+list.size()+":"+allKey.length);
			for (int i = 1; i < allStarPalaceKey.length; i++) {
				v++;
				if (list.contains(allKey[v])) {
					i--;
					continue; 
				}
				
				allStarPalaceKey[i] = allKey[v];
				
			}
			GameServer.setAllStarPalaceKey(allStarPalaceKey);
			return true;
		}else if (type==42) {//天演策
			System.out.println("正在读取：tyc.xls");
			Map<String, String> map=ReadTYCUtil.selectDecoration("tyc", buffer);
			if (map==null) {return false;}
			String msg =ReadTYCUtil.createTX(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\tyc.txt", msg);
			return true;
		}else if (type==43) {//孩子结局
			System.out.println("正在读取：babyresult.xls");
			List<BabyResult> map=ReadBabyResultUtil.selectBabyResult("babyresult", buffer);
			if (map==null) {return false;}
			String msg =ReadBabyResultUtil.creatbabyresult(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\babyresult.txt", msg);
			return true;
		}else if (type==44) {//新手引导
			System.out.println("正在读取：guide.xls");
			Map<Integer, RookieGuideBean> map=ReadGuideUtil.selectSkills("guide", buffer);
			if (map==null) {return false;}
			String msg =ReadGuideUtil.createSkill(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\guide.txt", msg);
			return true;
		}
		else if (type==45) {//活跃表
			System.out.println("正在读取：active.xls");
			AllActive allActive=ReadActiveUtil.selectActives("active", buffer);
			if (allActive==null) {return false;}
			GameServer.setAllActive(allActive);
			String msg =GsonUtil.getGsonUtil().getgson().toJson(allActive);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\active.txt", msg);
			return true;
		}else if (type==46) {//成就表
			System.out.println("正在读取：achieve.xls");
			AllAchieve allAchieve=ReadAchieveUtil.selectAchieves("achieve", buffer);
			if (allAchieve==null) {return false;}
			ConcurrentHashMap<Integer, Achieve> map=new ConcurrentHashMap<>();
			for (int i = 0; i < allAchieve.getAchieves().size(); i++) {
				map.put(allAchieve.getAchieves().get(i).getId(), allAchieve.getAchieves().get(i));
			}
			GameServer.setAllAchieve(map);
			String msg =GsonUtil.getGsonUtil().getgson().toJson(allAchieve);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\achieve.txt", msg);
			return true;
		}else if (type==47) {
			System.out.println("正在读取：lh.xls");
			ConcurrentHashMap<String, List<String>> goodsByRobot = ReadBoosUtil.getRobotByGoods(GameServer.getAllRobot());
			ReadBoosUtil.setDrop(goodsByRobot,GameServer.getDorp("2051").getDorpValue(),"藏宝图");
			ReadBoosUtil.setDrop(goodsByRobot,GameServer.getDorp("2052").getDorpValue(),"高级藏宝图");
			ReadBoosUtil.setDrop(goodsByRobot,GameServer.getDorp("1007").getDorpValue(),"超级藏宝图");
			ReadBoosUtil.setDrop(goodsByRobot,GameServer.getDorp("10001").getDorpValue(),"元气蛋孵化");
			ReadTaskSetUtil.getTaskDrop(goodsByRobot);
			GameServer.setGoodsByRobot(goodsByRobot);
			AllLianHua all = ReadLianHuaUtil.selectLianHuas("lh", buffer);// .se("lh", buffer);
			if (all == null) {
				return false;
			}
			GameServer.setAllLianHua(all);
			String msg = GsonUtil.getGsonUtil().getgson().toJson(all);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "") + "GetTXT\\lh.txt",
					msg);
			return true;

		} else if (type == 48) {
			System.out.println("正在读取：meridians.xls");
			// 经脉
			AllMeridians list = ReadMeridiansUtil.selectMeridians("meridians", buffer);// .se("lh", buffer);
			if (list == null) {
				return false;
			}
			GameServer.setAllMeridians(list);//(list);
			String msg = GsonUtil.getGsonUtil().getgson().toJson(list);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "") + "GetTXT\\meridians.txt", msg);
			//签到
			System.out.println("正在读取：qiandao.xls");
			ConcurrentHashMap<Integer,QianDao> qianDaoConcurrentHashMap= ReadQianDaoUtil.selectQianDao("qiandao", buffer);
			if(qianDaoConcurrentHashMap!=null) {
				GameServer.setQianDaoMap(qianDaoConcurrentHashMap);
				String msgs = ReadQianDaoUtil.createQianDao(qianDaoConcurrentHashMap);
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\qiandao.txt", msgs);
			}else {
				System.out.println("kongo=======================================");
				System.exit(0);
			}
			System.out.println("正在读取：itemExchange.xls");
			ConcurrentHashMap<Integer, ItemExchange> map = ReadItemUtil.allPetExchangeMap("itemExchange", buffer);
			if (map != null) {
				GameServer.setAllItemExchange(map);
				String msga = ReadItemUtil.createTxtPetExchange(map);
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "") + "GetTXT\\itemExchange.txt", msga);
			}
//			return map!=null;
			 return true;
		  }


		  if (type == 49) {
			  System.out.println("正在读取：goodsExchange.xls");
		     ConcurrentHashMap<Integer, GoodsExchange> map = ReadGoodsUtil.allGoodsExchangeMap("goodsExchange", buffer);
		     if (map != null) {
		        GameServer.setAllGoodsExchange(map);
		        String msg = ReadGoodsUtil.createTxtGoodsExchange(map);
		        text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "") + "GetTXT\\goodsExchange.txt", msg);
			 } 
	       
		    return true;

		
		
		 } else if (type==50) {//48装备兑换
			System.out.println("正在读取：itemExchange.xls");
			ConcurrentHashMap<Integer, ItemExchange> map = ReadItemUtil.allPetExchangeMap("itemExchange", buffer);
			if (map != null) {
				GameServer.setAllItemExchange(map);
				String msg = ReadItemUtil.createTxtPetExchange(map);
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "") + "GetTXT\\itemExchange.txt", msg);
			}
			//加载配置
			System.out.println("正在读取：configure.xls");
			ConcurrentHashMap<Integer, Configure> maps=ReadConfigureUtil.selectConfigure("configure", buffer);
			if (maps==null) {return false;}
			System.err.println("加载配置493:"+maps.get(1).getLywsx());
			GameServer.setAllConfigure(maps);
			String msgs =ReadConfigureUtil.createConfigure(maps);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\configure.txt", msgs);
			
			return map!=null;
		} else if (type==51) {
			System.out.println("正在读取：GMshopItem.xls");
			ConcurrentHashMap<Integer,GMshopItem> gMshopItemConcurrentHashMap= ReadGMshopItemUtil.selectGMshopItem("GMshopItem", buffer);
			if(gMshopItemConcurrentHashMap!=null) {
				GameServer.setGMshopItemMap(gMshopItemConcurrentHashMap);
				String msg = ReadGMshopItemUtil.createGMshopItem(gMshopItemConcurrentHashMap);
				text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\GMshopItem.txt", msg);
			}
			return true;
		} else if (type==51) {
			ConcurrentHashMap<Integer,GMshopItem> gMshopItemConcurrentHashMap= ReadGMshopItemUtil.selectGMshopItem("GMshopItem", buffer);
			GameServer.setGMshopItemMap(gMshopItemConcurrentHashMap);
			String msg = ReadGMshopItemUtil.createGMshopItem(gMshopItemConcurrentHashMap);
			System.out.println("更新txt内容："+msg);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\GMshopItem.txt", msg);
			return true;
		} else if (type==52) {//配置文件
			System.out.println("正在读取：configure.xls");
			ConcurrentHashMap<Integer, Configure> map=ReadConfigureUtil.selectConfigure("configure", buffer);
			if (map==null) {return false;}
			GameServer.setAllConfigure(map);
			String msg =ReadConfigureUtil.createConfigure(map);
			text(GameServer.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+ "GetTXT\\configure.txt", msg);
			return true;
		}else if(type==53){//飞行器表
			System.out.println("正在读取：fly.xls");
			ConcurrentHashMap<Integer,ConcurrentHashMap<Integer, Fly>> map = ReadFlyUtil.getAllFly("fly",buffer);
			if (map==null){return false;}
			GameServer.setAllFly(map);
             return true;
		}
		else if (type==54){//科举
			System.out.println("正在读取：keju.xls");
			ConcurrentHashMap<Integer,ConcurrentHashMap<Integer, Keju>> map = ReadKejuUtil.getAllKeju("keju",buffer);
			if (map==null){
				return false;
			}
			GameServer.setAllKeju(map);
			return true;
		}
		return false;
	}
	
  
	public static void text(String path,String msg){
		/** 三端加密修改  zrikka 2020-0408 */
		try {
			String vvvStr = NewAESUtil.AESJDKEncode(msg);
			vvvStr=vvvStr.substring(0, vvvStr.length()-1);
			byte[] vvv = vvvStr.getBytes();
			CreateTextUtil.createFile(path, vvv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/** 2.5加密(旧的)  **/
//		try {
//			byte[] vvv = MessageGZIP.compressToByte(msg);
//			vvv = NewAESUtil.Encode.doFinal(vvv);
//			if (vvv.length > 10) {
//				byte a = vvv[vvv.length - 4];
//				vvv[vvv.length - 4] = vvv[4];
//				vvv[4] = a;
//			}
//			CreateTextUtil.createFile(path, vvv);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
