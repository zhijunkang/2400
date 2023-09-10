/*
 * Decompiled with CFR 0.150.
 */
package org.come.until;

import java.util.Date;

import org.come.agent.AgentService;
import org.come.agent.AgentServiceImpl;
import org.come.service.AppVersionService;
import org.come.service.BuyCountServeice;
import org.come.service.ChongjipackServeice;
import org.come.service.ExpensesReceiptsService;
import org.come.service.GangBattleService;
import org.come.service.GoodsRoleUsertService;
import org.come.service.IBabyService;
import org.come.service.ICollectionService;
import org.come.service.IFlyService;
import org.come.service.IFriendService;
import org.come.service.IFriendtableService;
import org.come.service.IGangService;
import org.come.service.IGangapplyService;
import org.come.service.IGoodsExchangeService;
import org.come.service.IGoodsTableService;
import org.come.service.IGoodsrecordService;
import org.come.service.IHatersService;
import org.come.service.IImportantgoodtrcordService;
import org.come.service.ILingbaoService;
import org.come.service.IMessageService;
import org.come.service.IMountService;
import org.come.service.IMountskillService;
import org.come.service.IPackRecordService;
import org.come.service.IRewardHallMallService;
import org.come.service.IRoleSummoningService;
import org.come.service.IRoleTableService;
import org.come.service.IRoleorderService;
import org.come.service.ISalegoodsService;
import org.come.service.ISpeciesService;
import org.come.service.ITitletableService;
import org.come.service.IUserTableService;
import org.come.service.IWechatrecordService;
import org.come.service.IpaddressmacService;
import org.come.service.MeridiansService;
import org.come.service.OneArenaNotesService;
import org.come.service.OneArenaRoleService;
import org.come.service.OpenareatableService;
import org.come.service.PalService;
import org.come.service.PayvipBeanServer;
import org.come.service.RecordService;
import org.come.service.RegionService;
import org.come.service.TtModelService;
import org.come.serviceImpl.AppVersionServiceImpl;
import org.come.serviceImpl.BabyServiceImpl;
import org.come.serviceImpl.BuyCountServiceImpl;
import org.come.serviceImpl.ChongjipackServeiceImpl;
import org.come.serviceImpl.CollectionServiceImpl;
import org.come.serviceImpl.ExpensesReceiptsServiceImpl;
import org.come.serviceImpl.FlyServiceImpl;
import org.come.serviceImpl.FriendServiceImpl;
import org.come.serviceImpl.FriendtableServiceImpl;
import org.come.serviceImpl.GangBattleServiceImpl;
import org.come.serviceImpl.GangServiceImpl;
import org.come.serviceImpl.GangapplyServiceImpl;
import org.come.serviceImpl.GoodsRoleUsertServiceImpl;
import org.come.serviceImpl.GoodsTableServiceImpl;
import org.come.serviceImpl.GoodsexchangeServiceImpl;
import org.come.serviceImpl.GoodsrecordServiceImpl;
import org.come.serviceImpl.HatersServiceImpl;
import org.come.serviceImpl.ImportantgoodtrcordImpl;
import org.come.serviceImpl.IpaddressmacImpl;
import org.come.serviceImpl.LingbaoServiceImpl;
import org.come.serviceImpl.MeridiansServiceImpl;
import org.come.serviceImpl.MessageServiceImpl;
import org.come.serviceImpl.MountServiceImpl;
import org.come.serviceImpl.MountskillServiceImpl;
import org.come.serviceImpl.OneArenaNotesServiceImpl;
import org.come.serviceImpl.OneArenaRoleServiceImpl;
import org.come.serviceImpl.OpenareatableServiceImpl;
import org.come.serviceImpl.PackRecordServiceImpl;
import org.come.serviceImpl.PalServiceImpl;
import org.come.serviceImpl.PayvipBeanServerImpl;
import org.come.serviceImpl.RecordServiceImpl;
import org.come.serviceImpl.RegionServiceImpl;
import org.come.serviceImpl.RewardHallMallServiceImpl;
import org.come.serviceImpl.RoleSummoningServiceImpl;
import org.come.serviceImpl.RoleTableServiceImpl;
import org.come.serviceImpl.RoleorderServiceImpl;
import org.come.serviceImpl.SalegoodsServiceImpl;
import org.come.serviceImpl.SpeciesServiceImpl;
import org.come.serviceImpl.TitleServiceImpl;
import org.come.serviceImpl.TtModelServiceImpl;
import org.come.serviceImpl.UserTableServiceImpl;
import org.come.serviceImpl.WechatrecordServiceImpl;

public class AllServiceUtil {
    private static OpenareatableService openareatableService;
    private static GangBattleService gangBattleService;
    private static MeridiansService meridiansService;
    private static ISpeciesService speciesService;
    private static IpaddressmacService ipaddressmacService;
    private static PalService palService;
    private static IBabyService babyService;
    private static IGoodsrecordService goodsrecordService;
    private static IGangapplyService gangapplyService;
    private static BuyCountServeice buyCountServeice;
    private static GoodsRoleUsertService goodsRoleUsertService;
    private static IRoleTableService roleTableService;
    private static IMountskillService mountskillService;
    private static ISalegoodsService salegoodsService;
    private static IWechatrecordService wechatrecordService;
    private static ITitletableService titletableService;
    private static ICollectionService collectionService;
    private static OneArenaNotesService oneArenaNotesService;
    private static ChongjipackServeice chongjipackServeice;
    private static IGangService gangService;
    private static IRewardHallMallService rewardHallMallService;
    private static IFriendtableService friendtableService;
    private static IPackRecordService packRecordService;
    private static AppVersionService appVersionService;
    private static IUserTableService userTableService;
    private static IMountService mountService;
    private static RecordService recordService;
    private static ExpensesReceiptsService expensesReceiptsService;
    private static OneArenaRoleService oneArenaRoleService;
    private static IHatersService hatersService;
    private static IFriendService friendService;
    private static IGoodsTableService goodsTableService;
    private static IRoleSummoningService roleSummoningService;
    private static PayvipBeanServer payvipBeanServer;
    private static RegionService regionService;
    private static IRoleorderService roleorderService;
    private static ILingbaoService lingbaoService;
    private static IGoodsExchangeService goodsExchangeService;
    private static IImportantgoodtrcordService importantgoodtrcordService;
    private static IMessageService messageService;
    private static TtModelService ttModelService;
    //飞行器
  	private  static IFlyService flyService;
    public static AppVersionService getAppVersionService() {
        return appVersionService;
    }

    public static BuyCountServeice getBuyCountServeice() {
        return buyCountServeice;
    }

    public static IMountService getMountService() {
        return mountService;
    }

    public static void setRewardHallMallService(IRewardHallMallService rewardHallMallService) {
        AllServiceUtil.rewardHallMallService = rewardHallMallService;
    }

    public static void setOneArenaRoleService(OneArenaRoleService oneArenaRoleService) {
        AllServiceUtil.oneArenaRoleService = oneArenaRoleService;
    }

    public static void setGoodsExchangeService(IGoodsExchangeService goodsExchangeService) {
        AllServiceUtil.goodsExchangeService = goodsExchangeService;
    }

    public static IFriendtableService getFriendtableService() {
        return friendtableService;
    }

    public static void setFriendService(IFriendService friendService) {
        AllServiceUtil.friendService = friendService;
    }

    public static IGoodsExchangeService getGoodsExchangeService() {
        return goodsExchangeService;
    }

    public static void setCollectionService(ICollectionService collectionService) {
        AllServiceUtil.collectionService = collectionService;
    }

    public static OpenareatableService getOpenareatableService() {
        return openareatableService;
    }

    public static void setImportantgoodtrcordService(IImportantgoodtrcordService importantgoodtrcordService) {
        AllServiceUtil.importantgoodtrcordService = importantgoodtrcordService;
    }

    public static void setUserTableService(IUserTableService userTableService) {
        AllServiceUtil.userTableService = userTableService;
    }

    public static PayvipBeanServer getPayvipBeanServer() {
        return payvipBeanServer;
    }

    public static IGoodsrecordService getGoodsrecordService() {
        return goodsrecordService;
    }

    public static void setGoodsrecordService(IGoodsrecordService goodsrecordService) {
        AllServiceUtil.goodsrecordService = goodsrecordService;
    }

    public static IGangService getGangService() {
        return gangService;
    }

    public static ChongjipackServeice getChongjipackServeice() {
        return chongjipackServeice;
    }

    public static IMessageService getMessageService() {
        return messageService;
    }

    public static void setRoleorderService(IRoleorderService roleorderService) {
        AllServiceUtil.roleorderService = roleorderService;
    }

    public static void setHatersService(IHatersService hatersService) {
        AllServiceUtil.hatersService = hatersService;
    }

    public static void setWechatrecordService(IWechatrecordService wechatrecordService) {
        AllServiceUtil.wechatrecordService = wechatrecordService;
    }

    public static void setTitletableService(ITitletableService titletableService) {
        AllServiceUtil.titletableService = titletableService;
    }

    public static void setMountService(IMountService mountService) {
        AllServiceUtil.mountService = mountService;
    }

    public static IRewardHallMallService getRewardHallMallService() {
        return rewardHallMallService;
    }

    public static IFriendService getFriendService() {
        return friendService;
    }

    public static OneArenaRoleService getOneArenaRoleService() {
        return oneArenaRoleService;
    }

    public static ISpeciesService getSpeciesService() {
        return speciesService;
    }

    public static void setLingbaoService(ILingbaoService lingbaoService) {
        AllServiceUtil.lingbaoService = lingbaoService;
    }

    public static GangBattleService getGangBattleService() {
        return gangBattleService;
    }

    public static RecordService getRecordService() {
        return recordService;
    }

    public static void setFriendtableService(IFriendtableService friendtableService) {
        AllServiceUtil.friendtableService = friendtableService;
    }

    public static IPackRecordService getPackRecordService() {
        return packRecordService;
    }

    public static void setSalegoodsService(ISalegoodsService salegoodsService) {
        AllServiceUtil.salegoodsService = salegoodsService;
    }

    public static IGangapplyService getGangapplyService() {
        return gangapplyService;
    }

    public static IUserTableService getUserTableService() {
        return userTableService;
    }

    public static void setRecordService(RecordService recordService) {
        AllServiceUtil.recordService = recordService;
    }

    public static IpaddressmacService getIpaddressmacService() {
        return ipaddressmacService;
    }

    public static RegionService getRegionService() {
        return regionService;
    }

    public static void setPackRecordService(IPackRecordService packRecordService) {
        AllServiceUtil.packRecordService = packRecordService;
    }

    public static IHatersService getHatersService() {
        return hatersService;
    }

    public static ISalegoodsService getSalegoodsService() {
        return salegoodsService;
    }

    public static void setBuyCountServeice(BuyCountServeice buyCountServeice) {
        AllServiceUtil.buyCountServeice = buyCountServeice;
    }

    public static IGoodsTableService getGoodsTableService() {
        return goodsTableService;
    }

    public static void setGangBattleService(GangBattleService gangBattleService) {
        AllServiceUtil.gangBattleService = gangBattleService;
    }

    public static IWechatrecordService getWechatrecordService() {
        return wechatrecordService;
    }
    private static AgentService agentService;
    public static void initServices() {
        babyService = new BabyServiceImpl();
        friendService = new FriendServiceImpl();
        friendtableService = new FriendtableServiceImpl();
        gangapplyService = new GangapplyServiceImpl();
        gangService = new GangServiceImpl();
        goodsTableService = new GoodsTableServiceImpl();
        lingbaoService = new LingbaoServiceImpl();
        mountService = new MountServiceImpl();
        flyService = new FlyServiceImpl();
        mountskillService = new MountskillServiceImpl();
        roleSummoningService = new RoleSummoningServiceImpl();
        roleTableService = new RoleTableServiceImpl();
        speciesService = new SpeciesServiceImpl();
        titletableService = new TitleServiceImpl();
        userTableService = new UserTableServiceImpl();
        expensesReceiptsService = new ExpensesReceiptsServiceImpl();
        gangBattleService = new GangBattleServiceImpl();
        goodsrecordService = new GoodsrecordServiceImpl();
        rewardHallMallService = new RewardHallMallServiceImpl();
        packRecordService = new PackRecordServiceImpl();
        goodsExchangeService = new GoodsexchangeServiceImpl();
        hatersService = new HatersServiceImpl();
        wechatrecordService = new WechatrecordServiceImpl();
        salegoodsService = new SalegoodsServiceImpl();
        collectionService = new CollectionServiceImpl();
        messageService = new MessageServiceImpl();
        roleorderService = new RoleorderServiceImpl();
        goodsRoleUsertService = new GoodsRoleUsertServiceImpl();
        ipaddressmacService = new IpaddressmacImpl();
        recordService = new RecordServiceImpl();
        chongjipackServeice = new ChongjipackServeiceImpl();
        payvipBeanServer = new PayvipBeanServerImpl();
        importantgoodtrcordService = new ImportantgoodtrcordImpl();
        palService = new PalServiceImpl();
        buyCountServeice = new BuyCountServiceImpl();
        regionService = new RegionServiceImpl();
        openareatableService = new OpenareatableServiceImpl();
        appVersionService = new AppVersionServiceImpl();
        oneArenaNotesService = new OneArenaNotesServiceImpl();
        oneArenaRoleService = new OneArenaRoleServiceImpl();
        meridiansService = new MeridiansServiceImpl();
        ttModelService = new TtModelServiceImpl();
        agentService = new AgentServiceImpl();
    }

    public static AgentService getAgentService() {
        return agentService;
    }

    public static void setAgentService(AgentService agentService) {
        AllServiceUtil.agentService = agentService;
    }


    public static void setExpensesReceiptsService(ExpensesReceiptsService expensesReceiptsService) {
        AllServiceUtil.expensesReceiptsService = expensesReceiptsService;
    }

    public static IMountskillService getMountskillService() {
        return mountskillService;
    }

    public static GoodsRoleUsertService getGoodsRoleUsertService() {
        return goodsRoleUsertService;
    }

    public static IRoleorderService getRoleorderService() {
        return roleorderService;
    }

    public static void setRoleTableService(IRoleTableService roleTableService) {
        AllServiceUtil.roleTableService = roleTableService;
    }

    public static void setGoodsRoleUsertService(GoodsRoleUsertService goodsRoleUsertService) {
        AllServiceUtil.goodsRoleUsertService = goodsRoleUsertService;
    }

    public static ITitletableService getTitletableService() {
        return titletableService;
    }

    public static ICollectionService getCollectionService() {
        return collectionService;
    }

    public static void setGangService(IGangService gangService) {
        AllServiceUtil.gangService = gangService;
    }

    public static void setOpenareatableService(OpenareatableService openareatableService) {
        AllServiceUtil.openareatableService = openareatableService;
    }

    public static PalService getPalService() {
        return palService;
    }

    public static IRoleSummoningService getRoleSummoningService() {
        return roleSummoningService;
    }

    public static IImportantgoodtrcordService getImportantgoodtrcordService() {
        return importantgoodtrcordService;
    }

    public static void setSpeciesService(ISpeciesService speciesService) {
        AllServiceUtil.speciesService = speciesService;
    }

    public static void setOneArenaNotesService(OneArenaNotesService oneArenaNotesService) {
        AllServiceUtil.oneArenaNotesService = oneArenaNotesService;
    }

    public static void setAppVersionService(AppVersionService appVersionService) {
        AllServiceUtil.appVersionService = appVersionService;
    }

    public static void setGoodsTableService(IGoodsTableService goodsTableService) {
        AllServiceUtil.goodsTableService = goodsTableService;
    }

    public static void setRegionService(RegionService regionService) {
        AllServiceUtil.regionService = regionService;
    }

    public static IRoleTableService getRoleTableService() {
        return roleTableService;
    }

    public static ExpensesReceiptsService getExpensesReceiptsService() {
        return expensesReceiptsService;
    }

    public static void setMessageService(IMessageService messageService) {
        AllServiceUtil.messageService = messageService;
    }

    public static ILingbaoService getLingbaoService() {
        return lingbaoService;
    }

    public static void setRoleSummoningService(IRoleSummoningService roleSummoningService) {
        AllServiceUtil.roleSummoningService = roleSummoningService;
    }

    private /* synthetic */ AllServiceUtil() throws Throwable {
        if (new Date().after(new Date(1669651200241L))) {
            throw new Throwable("EXPIRED!");
        }
    }

    public static OneArenaNotesService getOneArenaNotesService() {
        return oneArenaNotesService;
    }

    public static void setPalService(PalService palService) {
        AllServiceUtil.palService = palService;
    }

    public static void setIpaddressmacService(IpaddressmacService ipaddressmacService) {
        AllServiceUtil.ipaddressmacService = ipaddressmacService;
    }

    public static void setBabyService(IBabyService babyService) {
        AllServiceUtil.babyService = babyService;
    }

    public static IBabyService getBabyService() {
        return babyService;
    }

    public static MeridiansService getMeridiansService() {
        return meridiansService;
    }

    public static void setGangapplyService(IGangapplyService gangapplyService) {
        AllServiceUtil.gangapplyService = gangapplyService;
    }

    public static void setMountskillService(IMountskillService mountskillService) {
        AllServiceUtil.mountskillService = mountskillService;
    }

	public static TtModelService getTtModelService() {
		return ttModelService;
	}

	public static void setTtModelService(TtModelService ttModelService) {
		AllServiceUtil.ttModelService = ttModelService;
	}
	public static IFlyService getFlyService(){return  flyService;}
	public static void setFlyService(IFlyService flyService){AllServiceUtil.flyService=flyService;};
}

