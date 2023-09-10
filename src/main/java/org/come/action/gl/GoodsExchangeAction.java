/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package org.come.action.gl;

import come.tool.Stall.AssetUpdate;
import io.netty.channel.ChannelHandlerContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.come.action.IAction;
import org.come.action.monitor.MonitorUtil;
import org.come.bean.LoginResult;
import org.come.bean.NChatBean;
import org.come.entity.Goodstable;
import org.come.handler.SendMessage;
import org.come.model.GoodsExchange;
import org.come.protocol.Agreement;
import org.come.redis.RedisCacheUtil;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

public class GoodsExchangeAction
implements IAction {
    @Override
    public void action(ChannelHandlerContext ctx, String message) {
        GoodsExchange goodsExchange = (GoodsExchange)GsonUtil.getGsonUtil().getgson().fromJson(message, GoodsExchange.class);
        this.goodschange(goodsExchange, ctx);
    }

    public void goodschange(GoodsExchange goodsExchange, ChannelHandlerContext ctx) {
        Goodstable goodss;
        LoginResult loginResult = GameServer.getAllLoginRole().get((Object)ctx);
        if (loginResult == null) {
            return;
        }
        GoodsExchange exchange = goodsExchange;
        Goodstable goodstable = goodss = exchange != null ? GameServer.getAllGoodsMap().get(exchange.getGid()) : null;
        if (goodss == null) {
            SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("\u9519\u8bef\u5151\u6362\u516c\u5f0f"));
            return;
        }
        goodss.setRole_id(loginResult.getRole_id());
        goodss.setRgid(RedisCacheUtil.getGoods_pk());
        goodss.setStatus(0);
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
        buffer.append("#Y,\u83b7\u5f97#G");
        buffer.append(goodss.getGoodsname());
        buffer.append("#Y\uff01#89");
        NChatBean bean = new NChatBean();
        bean.setId(4);
        bean.setMessage(buffer.toString());
        String msg = Agreement.getAgreement().chatAgreement(GsonUtil.getGsonUtil().getgson().toJson((Object)bean));
        SendMessage.sendMessageToAllRoles(msg);
    }
}

