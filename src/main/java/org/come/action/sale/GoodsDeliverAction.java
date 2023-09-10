package org.come.action.sale;

import come.tool.Stall.AssetUpdate;
import io.netty.channel.ChannelHandlerContext;
import org.come.action.IAction;
import org.come.bean.GoodsBackBean;
import org.come.bean.LoginResult;
import org.come.entity.*;
import org.come.entity.RoleorderExample.Criteria;
import org.come.handler.SendMessage;
import org.come.protocol.Agreement;
import org.come.server.GameServer;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 卖家发货
 *
 * @author Administrator
 *
 */
public class GoodsDeliverAction implements IAction {

    @Override
    public void action(ChannelHandlerContext ctx, String message) {

        LoginResult saleRoleInfo = GameServer.getAllLoginRole().get(ctx);
        // 获取角色信息
        LoginResult roleInfo = GameServer.getAllLoginRole().get(ctx);

        // 获取商品信息
        GoodsBackBean backBean = GsonUtil.getGsonUtil().getgson().fromJson(message, GoodsBackBean.class);

        for (BigDecimal saleid : backBean.getIds()) {
            // 查找该商品
            Salegoods salegoods = AllServiceUtil.getSalegoodsService().selectByPrimaryKey(saleid);

            if(!salegoods.getRoleid().equals(saleRoleInfo.getRole_id())){

                System.out.println("不是你的商品无法发货 saleId =" + salegoods.getSaleid() +  " roleId = " + saleRoleInfo.getRole_id());
                continue;
            }

            Roleorder roleorder = AllServiceUtil.getRoleorderService().selectBySaleId(saleid);
            if(roleorder == null){
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("订单已发货，不要重复发货"));
                System.out.println("物品已发货或订单不存在 saleId = " + saleid);
                continue;
            }

            // 获取买家
            LoginResult role = AllServiceUtil.getRoleTableService().selectRoleID(roleorder.getRoleid());
            //可能买家不在线，需要测一下
            ChannelHandlerContext masterctx = GameServer.getInlineUserNameMap().get(role.getUserName());
            roleInfo = masterctx != null ? GameServer.getAllLoginRole().get(masterctx) : null;

            if (roleInfo == null) {
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().PromptAgreement("买家不在线，无法发货！请联系买家上线"));
                continue;
            }

            // 返回客户端的bean
            AssetUpdate update = new AssetUpdate();

            // 根据类型查找表数据
            if (salegoods.getSaletype() == 3 || salegoods.getSaletype() == 5) {// 物品表
                // 查找该物品
                Goodstable goods2 = AllServiceUtil.getGoodsTableService().getGoodsByRgID(salegoods.getOtherid());

                AllServiceUtil.getGoodsrecordService().insert(goods2, null, 1, 14);
                // 修改物品角色ID
                AllServiceUtil.getGoodsTableService().updateGoodsIndex(goods2, roleInfo.getRole_id(), null, null);
                // 添加返回bean
                List<Goodstable> goodstables = new ArrayList<>();
                goodstables.add(goods2);
                update.setGoods(goodstables);

            } else if (salegoods.getSaletype() == 4) {// 召唤兽表
                // 查找该召唤兽
                RoleSummoning pet = AllServiceUtil.getRoleSummoningService().selectRoleSummoningsByRgID(salegoods.getOtherid());
                // 修改物品角色ID
                AllServiceUtil.getRoleSummoningService().updateRoleSummoningIndex(pet, roleInfo.getRole_id());

                // 添加返回bean
                List<RoleSummoning> pets = new ArrayList<>();
                pets.add(pet);
                update.setPets(pets);

                List<Goodstable> goodstables = new ArrayList<>();
                // 获取召唤兽内丹饰品ID,修改角色ID为负
                List<BigDecimal> goodses=pet.getGoods();
                if (goodses!=null) {
                    for (BigDecimal bigDecimal : goodses) {
                        Goodstable goodstable = AllServiceUtil.getGoodsTableService().getGoodsByRgID(bigDecimal);
                        AllServiceUtil.getGoodsTableService().updateGoodsIndex(goodstable, roleInfo.getRole_id(), null, null);
                        goodstables.add(goodstable);
                    }
                }
                update.setGoods(goodstables);
            } else if (salegoods.getSaletype() == 6) {// 灵宝表
                // 查找该灵宝
                Lingbao lingbao = AllServiceUtil.getLingbaoService().selectByPrimaryKey(salegoods.getOtherid());
                // 修改物品角色ID
                AllServiceUtil.getLingbaoService().updateLingbaoIndex(lingbao, roleInfo.getRole_id());
                // 添加返回bean
                List<Lingbao> lingbaos = new ArrayList<>();
                lingbaos.add(lingbao);
                update.setLingbaos(lingbaos);

                // 修改灵宝符石
                List<Goodstable> goodstables = new ArrayList<>();
                if( lingbao.getFushis() != null && !"".equals(lingbao.getFushis()) ){
                    String[] baos = lingbao.getFushis().split("\\|");
                    for (String string : baos) {
                        Goodstable goodstable = AllServiceUtil.getGoodsTableService().getGoodsByRgID(new BigDecimal(string));
                        AllServiceUtil.getGoodsTableService().updateGoodsIndex(goodstable, roleInfo.getRole_id(), null, null);
                        goodstables.add(goodstable);
                    }
                }

                update.setGoods(goodstables);

            }else if( salegoods.getSaletype() == 2 ){
                update.updata("D="+salegoods.getOtherid().longValue());
                // 角色添加金钱
                roleInfo.setGold(roleInfo.getGold().add(salegoods.getOtherid()));
            }

            update.setMsg(1+"个"+salegoods.getSalename());
            // 类型
            update.setType(AssetUpdate.CGB);
            update.reset();
            // 发送前端取回的东西
            SendMessage.sendMessageToSlef(masterctx, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(update)));
            AllServiceUtil.getSalegoodsService().updateFlag(salegoods.getSaleid(), 5);

            AllServiceUtil.getSalegoodsService().updateFlagDb(salegoods.getSaleid(), 5);
        }

        // 修改订单的状态
        RoleorderExample example = new RoleorderExample();
        Criteria c = example.createCriteria();
        c.andRoleidEqualTo(roleInfo.getRole_id());
        c.andSaleidIn(backBean.getIds());
        Roleorder record = new Roleorder();
        // 已取货
        record.setStatus(4);
        AllServiceUtil.getRoleorderService().updateByExampleSelective(record, example);

    }

}
