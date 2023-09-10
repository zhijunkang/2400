/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package org.come.action.summoning;

import come.tool.Stall.AssetUpdate;
import io.netty.channel.ChannelHandlerContext;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.come.action.IAction;
import org.come.action.monitor.MonitorUtil;
import org.come.bean.LoginResult;
import org.come.bean.NChatBean;
import org.come.bean.SummonGoodsBean;
import org.come.bean.SummonPetBean;
import org.come.entity.Goodstable;
import org.come.entity.RoleSummoning;
import org.come.handler.SendMessage;
import org.come.model.GoodsExchange;
import org.come.model.PetExchange;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.tool.WriteOut;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;
import org.come.entity.Mount;

public class SummonPetAction
implements IAction {
    public static Random random = new Random();
    public static String[] kxs = new String[]{"\u6297\u6df7\u4e71=30", "\u6297\u5c01\u5370=30", "\u6297\u660f\u7761=30", "\u6297\u4e2d\u6bd2=30", "\u7269\u7406\u5438\u6536=30", "\u6297\u98ce=30", "\u6297\u706b=30", "\u6297\u6c34=30", "\u6297\u96f7=30", "\u6297\u9b3c\u706b=30", "\u6297\u9057\u5fd8=30"};

    @Override
    public void action(ChannelHandlerContext ctx, String message) {
        LoginResult loginResult = GameServer.getAllLoginRole().get((Object)ctx);
        if (loginResult == null) {
            return;
        }
        SummonPetBean petBean = (SummonPetBean)GsonUtil.getGsonUtil().getgson().fromJson(message, SummonPetBean.class);
        SummonGoodsBean goodsBean = (SummonGoodsBean)GsonUtil.getGsonUtil().getgson().fromJson(message, SummonGoodsBean.class);
        if (petBean.getOpertype() == 0) {
            this.addPet(petBean, ctx);
        } else if (petBean.getOpertype() == 1) {
            this.jll(petBean, ctx);
        } else if (petBean.getOpertype() == 2) {
            this.exchange(petBean, ctx);
        } else if (goodsBean.getOpertype() == 3) {
            this.goodschange(goodsBean, ctx);
        }
    }

	
	/**
	 * 校验坐骑是否属于当前登录玩家
	 *
	 * @param ctx
	 * @param mountId 坐骑id
	 * @return
	 */
	public static boolean validateMount(ChannelHandlerContext ctx, BigDecimal mountId) {
		LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);
		// 玩家不在线
		if (loginResult == null) {
			return false;
		}
		BigDecimal roleId = loginResult.getRole_id();
		Mount mount=AllServiceUtil.getMountService().selectMountsByMID(mountId);
		if (mount == null) {
			return false;
		}
		return mount.getRoleid().compareTo(roleId) == 0;
	}
	
	/**
	 * 校验宝宝是否属于当前登录玩家
	 *
	 * @param ctx
	 * @param summoningId 召唤兽id
	 * @return
	 */
	public static boolean validateSummoning(ChannelHandlerContext ctx, BigDecimal summoningId) {
		LoginResult loginResult = GameServer.getAllLoginRole().get(ctx);
		// 玩家不在线
		if (loginResult == null) {
			return false;
		}
		BigDecimal roleId = loginResult.getRole_id();
		RoleSummoning roleSummoning = AllServiceUtil.getRoleSummoningService().selectRoleSummoningsByRgID(summoningId);
		if (roleSummoning == null) {
			return false;
		}
		return roleSummoning.getRoleid().compareTo(roleId) == 0;
	}
    
    public void exchange(SummonPetBean petBean, ChannelHandlerContext ctx) {
        RoleSummoning pet;
        LoginResult loginResult = GameServer.getAllLoginRole().get((Object)ctx);
        if (loginResult == null) {
            return;
        }
        PetExchange exchange = GameServer.getPetExchange(petBean.getPetid().intValue());
        RoleSummoning roleSummoning = pet = exchange != null ? GameServer.getPet(exchange.getPid()) : null;
        if (pet == null) {
            SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u9519\u8bef\u5151\u6362\u516c\u5f0f"));
            return;
        }
        ArrayList<Goodstable> list = new ArrayList<Goodstable>();
        long money = 0L;
        String goodName = null;
        String[] v = exchange.getConsume().split("\\|");
        for (int i = 0; i < v.length; ++i) {
            if (v[i].startsWith("D")) {
                money = Long.parseLong(v[i].substring(2));
                if (loginResult.getGold().longValue() >= money) continue;
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u91d1\u94b1\u4e0d\u591f" + money));
                return;
            }
            if (!v[i].startsWith("G")) continue;
            String[] vs = v[i].split("=");
            BigDecimal goodid = new BigDecimal(vs[1]);
            int sum = Integer.parseInt(vs[2]);
            Goodstable goodstable = GameServer.getAllGoodsMap().get(goodid);
            if (goodstable == null) {
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u9519\u8bef\u5151\u6362\u516c\u5f0f"));
                return;
            }
            List<Goodstable> goods = AllServiceUtil.getGoodsTableService().selectGoodsByRoleIDAndGoodsID(loginResult.getRole_id(), goodid);
            int SYsum = sum;
            for (int k = 0; k < goods.size(); ++k) {
                Goodstable good = goods.get(k);
                if (goodName == null) {
                    goodName = good.getGoodsname();
                }
                if (good.getUsetime() >= SYsum) {
                    good.setUsetime(good.getUsetime() - SYsum);
                    SYsum = 0;
                    list.add(good);
                    break;
                }
                SYsum -= good.getUsetime().intValue();
                good.setUsetime(0);
                list.add(good);
            }
            if (SYsum <= 0) continue;
            SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u4e0d\u591f" + sum + "\u4e2a" + goodstable.getGoodsname()));
            return;
        }
        AssetUpdate assetUpdate = new AssetUpdate();
        assetUpdate.setType(AssetUpdate.USEGOOD);
        if (money != 0L) {
            loginResult.setGold(loginResult.getGold().add(new BigDecimal(-money)));
            MonitorUtil.getMoney().useD(money);
        }
        assetUpdate.updata("D=-" + money);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); ++i) {
                Goodstable good = (Goodstable)list.get(i);
                AllServiceUtil.getGoodsTableService().updateGoodRedis(good);
                assetUpdate.updata("G" + good.getRgid() + "=" + good.getUsetime());
            }
        }
        this.initPet(pet);
        pet.setRoleid(loginResult.getRole_id());
        AllServiceUtil.getRoleSummoningService().insertRoleSummoning(pet);
        assetUpdate.setPet(pet);
        assetUpdate.setMsg("\u6210\u529f\u5151\u6362#R" + pet.getSummoningname());
        SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson((Object)assetUpdate)));
        StringBuffer buffer = new StringBuffer();
        buffer.append("#Y\u5929\u7a7a\u4e00\u58f0\u5de8\u54cd,#G");
        buffer.append(loginResult.getRolename());
        buffer.append("#Y\u7ec8\u4e8e\u96c6\u9f50#G");
        buffer.append(goodName);
        buffer.append("#Y,\u83b7\u5f97\u4e00\u53ea#G");
        buffer.append(pet.getSummoningname());
        buffer.append("#Y\u53ec\u5524\u517d,\u8d76\u7d27\u5c06\u6b64\u53ec\u5524\u517d\u6536\u4e8e\u9ebe\u4e0b\uff01#89");
        NChatBean bean = new NChatBean();
        bean.setId(4);
        bean.setMessage(buffer.toString());
        String msg = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson((Object)bean));
        SendMessage.sendMessageToAllRoles(msg);
    }

    public void goodschange(SummonGoodsBean goodsBean, ChannelHandlerContext ctx) {
        Goodstable goodss;
        LoginResult loginResult = GameServer.getAllLoginRole().get((Object)ctx);
        if (loginResult == null) {
            return;
        }
        GoodsExchange exchange = GameServer.getGoodsExchange(goodsBean.getGoodsid().intValue());
        Goodstable goodstable = goodss = exchange != null ? GameServer.getGood(exchange.getGid()) : null;
        if (goodss == null) {
            SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u9519\u8bef\u5151\u6362\u516c\u5f0f"));
            return;
        }
        ArrayList<Goodstable> list = new ArrayList<Goodstable>();
        long money = 0L;
        String goodName = null;
        String[] v = exchange.getConsume().split("\\|");
        for (int i = 0; i < v.length; ++i) {
            if (v[i].startsWith("D")) {
                money = Long.parseLong(v[i].substring(2));
                if (loginResult.getGold().longValue() >= money) continue;
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u91d1\u94b1\u4e0d\u591f" + money));
                return;
            }
            if (!v[i].startsWith("G")) continue;
            String[] vs = v[i].split("=");
            BigDecimal goodid = new BigDecimal(vs[1]);
            int sum = Integer.parseInt(vs[2]);
            Goodstable goodstable2 = GameServer.getAllGoodsMap().get(goodid);
            if (goodstable2 == null) {
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u9519\u8bef\u5151\u6362\u516c\u5f0f"));
                return;
            }
            List<Goodstable> goods = AllServiceUtil.getGoodsTableService().selectGoodsByRoleIDAndGoodsID(loginResult.getRole_id(), goodid);
            int SYsum = sum;
            for (int k = 0; k < goods.size(); ++k) {
                Goodstable good = goods.get(k);
                if (goodName == null) {
                    goodName = good.getGoodsname();
                }
                if (good.getUsetime() >= SYsum) {
                    good.setUsetime(good.getUsetime() - SYsum);
                    SYsum = 0;
                    list.add(good);
                    break;
                }
                SYsum -= good.getUsetime().intValue();
                good.setUsetime(0);
                list.add(good);
            }
            if (SYsum <= 0) continue;
            SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u4e0d\u591f" + sum + "\u4e2a" + goodstable2.getGoodsname()));
            return;
        }
        AssetUpdate assetUpdate = new AssetUpdate();
        assetUpdate.setType(AssetUpdate.USEGOOD);
        if (money != 0L) {
            loginResult.setGold(loginResult.getGold().add(new BigDecimal(-money)));
            MonitorUtil.getMoney().useD(money);
        }
        assetUpdate.updata("D=-" + money);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); ++i) {
                Goodstable good = (Goodstable)list.get(i);
                AllServiceUtil.getGoodsTableService().updateGoodRedis(good);
                assetUpdate.updata("G" + good.getRgid() + "=" + good.getUsetime());
            }
        }
        goodss.setGoodsid(loginResult.getRole_id());
        AllServiceUtil.getGoodsTableService().updateGoodRedis(goodss);
        assetUpdate.setGood(goodss);
        assetUpdate.setMsg("\u6210\u529f\u5151\u6362#R" + goodss.getGoodsname());
        SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson((Object)assetUpdate)));
        StringBuffer buffer = new StringBuffer();
        buffer.append("#Y\u5929\u7a7a\u4e00\u58f0\u5de8\u54cd,#G");
        buffer.append(loginResult.getRolename());
        buffer.append("#Y\u7ec8\u4e8e\u96c6\u9f50#G");
        buffer.append(goodName);
        buffer.append("#Y,\u83b7\u5f97\u4e00\u53ea#G");
        buffer.append(goodss.getGoodsname());
        buffer.append("#Y\u53ec\u5524\u517d,\u8d76\u7d27\u5c06\u6b64\u53ec\u5524\u517d\u6536\u4e8e\u9ebe\u4e0b\uff01#89");
        NChatBean bean = new NChatBean();
        bean.setId(4);
        bean.setMessage(buffer.toString());
        String msg = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson((Object)bean));
        SendMessage.sendMessageToAllRoles(msg);
    }

    public void jll(SummonPetBean petBean, ChannelHandlerContext ctx) {
        LoginResult loginResult = GameServer.getAllLoginRole().get((Object)ctx);
        if (loginResult == null) {
            return;
        }
        RoleSummoning pet = AllServiceUtil.getRoleSummoningService().selectRoleSummoningsByRgID(petBean.getPetid());
        if (pet == null || pet.getTurnRount() != 0) {
            return;
        }
        if (pet.getRoleid().compareTo(loginResult.getRole_id()) != 0) {
            return;
        }
        if (pet.getSsn() != null && !pet.getSsn().equals("0")) {
            return;
        }
        RoleSummoning pet2 = GameServer.getAllPet().get(new BigDecimal(pet.getSummoningid()));
        if (pet2 == null) {
            return;
        }
        Goodstable good = AllServiceUtil.getGoodsTableService().getGoodsByRgID(petBean.getGoodid());
        if (good == null) {
            return;
        }
        if (good.getRole_id().compareTo(loginResult.getRole_id()) != 0) {
            return;
        }
        if (good.getUsetime() <= 0 || good.getType() != 701L) {
            return;
        }
        String msg = null;
        pet.setHp(Integer.parseInt(pet2.getHp()+""));
        pet.setMp(pet2.getMp());
        pet.setAp(pet2.getAp());
        pet.setSp(pet2.getSp());
        if (good.getValue().equals("1")) {
            pet.setGrowlevel(SummonPetAction.getgroup(pet2.getGrowlevel()));
            double vOne = Double.parseDouble(pet.getGrowlevel());
            double vTwo = Double.parseDouble(pet2.getGrowlevel());
            int v1 = (int)(vOne * 1000.0);
            int v2 = (int)(vTwo * 1000.0);
            BigDecimal sx = new BigDecimal((double)(v1 += (int)((double)v2 * 0.05)) / 1000.0);
            sx = sx.setScale(3, 4);
            pet.setGrowlevel(sx.toString());
            msg = sx.doubleValue() > vTwo ? "\u4f60\u7684\u53ec\u5524\u517d\u4f53\u5185\u4e00\u4e1d\u91d1\u5149\u95ea\u73b0" : "\u4f60\u7684\u53ec\u5524\u517d\u53d1\u751f\u4e86\u53d8\u5316";
        } else {
            pet.setGrowlevel(SummonPetAction.getgroup(pet2.getGrowlevel()));
            msg = "\u4f60\u7684\u53ec\u5524\u517d\u53d1\u751f\u4e86\u53d8\u5316";
        }
        pet.setLyk("");
        pet.setGlyk("");
        pet.setGrade(0);
        pet.setTurnRount(0);
        pet.setExp(new BigDecimal(0));
        pet.setBone(0);
        pet.setSpir(0);
        pet.setPower(0);
        pet.setSpeed(0);
        pet.setCalm(0);
        pet.setDragon(0);
        pet.setSpdragon(0);
        pet.setAlchemynum(0);
        pet.setGAlchemynum(0);
        pet.setBasishp(pet.getHp());
        pet.setBasismp(pet.getMp());
        
        good.goodxh(1);
        AllServiceUtil.getGoodsTableService().updateGoodRedis(good);
        AllServiceUtil.getRoleSummoningService().updatePetRedis(pet);
        AssetUpdate assetUpdate = new AssetUpdate(AssetUpdate.USEGOOD);
        assetUpdate.updata("G" + good.getRgid() + "=" + good.getUsetime());
        assetUpdate.setPet(pet);
        assetUpdate.setMsg(msg);
        SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson((Object)assetUpdate)));
    }

    public void addPet(SummonPetBean petBean, ChannelHandlerContext ctx) {
        LoginResult loginResult = GameServer.getAllLoginRole().get((Object)ctx);
        if (loginResult == null) {
            return;
        }
        if (petBean.getPetid().longValue() < 200000L || petBean.getPetid().longValue() > 200091L) {
            WriteOut.addtxt(loginResult.getRole_id() + ":\u975e\u6cd5\u6dfb\u52a0\u53ec\u5524\u517d:" + petBean.getPetid(), 9999L);
            return;
        }
        RoleSummoning pet = GameServer.getPet(petBean.getPetid());
        this.initPet(pet);
        pet.setRoleid(loginResult.getRole_id());
        AllServiceUtil.getRoleSummoningService().insertRoleSummoning(pet);
        AssetUpdate assetUpdate = new AssetUpdate();
        assetUpdate.setType(AssetUpdate.USERGOOD);
        assetUpdate.setPet(pet);
        SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson((Object)assetUpdate)));
    }

    public void initPet(RoleSummoning pet) {
        pet.setBasishp(pet.getHp());
        pet.setBasismp(pet.getMp());
        pet.setFaithful(100);
        pet.setGrade(0);
        pet.setTurnRount(0);
        pet.setBone(0);
        pet.setSpir(0);
        pet.setPower(0);
        pet.setSpeed(0);
        pet.setCalm(0);
        pet.setDragon(0);
        pet.setSpdragon(0);
        pet.setAlchemynum(0);
        pet.setGAlchemynum(0);
        pet.setExp(new BigDecimal(0));
        pet.setOpenSeal(1);
        pet.setOpenql(0);
        if(pet.getQuality().equals("1")) {
        	Long c = new Date().getTime();
    		c=c+Long.parseLong((Integer.parseInt(pet.getSurplusTimes())*60)+"000");
    		String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(c);
            res = simpleDateFormat.format(date);
            pet.setSurplusTimes(res);
        }
        String yb = pet.getResistance();
        if (yb == null || yb.equals("")) {
            int p = random.nextInt(kxs.length);
            int p2 = random.nextInt(kxs.length);
            while (p2 == p) {
                p2 = random.nextInt(kxs.length);
            }
            pet.setResistance(kxs[p] + "|" + kxs[p2]);
        }
    }

    public static int getchu(int v) {
        int f = (v >> 2) + 1;
        if (f <= 0) {
            return v;
        }
        return v - random.nextInt(f);
    }

    public static String getgroup(String group) {
        try {
            double v = Double.parseDouble(group);
            int v2 = (int)(v * 1000.0);
            BigDecimal sx = new BigDecimal((double)SummonPetAction.getchu(v2) / 1000.0);
            sx = sx.setScale(3, 4);
            return sx.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return group;
        }
    }
}

