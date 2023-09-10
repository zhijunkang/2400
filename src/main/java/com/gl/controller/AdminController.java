package com.gl.controller;

import cn.hutool.core.util.ArrayUtil;
import com.github.pagehelper.util.StringUtil;
import com.gl.model.Param;
import com.gl.model.Result;
import com.gl.model.UpPetParam;
import com.gl.model.User;
import com.gl.service.*;
import com.gl.token.UserToken;
import come.tool.Good.NPCDialogBean;
import come.tool.Role.PrivateData;
import come.tool.Role.RoleData;
import come.tool.Role.RolePool;
import come.tool.Scene.LaborDay.LaborScene;
import come.tool.Stall.AssetUpdate;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.come.action.monitor.MonitorUtil;
import org.come.agent.Agent;
import org.come.bean.*;
import org.come.entity.*;
import org.come.handler.MainServerHandler;
import org.come.handler.SendMessage;
import org.come.model.Skill;
import org.come.protocol.Agreement;
import org.come.redis.RedisPoolUntil;
import org.come.server.GameServer;
import org.come.tool.Arith;
import org.come.tool.ReadExelTool;
import org.come.tool.WriteOut;
import org.come.until.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static come.tool.Good.UsePetAction.mathDouble;

/**
 * @author Big Green
 * @mail sinmahod@qq.com
 */
@RestController
public class AdminController {

    private ConcurrentHashMap<String, Goodstable> nds = new ConcurrentHashMap<String, Goodstable>();
    private String agentGoodsIds;
    private static final int PageSize = 10;

    /**
     * 处理登录功能
     */
    @PostMapping(value = "/api/adminLogin")
    public Result login1(User user, HttpSession session, HttpServletRequest request) {
        // 获取用户名密码格式为 用户名|&|密码
        String up = ReadTxtUtil.readFile1(ReadExelTool.class.getResource("/").getPath() + "administrator.db");
        String[] nameAndPwd = up.split("\\|&\\|");
        if (nameAndPwd[0].equals(user.getUserName()) && nameAndPwd[1].equals(user.getPassword())) {
            TokenService tokenService = new TokenService();
            String token = tokenService.getToken(user);
            session.setAttribute(UserService.USERNAME, user);
            return ResultFactory.success(token + "|admin");
        } else {
            //查询代理登录
            Agent agent = AllServiceUtil.getAgentService().selectByUserName(user.getUserName());
            if (agent != null) {
                if (agent.getUserName().equals(user.getUserName()) && agent.getPassword().equals(user.getPassword())) {
                    TokenService tokenService = new TokenService();
                    String token = tokenService.getToken(user);
                    session.setAttribute(UserService.USERNAME, user);
                    return ResultFactory.success(token + "|agent");
                } else
                    return ResultFactory.fail("用户名或密码错误，请重新登录！ ");
            } else
                return ResultFactory.fail("用户名或密码错误，请重新登录！ ");
        }
    }

//    @UserToken
    @PostMapping(value = "/api/getUserGood")
    public Result getUserGood(Param param) {
        GoodsService service = new GoodsService();
        List<Goodstable> goods = AllServiceUtil.getGoodsTableService().getGoodsByRoleID(new BigDecimal(param.getValue1()));
        return ResultFactory.success(goods);
    }

    @UserToken
    @PostMapping(value = "/api/agentRecharge")
    public Result recharge(Param param, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(UserService.USERNAME);
        Agent agent = AllServiceUtil.getAgentService().selectByUserName(user.getUserName());
        if (agent == null)
            return ResultFactory.fail("代理不存在！");

        //1仙玉充值
        if ("1".equals(param.getValue5())) {
            // 仙玉
            Integer yuanbao = Integer.parseInt(param.getValue3());
            if (agent.getXianyu().intValue() < yuanbao)
                return ResultFactory.fail("代理元宝不足以抵扣本次充值！");
            Integer jf = Integer.parseInt(param.getValue2());
            if (agent.getJf().intValue() < jf)
                return ResultFactory.fail("代理充值金额不足以抵扣本次充值！");
            agent.setXianyu(agent.getXianyu().subtract(new BigDecimal(param.getValue3())));
            agent.setJf(agent.getJf().subtract(new BigDecimal(param.getValue2())));
        } else if ("2".equals(param.getValue5())) {
            param.setValue2("98");
            Integer jf = Integer.parseInt(param.getValue2());
            if (agent.getJf().intValue() < jf)
                return ResultFactory.fail("代理充值金额不足以抵扣本次充值！");
            agent.setJf(agent.getJf().subtract(new BigDecimal(param.getValue2())));
        }
        AllServiceUtil.getAgentService().upAgentXyAndJf(agent);
        PlayerService service = new PlayerService();
        if (agentRechargeCallBack(param,agent)) {
            return ResultFactory.success(AllServiceUtil.getAgentService().selectByUserName(agent.getUserName()));
        }
        return ResultFactory.fail("操作失败");
    }

//    @UserToken
    @PostMapping(value = "/api/getUserPet")
    public Result getUserPet(Param param) {
        List<RoleSummoning> roleSummonings = AllServiceUtil.getRoleSummoningService().selectRoleSummoningsByRoleID(new BigDecimal(param.getValue1()));
        return ResultFactory.success(roleSummonings);
    }


//    @UserToken
    @PostMapping(value = "/api/getUserMount")
    public Result getUserMount(Param param) {
        List<Mount> mounts = AllServiceUtil.getMountService().selectMountsByRoleID(new BigDecimal(param.getValue1()));
        return ResultFactory.success(mounts);
    }


    @UserToken
    @PostMapping(value = "/api/getUserLing")
    public Result getUserLing(Param param) {
        List<Lingbao> lingbaos = AllServiceUtil.getLingbaoService().selectLingbaoByRoleID(new BigDecimal(param.getValue1()));
        return ResultFactory.success(lingbaos);
    }


    @UserToken
    @PostMapping(value = "/api/updUserLing")
    public Result updUserLing(Lingbao param) {

        LoginResult loginResult = AllServiceUtil.getRoleTableService().selectRoleByRoleId(param.getRoleid());
        if (loginResult == null)
            return ResultFactory.fail("角色不存在！");
        Lingbao lingbao = AllServiceUtil.getLingbaoService().selectLingbaoByID(param.getBaoid());

        if (lingbao == null)
            return ResultFactory.fail("灵宝不存在！");

        lingbao.setBaoactive(param.getBaoactive());
        lingbao.setBaospeed(param.getBaospeed());
        lingbao.setAssistance(param.getAssistance());
        lingbao.setGoodskill(param.getGoodskill());
        lingbao.setLingbaolvl(param.getLingbaolvl());
        lingbao.setSkills(param.getSkills());
        lingbao.setTianfuskill(param.getTianfuskill());
        lingbao.setSkillsum(param.getSkillsum());
        lingbao.setFusum(param.getFusum());
        AllServiceUtil.getLingbaoService().updateLingbaoRedis(lingbao);
        if (loginResult != null) {
            ChannelHandlerContext channelHandlerContext = GameServer.getRoleNameMap().get(loginResult.getRolename());
            if (channelHandlerContext != null) {
                AssetUpdate update = new AssetUpdate();
                // 添加返回bean
                List<Lingbao> lingbaos = new ArrayList<>();
                lingbaos.add(lingbao);
                update.setLingbaos(lingbaos);
                update.setType(AssetUpdate.USEGOOD);
                update.setMsg(":#R多功能后台修改灵宝成功#23");
                // 发送前端取回的东西
                SendMessage.sendMessageToSlef(channelHandlerContext, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(update)));
            }
        }

        return ResultFactory.success(null);
    }

    @UserToken
    @PostMapping(value = "/api/getUserBaby")
    public Result getUserBaby(Param param) {
        List<Baby> babys = AllServiceUtil.getBabyService().selectBabyByRolename(new BigDecimal(param.getValue1()));
        return ResultFactory.success(babys);
    }

    @UserToken
    @PostMapping(value = "/api/getAgentLog")
    public Result getAgentLog(Param param, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(UserService.USERNAME);
        Agent agent = AllServiceUtil.getAgentService().selectByUserName(user.getUserName());
        ExpensesReceipts expensesReceipts = new ExpensesReceipts();
        if(agent != null){
            expensesReceipts.setManagerid(new BigDecimal(agent.getAgentId()));
        }
        List<ExpensesReceipts> expensesReceipts1 = AllServiceUtil.getExpensesReceiptsService().selectAll(expensesReceipts);
        return ResultFactory.success(expensesReceipts1);
    }

    @UserToken
    @GetMapping(value = "/api/getAgentJurisdiction")
    public Result getAgentJurisdiction(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(UserService.USERNAME);
        String up = ReadTxtUtil.readFile1(ReadExelTool.class.getResource("/").getPath() + "administrator.db");
        String[] nameAndPwd = up.split("\\|&\\|");
        if (user.getUserName().equals(nameAndPwd[0])) {
            Agent agent = new Agent();
            agent.setJurisdiction("admin");
            //admin 返回所有权限
            return ResultFactory.success(agent);
        } else {
            Agent agent = AllServiceUtil.getAgentService().selectByUserName(user.getUserName());
            if (agent != null)
                return ResultFactory.success(agent);
            else
                return ResultFactory.success("");
        }
    }

    @UserToken
    @GetMapping(value = "/api/agentGoods")
    public Result agentGoods(HttpServletRequest httpServletRequest) {

        Map<String, String> goodsMap = new GoodsService().goodsMap();
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(UserService.USERNAME);
        String up = ReadTxtUtil.readFile1(ReadExelTool.class.getResource("/").getPath() + "administrator.db");
        String[] nameAndPwd = up.split("\\|&\\|");
        if (user.getUserName().equals(nameAndPwd[0])) {
            return ResultFactory.success(goodsMap);
        } else {
            Agent agent = AllServiceUtil.getAgentService().selectByUserName(user.getUserName());
            if (agent != null && StringUtils.isNotBlank(agent.getJurisdiction()) && agent.getJurisdiction().contains("物品")) {
                if (StringUtils.isNotBlank(agentGoodsIds)) {
                    String[] items = agentGoodsIds.split("\\|");
                    Map<String, String> AgentGoodsMap = new ConcurrentHashMap<>();
                    for (String item : items) {
                        goodsMap.forEach((k, v) -> {
                            if (v.equals(item))
                                AgentGoodsMap.put(k, v);

                        });
                    }
                    return ResultFactory.success(AgentGoodsMap);
                }
            }
        }
        return ResultFactory.success(new ConcurrentHashMap<String, String>());

    }


    @UserToken
    @PostMapping(value = "/api/agentRole")
    public Result roles(Param param, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(UserService.USERNAME);
        String up = ReadTxtUtil.readFile1(ReadExelTool.class.getResource("/").getPath() + "administrator.db");
        String[] nameAndPwd = up.split("\\|&\\|");
        if (user.getUserName().equals(nameAndPwd[0])) {
            PlayerService service = new PlayerService();
            BackRoleInfo role = service.getRole(param);
            //admin 返回所有权限
            return ResultFactory.success(role);
        } else {
            BackRoleInfo role = new BackRoleInfo();
            Agent agent = AllServiceUtil.getAgentService().selectByUserName(user.getUserName());
            if (agent != null) {
                param.setValue3(agent.getQid());
                role = getRole(param);
            }
            return ResultFactory.success(role);

        }

    }
    @UserToken
    @GetMapping(value = "/api/getAgentSendGoods")
    public Result getAgendSendGoods(HttpServletRequest httpServletRequest) {
        if (StringUtils.isBlank(agentGoodsIds)) {
            Properties properties = new Properties();
            InputStream in = GameServer.class.getClassLoader().getResourceAsStream("agent.properties");
            try {
                properties.load(in);// 使用properties对象加载输入流
            } catch (IOException e) {
                e.printStackTrace();
            }
            agentGoodsIds = properties.get("agentGoods").toString();
        }
        return ResultFactory.success(agentGoodsIds);

    }


    @UserToken
    @PostMapping(value = "/api/upAgentSendGoods")
    public Result upAgentSendGoods(Param param) {

        if (StringUtils.isNotBlank(param.getValue1())) {
            agentGoodsIds = param.getValue1();
            try {
                byte[] bs = agentGoodsIds.getBytes();
                CreateTextUtil.createFile(ReadExelTool.class.getResource("/").getPath() + "agentGoods.txt", bs);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return ResultFactory.success(true);

    }

    @UserToken
    @PostMapping(value = "/api/agentSendGoods")
    public Result agentSendGoods(Param param) {
        GoodsService service = new GoodsService();
        if (service.sendGoods(param)) {
            return ResultFactory.success(null);
        }
        return ResultFactory.fail("物品发送失败，请确认玩家或物品是否存在");
    }

    @UserToken
    @GetMapping(value = "/api/getMenuList")
    public Result getMenuList(Param param, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute(UserService.USERNAME);
        String up = ReadTxtUtil.readFile1(ReadExelTool.class.getResource("/").getPath() + "user.db");
        String[] nameAndPwd = up.split("\\|&\\|");
        if (user.getUserName().equals(nameAndPwd[0])) {
            //admin 返回所有权限
            return ResultFactory.success("admin");
        } else {
            //查询代理表.获取指定代理权限
            return ResultFactory.success("test");
        }
    }

    @UserToken
    @GetMapping(value = "/api/getAgentAll")
    public Result getMenuList(HttpServletRequest httpServletRequest) {

        List<Agent> agents = AllServiceUtil.getAgentService().selectAll();
        //admin 返回所有权限
        return ResultFactory.success(agents);
    }

    @UserToken
    @GetMapping(value = "/api/getOpenAll")
    public Result getOpenAll(HttpServletRequest httpServletRequest) {


        List<Openareatable> openareatables = AllServiceUtil.getOpenareatableService().selectAllOpenareatable();
        //admin 返回所有权限
        return ResultFactory.success(openareatables);
    }

    @UserToken
    @PostMapping(value = "/api/addAgent")
    public Result addAgent(Agent agent) {
        agent.setCreatTime(new Date());
        List<BigDecimal> bigDecimals = AllServiceUtil.getOpenareatableService().selectTuijiNum(agent.getUserName());
        if (bigDecimals.size() > 0) {
            return ResultFactory.fail("当前代理已存在");
        }

        //插入推荐表
        Openareatable openareatable1 = new Openareatable();
        List<Openareatable> openareatables = AllServiceUtil.getOpenareatableService().selectAllOpenareatable();
        if (openareatables.size() == 1) {
            openareatable1 = openareatables.get(0);
            openareatable1.setOt_areaid(new BigDecimal(openareatable1.getOt_areaid().intValue() + 1));
            openareatable1.setOt_atid(agent.getUserName());
            AllServiceUtil.getOpenareatableService().insertOpenareatable(openareatable1);
        } else if (openareatables.size() == 0) {

        } else {
            List<BigDecimal> collect = openareatables.stream().map(item -> item.getOt_areaid()).collect(Collectors.toList());
            Collections.sort(collect);
            openareatable1 = openareatables.get(0);
            openareatable1.setOt_areaid(new BigDecimal(collect.get(collect.size() - 1).intValue() + 1));
            openareatable1.setOt_atid(agent.getUserName());
            AllServiceUtil.getOpenareatableService().insertOpenareatable(openareatable1);

        }

        agent.setQid(openareatable1.getOt_areaid().toString());
        agent.setXianyu(BigDecimal.ZERO);
        agent.setJf(BigDecimal.ZERO);
        agent.setAgentId(AllServiceUtil.getAgentService().agemntMaxId()+1);
        AllServiceUtil.getAgentService().addAgent(agent);


        return ResultFactory.success(true);

    }

    @UserToken
    @PostMapping(value = "/api/delAgent")
    public Result delAgent(Agent agent) {
        AllServiceUtil.getAgentService().deleteById(agent.getAgentId().toString());
        List<Openareatable> openareatables = AllServiceUtil.getOpenareatableService().selectAllOpenareatable();
        Openareatable openareatable = openareatables.stream().filter(item -> item.getOt_atid().equals(agent.getUserName())).findFirst().get();
        AllServiceUtil.getOpenareatableService().deleteOpenareatable(openareatable.getTb_id());
        return ResultFactory.success(true);
    }


    @UserToken
    @PostMapping(value = "/api/upAgentPwd")
    public Result upAgentPwd(Agent agent) {
        AllServiceUtil.getAgentService().upAgent(agent);
        return ResultFactory.success(true);
    }

    @UserToken
    @PostMapping(value = "/api/addPay")
    public Result addPay(Agent agent) {
        Agent dbAgent = AllServiceUtil.getAgentService().selectByUserName(agent.getUserName());
        dbAgent.setXianyu(agent.getXianyu().add(dbAgent.getXianyu()));
        dbAgent.setJf(agent.getJf().add(dbAgent.getJf()));
        AllServiceUtil.getAgentService().upAgentXyAndJf(dbAgent);
        return ResultFactory.success(true);
    }


    @UserToken
    @PostMapping(value = "/api/updUserBaby")
    public Result updUserBaby(Baby baby) {
        LoginResult loginResult = AllServiceUtil.getRoleTableService().selectRoleByRoleId(baby.getRoleid());
        if (loginResult == null)
            return ResultFactory.fail("角色不存在！");

        Baby dbBaby = AllServiceUtil.getBabyService().selectBabyById(baby.getBabyid());


        if (dbBaby == null)
            return ResultFactory.fail("孩子不存在！");
        dbBaby.setTalents(baby.getTalents());
        dbBaby.setQizhi(baby.getQizhi());
        dbBaby.setNeili(baby.getNeili());
        dbBaby.setZhili(baby.getZhili());
        dbBaby.setNaili(baby.getNaili());
        dbBaby.setMingqi(baby.getMingqi());
        dbBaby.setDaode(baby.getDaode());
        dbBaby.setPanni(baby.getPanni());
        dbBaby.setWanxing(baby.getWanxing());
        dbBaby.setQingmi(baby.getQingmi());
        dbBaby.setXiaoxin(baby.getXiaoxin());
        dbBaby.setWenbao(baby.getWenbao());
        dbBaby.setBabyage(baby.getBabyage());
        dbBaby.setOutcome(baby.getOutcome());
        dbBaby.setQingmi(baby.getQingmi());
        dbBaby.setNaili(baby.getNaili());
        AllServiceUtil.getBabyService().updateBaby(dbBaby);
        if (loginResult != null) {
            ChannelHandlerContext channelHandlerContext = GameServer.getRoleNameMap().get(loginResult.getRolename());
            if (channelHandlerContext != null) {
                AssetUpdate update = new AssetUpdate();
                // 添加返回bean
                List<Baby> babies = new ArrayList<>();
                babies.add(dbBaby);
                update.setBabys(babies);
                update.setType(AssetUpdate.USEGOOD);
                update.setMsg(":#R多功能后台修改孩子成功#23");
                // 发送前端取回的东西
                SendMessage.sendMessageToSlef(channelHandlerContext, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(update)));
            }
        }
        return ResultFactory.success(null);
    }

    @UserToken
    @PostMapping(value = "/api/updUserMount")
    public Result updUserMount(Mount mount) {
        LoginResult loginResult = AllServiceUtil.getRoleTableService().selectRoleByRoleId(mount.getRoleid());
        if (loginResult == null)
            return ResultFactory.fail("角色不存在！");

        Mount dbMount = AllServiceUtil.getMountService().selectMountsByMID(mount.getMid());
        dbMount.setExp(mount.getExp());
        dbMount.setMountlvl(mount.getMountlvl());
        dbMount.setPower(mount.getPower());
        dbMount.setBone(mount.getBone());
        dbMount.setSpri(mount.getSpri());
        dbMount.setLive(mount.getLive());
        dbMount.setProficiency(mount.getProficiency());
        AllServiceUtil.getMountService().updateMount(dbMount);
        if (loginResult != null) {
            ChannelHandlerContext channelHandlerContext = GameServer.getRoleNameMap().get(loginResult.getRolename());
            if (channelHandlerContext != null) {
                AssetUpdate update = new AssetUpdate();
                // 添加返回bean
                List<Mount> mounts = new ArrayList<>();
                mounts.add(dbMount);
                update.setMounts(mounts);
                update.setType(AssetUpdate.USEGOOD);
                update.setMsg(":#R多功能后台修改坐骑成功#23");
                // 发送前端取回的东西
                SendMessage.sendMessageToSlef(channelHandlerContext, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(update)));
            }
        }
        return ResultFactory.success(null);
    }


    @UserToken
    @PostMapping(value = "/api/updUserPet")
    public Result updUserPet(UpPetParam param) {

        RoleSummoning roleSummoning = AllServiceUtil.getRoleSummoningService().selectRoleSummoningsByRgID(new BigDecimal(param.getSid()));
        if (roleSummoning == null) {
            return ResultFactory.fail("未找到对应的召唤兽！");
        }
        RoleSummoning pet = GameServer.getPet(new BigDecimal(roleSummoning.getSummoningid()));
        roleSummoning.setTurnRount(param.getTurnRount());
        roleSummoning.setGrowlevel(pet.getGrowlevel());
        for (int i = 0; i < param.getTurnRount(); i++) {
            BigDecimal grow = mathDouble(Double.parseDouble(roleSummoning.getGrowlevel()), 0.1);
            roleSummoning.setGrowlevel(Arith.xiaoshu3(grow.doubleValue()));
        }

        Integer petLvl = getPetLvl(param.getTurnRount());
        roleSummoning.setFriendliness(param.getFriendliness());
        roleSummoning.setGrade(param.getGrade() + petLvl + 1);
        roleSummoning.setOpenSeal(param.getOpenSeal());
        roleSummoning.setBone(param.getGrade());
        roleSummoning.setSpir(param.getGrade());
        roleSummoning.setPower(param.getGrade());
        roleSummoning.setSpeed(param.getGrade());
        List<Goodstable> eqGoods = null;
        LoginResult loginResult = AllServiceUtil.getRoleTableService().selectRoleByRoleId(roleSummoning.getRoleid());

        if (StringUtils.isNotBlank(param.getSkill())) {

            if (StringUtils.isNotBlank(roleSummoning.getStye())) {
                eqGoods = new ArrayList<>();
                String[] v = roleSummoning.getStye().split("\\|");
                for (int i = 1; i < v.length; i++) {
                    String[] vs = v[i].split("-");
                    if (vs.length >= 2) {
                        Goodstable good = AllServiceUtil.getGoodsTableService().getGoodsByRgID(new BigDecimal(vs[1]));
                        eqGoods.add(good);
                    }
                }
            }

            for (Goodstable eqGood : eqGoods) {
                String[] val = eqGood.getValue().split("\\|");
                int index = -1;
                for (int i = 0; i < val.length; i++) {
                    if (val[i].startsWith("觉醒技")) {
                        index = i;
                        break;
                    }
                }
                String jxSkill = "";
                if (index != -1) {
                    String[] split = val[index].split("&");
                    split[1] = param.getSkill();
                    jxSkill = ArrayUtil.join(split, "&");
                }
                val[index] = jxSkill;
                eqGood.setValue(ArrayUtil.join(val, "|"));
                AllServiceUtil.getGoodsTableService().updateGoodRedis(eqGood);
                if (loginResult != null) {
                    ChannelHandlerContext channelHandlerContext = GameServer.getRoleNameMap().get(loginResult.getRolename());
                    if (channelHandlerContext != null) {
                        AssetUpdate update = new AssetUpdate();
                        // 添加返回bean
                        List<Goodstable> goodstables = new ArrayList<>();
                        goodstables.add(eqGood);
                        update.setGoods(goodstables);
                        update.setType(AssetUpdate.GIVE);
                        update.setMsg(":#R多功能后台修改物品修改成功#23");
                        // 发送前端取回的东西
                        SendMessage.sendMessageToSlef(channelHandlerContext, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(update)));
                    }
                }
            }
        }
        AssetUpdate update = new AssetUpdate();

        if (param.getLx() != null) {
            roleSummoning.setLingxi(getLx(param.getLx() - 1));
        }

        List<Goodstable> goodstables = new ArrayList<>();
        if (StringUtils.isNotBlank(param.getNds())) {
            String[] split = param.getNds().split("\\|");
            for (String nd : split) {
                GameServer.getAllGoodsMap().forEach((k, v) -> {
                    if (v.getGoodsname().equals(nd)) {
                        nds.put(nd, v);
                    }
                });
            }
            //原来的内丹删掉
            if (StringUtils.isNotBlank(roleSummoning.getInnerGoods())) {
                for (String s : roleSummoning.getInnerGoods().split("\\|")) {
                    Goodstable dbGood = AllServiceUtil.getGoodsTableService().getGoodsByRgID(new BigDecimal(s));
                    dbGood.goodxh(1);
                    AllServiceUtil.getGoodsTableService().updateGoodRedis(dbGood);
                    goodstables.add(dbGood);
                }
            }
            String[] ndIds = new String[split.length];
            //替换新的内丹
            for (int i = 0; i < split.length; i++) {
                Goodstable goodstable = nds.get(split[i]);
                String[] split1 = goodstable.getValue().split("\\|");
                split1[2] = "内丹等级=4转180";
                goodstable.setValue(ArrayUtil.join(split1, "|"));

                goodstable.setUsetime(1);
                goodstable.setRole_id(loginResult.getRole_id());
                goodstable.setStatus(1);
                AllServiceUtil.getGoodsTableService().insertGoods(goodstable);
                ndIds[i] = goodstable.getRgid().toString();
                goodstables.add(goodstable);
            }
            String join = ArrayUtil.join(ndIds, "|");
            roleSummoning.setInnerGoods(join);
            update.setGoods(goodstables);

        }


        AllServiceUtil.getRoleSummoningService().updateRoleSummoning(roleSummoning);
        if (loginResult != null) {
            ChannelHandlerContext channelHandlerContext = GameServer.getRoleNameMap().get(loginResult.getRolename());
            if (channelHandlerContext != null) {
                // 添加返回bean
                List<RoleSummoning> roleSummonings = new ArrayList<>();

                roleSummonings.add(roleSummoning);
                update.setPets(roleSummonings);
                update.setType(AssetUpdate.USEGOOD);
                update.setMsg(":#R多功能后台修改宠物成功#23");
                // 发送前端取回的东西
                SendMessage.sendMessageToSlef(channelHandlerContext, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(update)));
            }
        }
        return ResultFactory.success(null);
    }


    /**
     * 召唤兽转生 点化
     */
    /**
     * 召唤兽转生 点化
     */
    public void DHPet(RoleSummoning pet) {
        int petTurn = pet.getTurnRount();
        int lvl = pet.getGrade();
        lvl++;
        petTurn++;

        //设置这只召唤兽的根骨、灵性、力量、敏捷、经验为0
        pet.setBone(0);
        pet.setSpir(0);
        pet.setPower(0);
        pet.setSpeed(0);
        pet.setCalm(0);
        pet.setExp(new BigDecimal(0));
        //等级
        pet.setGrade(lvl);
        pet.setTurnRount(petTurn);
        //设置忠诚度为100
        pet.setFaithful(100);
        //成长率加0.1
        BigDecimal grow = mathDouble(Double.parseDouble(pet.getGrowlevel()), 0.1);
        pet.setGrowlevel(Arith.xiaoshu3(grow.doubleValue()));

        pet.setBasishp(0);
        pet.setBasismp(0);
        AllServiceUtil.getRoleSummoningService().updatePetRedis(pet);
    }

    private String getLx(Integer type) {
        String lx = "";
        if (type == 0) {
            lx = "11001_0|11002_0|11003_0|11004_0|11005_0|11006_0|11007_0|11026_0|11045_0|11046_0" + "|11008_0" + "|11009_0" + "|11010_0" + "|11011_0" + "|11012_0" + "|11013_0" + "|11014_0" + "|11015_0" + "|11016_0" + "|11017_0" + "|11018_0" + "|11019_0" + "|11020_0" + "|11021_0" + "|11022_0" + "|11023_0" + "|11024_0" + "|11025_0" + "|11047_0" + "|11049_0" + "|11051_0" + "|11053_0" + "|11055_0" + "|11057_0" + "|11062_0" + "|11063_0" + "|11061_0" + "|11060_0" + "|11058_0" + "|11059_0" + "|11056_0" + "|11054_0" + "|11052_0" + "|11050_0" + "|11048_0" + "|11027_0" + "|11028_0" + "|11029_0" + "|11031_0" + "|11032_0" + "|11033_0" + "|11034_0" + "|11035_0" + "|11036_0" + "|11030_0" + "|11037_0" + "|11042_0" + "|11039_0" + "|11043_0" + "|11044_0" + "|11040_0" + "|11041_0";
        } else if (type == 1) {
            lx = "11003_0|11001_0|11004_0|11005_0|11006_0|11007_0|11008_0|11009_0|11010_0|11011_0|11012_0|11013_0|11016_0|11018_0|11013_0|11015_0|11017_0|11019_0|11020_0|11020_0|11021_0|11022_0|11023_0|11024_0|11025_0";
        } else if (type == 2) {
            lx = "11001_0|11004_0|11002_0|11005_0|11007_0|11026_0|11027_0|11028_0|11029_0|11031_0|11033_0|11035_0|11036_0|11032_0|11034_0|11030_0|11037_0|11039_0|11040_0|11041_0|11042_0|11043_0|11044_0";
        } else if (type == 3) {
            lx = "11001_0|11004_0|11002_0|11005_0|11046_0|11047_0|11048_0|11049_0|11050_0|11052_0|11054_0|11056_0|11051_0|11053_0|11055_0|11057_0|11058_0|11059_0|11060_0|11061_0|11062_0|11063_0";
        }
        String[] lhHead = {"Lx=0", "Lv=0", "Point=0", "Open="};
        String[] skillIds = lx.split("\\|");
        String[] lxs = new String[skillIds.length];
        int count = 0;
        for (int i = 0; i < skillIds.length; i++) {
            Skill skill = GameServer.getSkill(skillIds[i].split("_")[0]);
            lxs[i] = skill.getSkillid() + "_" + (int) (skill.getValue());
            count += (int) (skill.getValue());
        }
        lhHead[2] = "Point=" + count;
        lhHead[0] = "Lx=" + type;
        String join = ArrayUtil.join(lxs, "|");
        String join1 = ArrayUtil.join(lhHead, "&");
        return join1 + join;
    }

    public Integer getPetLvl(int zs) {
        if (zs == 1) {
            return 100;
        } else if (zs == 2) {
            return 221;
        } else if (zs == 3) {
            return 362;
        } else if (zs == 4) {
            return 543;
        } else if (zs == 0) {
            return 0;
        }
        return 0;
    }


    @UserToken
    @PostMapping(value = "/api/updUserGood")
    public Result updUserGood(Goodstable goodstable) {
        GoodsService service = new GoodsService();
        Goodstable dbGoods = AllServiceUtil.getGoodsTableService().getGoodsByRgID(goodstable.getRgid());
        if (dbGoods != null) {
            dbGoods.setValue(goodstable.getValue());
            AllServiceUtil.getGoodsTableService().updateGoodRedis(dbGoods);
            LoginResult loginResult = AllServiceUtil.getRoleTableService().selectRoleByRoleId(dbGoods.getRole_id());
            if (loginResult != null) {
                ChannelHandlerContext channelHandlerContext = GameServer.getRoleNameMap().get(loginResult.getRolename());
                if (channelHandlerContext != null) {
                    AssetUpdate update = new AssetUpdate();
                    // 添加返回bean
                    List<Goodstable> goodstables = new ArrayList<>();
                    goodstables.add(dbGoods);
                    update.setGoods(goodstables);
                    update.setType(AssetUpdate.GIVE);
                    update.setMsg(":#R多功能后台修改物品修改成功#23");
                    // 发送前端取回的东西
                    SendMessage.sendMessageToSlef(channelHandlerContext, Agreement.getAgreement().assetAgreement(GsonUtil.getGsonUtil().getgson().toJson(update)));
                }
            }
        }


        return ResultFactory.success("111111111");
    }

    public BackRoleInfo getRole(Param param) {

        String type = param.getValue1();
        String value = param.getValue2();

        int pageNum = param.getPageNum();
        int status = param.getStatus();
        int size = param.getPageSize();

        if (size < 10) {
            size = PageSize;
        }

        BackRoleInfo list = null;

        RoleTable roleTable = new RoleTable();
        if (StringUtils.isNotBlank(param.getValue3()))
            roleTable.setQid(new BigDecimal(param.getValue3()));
        else
            roleTable.setQid(null);
        roleTable.setStart((pageNum - 1) * size);
        roleTable.setEnd(pageNum * size);


        switch (status) {
            case 3:
                roleTable.setUnknown("1");
                break;
            case 4:
                roleTable.setActivity(new Short(1 + ""));
                break;
            case 5:
                roleTable.setActivity(new Short(0 + ""));
                break;
            default:
                roleTable.setActivity(null);
                break;
        }
        if (com.github.pagehelper.util.StringUtil.isNotEmpty(type) && !"undefined".equals(type) && com.github.pagehelper.util.StringUtil.isNotEmpty(value) && !"undefined".equals(value)) {
            //设置角色名
            if (type.equals("1") && NumberUtils.isDigits(value)) {
                roleTable.setRole_id(new BigDecimal(value));
            } else if (type.equals("2")) {
                roleTable.setRolename(value);
            } else if (type.equals("3")) {
                roleTable.setLocalname(value);
            }
        }

        //查询总区域得玩家信息
        int total = AllServiceUtil.getUserTableService().selectSumForRoleUserHaterNumber(roleTable);
        //总页数
        int page = total / size;
        if (total % size > 0) {
            page++;
        }
        roleTable.setUserString(" Order By role_id ASC");
        //查询状态下的角色
        List<RoleTable> listall = AllServiceUtil.getUserTableService().selectSumForRoleUserHaterList(roleTable);

        list = new BackRoleInfo();
        //进行状态实例化
        for (RoleTable roleInfo : listall) {
            if (org.apache.commons.lang.StringUtils.isBlank(roleInfo.getRolename())) {
                continue;
            }
            // 玩家状态1、在线 2、下线 3、禁言 4、封号5、未封号  6、未禁言
            if (GameServer.getRoleNameMap().get(roleInfo.getRolename()) != null) {
                roleInfo.setStatues("在线");
            } else {
                roleInfo.setStatues("离线");
            }
            roleInfo.setUnknown(StringUtil.isEmpty(roleInfo.getUnknown()) ? "0" : roleInfo.getUnknown());
            // 清空密码，不将用户密码传到前端
            roleInfo.setPassword(null);
        }


        list.setList(listall);
        list.setPages(page);
        list.setPageNum(pageNum);
        list.setTotal(total);
        return list;
    }



    /**
     * 充值	类型 1仙玉充值 2周月卡充值 3小资冲级礼包充值 4土豪冲级礼包字段
     *
     * @param param
     * @return
     */
    public boolean agentRechargeCallBack(Param param, Agent agent) {
        // 用户ID
        String user_id = param.getValue1();

        // 金额/VIP天数
        String recharge = param.getValue2();

        // 仙玉
        String yuanbao = param.getValue3();

        // 赠送抽奖次数
        String count = param.getValue4();

        // 充值类型
        String saveType = param.getValue5();

        if (StringUtil.isEmpty(saveType)) {
            return false;
        }

        int type = Integer.parseInt(saveType);

        if (StringUtil.isEmpty(user_id)) {
            return false;
        }

        if (StringUtil.isEmpty(yuanbao)) {
            yuanbao = "0";
        }

        BigDecimal userId = new BigDecimal(user_id);

        UserTable userTable = AllServiceUtil.getUserTableService().selectByPrimaryKey(userId);

        Random r = new Random(System.currentTimeMillis());
        ExpensesReceipts expensesReceipts = new ExpensesReceipts();
        expensesReceipts.setErid(new BigDecimal(System.currentTimeMillis() + "" + r.nextInt(9999)));
        expensesReceipts.setPlayeracc(userTable.getUsername());
        expensesReceipts.setSid(userTable.getQid());
        expensesReceipts.setRecharge(new BigDecimal(recharge));
        expensesReceipts.setYuanbao(new BigDecimal(yuanbao));
        expensesReceipts.setType(type);
        expensesReceipts.setManagerid(new BigDecimal(agent.getAgentId()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 8);
        expensesReceipts.setPaytime(DateUtil.formatDate(calendar.getTime(), "yyyy-MM-dd HH:mm:ss"));

        Jedis jedis = RedisPoolUntil.getJedis();

        try {
            ApplyBean applyBean = new ApplyBean();
            applyBean.setUserNameS(expensesReceipts.getPlayeracc());// 充值的帐户名
            applyBean.setRealmoney(expensesReceipts.getRecharge() + "");// 实际充值金额
            BigDecimal addC = new BigDecimal(applyBean.getRealmoney());
            // 支付类型 1仙玉充值 2周月卡充值 3小资冲级礼包充值 4土豪冲级礼包字段

            userTable.setPayintegration(userTable.getPayintegration() + addC.intValue());
            ChannelHandlerContext ctx = GameServer.getInlineUserNameMap().get(applyBean.getUserNameS());
            LoginResult login = ctx != null ? GameServer.getAllLoginRole().get(ctx) : null;
            if (login != null) {// 在线充值
                AllServiceUtil.getUserTableService().updateUser(userTable);
                login.setPaysum(login.getPaysum().add(addC));// 累计充值
                login.setDaypaysum(login.getDaypaysum().add(addC));// 每日累计充值
                if (StringUtil.isNotEmpty(count) && !"undefined".equals(count)) {
                    LaborScene.addRankValue(0, Integer.parseInt(count) * 10, login);//劳动节活动
                }
                ApplyPayBean applyPayBean = new ApplyPayBean();
                applyPayBean.setAddM(addC);
                expensesReceipts.setRoleid(login.getRole_id());
                expensesReceipts.setBuyroleName(login.getRolename());
                RoleData roleData = RolePool.getRoleData(login.getRole_id());
                PayvipBean vipBean = GameServer.getVIP(login.getPaysum().longValue());
                if (vipBean != null && roleData != null) {
                    UseCardBean limit = roleData.getLimit("SVIP");
                    if (limit == null) {
                        limit = new UseCardBean("VIP" + vipBean.getGrade(), "SVIP", "S" + (19 + vipBean.getGrade()), -1, vipBean.getIncreationtext());
                        roleData.addLimit(limit);
                        applyPayBean.setVIPBean(limit);
                    } else if (!limit.getName().equals("VIP" + vipBean.getGrade())) {
                        limit.setName("VIP" + vipBean.getGrade());
                        limit.setSkin("S" + (19 + vipBean.getGrade()));
                        limit.setValue(vipBean.getIncreationtext());
                        applyPayBean.setVIPBean(limit);
                    }
                }
                if (type == 2) {
                    long time = 1000L * 60L * 60L * 24L * 30;
                    if (time != 0 && roleData != null) {
                        UseCardBean limit = roleData.getLimit("VIP");
                        if (limit != null) {
                            limit.setTime(limit.getTime() + time);
                        } else {
                            limit = new UseCardBean("VIP", "VIP", "1", System.currentTimeMillis() + time, "掉落率=1|经验加成=5|加强全系法术=5|召唤兽死亡不掉忠诚,血法|人物死亡惩罚减半");
                            roleData.addLimit(limit);
                        }
                        applyPayBean.setUseCardBean(limit);
                        applyPayBean.setMsg("激活了" + (time / 1000 / 60 / 60 / 24) + "天VIP特权");
                    }
                } else if (type == 3 && login.getLowOrHihtpack() == 0) {
                    login.setLowOrHihtpack(1);
                    applyPayBean.setLowOrHihtpack(new BigDecimal(1));
                    applyPayBean.setMsg("开通了小资冲级礼包");
                } else if (type == 4 && login.getLowOrHihtpack() == 0) {
                    login.setLowOrHihtpack(2);
                    applyPayBean.setLowOrHihtpack(new BigDecimal(2));
                    applyPayBean.setMsg("开通了土豪冲级礼包");
                } else {
                    applyBean.setPaymoney(expensesReceipts.getYuanbao() + "");// 充值的元宝数量
                    login.setCodecard(login.getCodecard().add(new BigDecimal(applyBean.getPaymoney())));
                    MonitorUtil.getMoney().addX(new BigDecimal(applyBean.getPaymoney()).longValue(), 0);
                    MonitorUtil.getMoney().addC(addC.longValue());
                    login.setMoney((login.getMoney() != null ? login.getMoney() : 0) + addC.intValue());
                    applyPayBean.setAddX(new BigDecimal(applyBean.getPaymoney()));
                    applyPayBean.setAddC(addC);
                    if (addC.longValue() >= 30 && login.getDayfirstinorno() == 0) {// 在线充值
                        // 添加连充天数
                        login.setDayandpayorno(login.getDayandpayorno().add(new BigDecimal(1)));
                        login.setDayfirstinorno(1);
                        applyPayBean.setDayandpayorno(login.getDayandpayorno());
                    }
                    StringBuffer buffer = new StringBuffer();
                    if (type == 3 || type == 4) {
                        buffer.append("小资冲级礼包和土豪冲级礼包只能同时拥有一个,你已经有了");
                        buffer.append(login.getLowOrHihtpack() == 2 ? "土豪冲级礼包" : "小资冲级礼包");
                        buffer.append("本次充值变为正常仙玉充值.");
                    }
                    buffer.append("你充值积分:");
                    buffer.append(addC.intValue());
                    buffer.append(",获得仙玉:");
                    buffer.append(applyBean.getPaymoney());
                    applyPayBean.setMsg(buffer.toString());
                }
                // 在线也要同步数据库
                AllServiceUtil.getRoleTableService().updateRoleWhenExit(login);
                SendMessage.sendMessageToSlef(ctx, Agreement.getAgreement().applyPay(GsonUtil.getGsonUtil().getgson().toJson(applyPayBean)));
                // 确保第一次处理订单(确保充值成功)
                jedis.hset("order_number_control_orno", expensesReceipts.getErid() + "", expensesReceipts.getPaytime() + ":金额" + expensesReceipts.getRecharge());
                jedis.hset("payReturnForpayServer", expensesReceipts.getErid() + "", "Sinmahod" + "=" + GsonUtil.getGsonUtil().getgson().toJson(expensesReceipts) + "");
            } else {// 不在线充值
                if (expensesReceipts.getRoleid() != null) {
                    login = AllServiceUtil.getRoleTableService().selectRoleID(expensesReceipts.getRoleid());
                } else {
                    List<LoginResult> loginResults = AllServiceUtil.getUserTableService().findRoleByUserNameAndPassword(applyBean.getUserNameS(), null, null);
                    if (loginResults.size() != 0) {
                        login = loginResults.get(0);
                    }
                }
                if (login != null) {
                    login.setPaysum(login.getPaysum().add(addC));// 累计充值
                    login.setDaypaysum(login.getDaypaysum().add(addC));// 每日累计充值
                    if (StringUtil.isNotEmpty(count) && !"undefined".equals(count)) {
                        LaborScene.addRankValue(0, Integer.parseInt(count) * 10, login);//劳动节活动
                    }
                    expensesReceipts.setRoleid(login.getRole_id());
                    expensesReceipts.setBuyroleName(login.getRolename());
                    if (type == 2) {
                        long time = 1000L * 60L * 60L * expensesReceipts.getRecharge().intValue();
                        PrivateData privateData = new PrivateData();
                        privateData.setTimingGood(login.getTimingGood());
                        ConcurrentHashMap<String, UseCardBean> limitMap = privateData.initLimit(0);
                        UseCardBean limit = limitMap.get("VIP");
                        if (limit != null) {
                            limit.setTime(limit.getTime() + time);
                        } else {
                            limit = new UseCardBean("VIP", "VIP", "1", System.currentTimeMillis() + time, "掉落率=1|经验加成=5|加强全系法术=5|召唤兽死亡不掉忠诚,血法|人物死亡惩罚减半");
                            limitMap.put("VIP", limit);
                        }
                        StringBuffer buffer = new StringBuffer();
                        for (UseCardBean cardBean : limitMap.values()) {
                            if (buffer.length() != 0) {
                                buffer.append("^");
                            }
                            buffer.append(cardBean.getName());
                            buffer.append("#");
                            buffer.append(cardBean.getType());
                            buffer.append("#");
                            buffer.append(cardBean.getSkin());
                            buffer.append("#");
                            buffer.append(cardBean.getTime() / 60000);
                            if (cardBean.getValue() != null && !cardBean.getValue().equals("")) {
                                buffer.append("#");
                                buffer.append(cardBean.getValue());
                            }
                        }
                        login.setTimingGood(buffer.toString());
                    } else if (type == 3 && login.getLowOrHihtpack() == 0) {
                        login.setLowOrHihtpack(1);
                    } else if (type == 4 && login.getLowOrHihtpack() == 0) {
                        login.setLowOrHihtpack(2);
                    } else {
                        applyBean.setPaymoney(expensesReceipts.getYuanbao() + "");// 充值的元宝数量
                        userTable.setCodecard(userTable.getCodecard().add(new BigDecimal(applyBean.getPaymoney())));
                        userTable.setMoney(userTable.getMoney() + addC.intValue());
                        MonitorUtil.getMoney().addX(new BigDecimal(applyBean.getPaymoney()).longValue(), 0);
                        MonitorUtil.getMoney().addC(addC.longValue());
                        if (addC.longValue() >= 30 && login.getDayfirstinorno() == 0) {// 在线充值
                            // 添加连充天数
                            login.setDayandpayorno(login.getDayandpayorno().add(new BigDecimal(1)));
                            login.setDayfirstinorno(1);
                        }
                    }
                    try {
                        AllServiceUtil.getRoleTableService().updateRoleWhenExit(login);
                    } catch (Exception e) {
                        WriteOut.addtxt("人物数据保存报错:" + GsonUtil.getGsonUtil().getgson().toJson(login), 9999);
                    }
                } else {
                    userTable.setCodecard(userTable.getCodecard().add(new BigDecimal(applyBean.getPaymoney())));
                    userTable.setMoney(userTable.getMoney() + addC.intValue());
                    MonitorUtil.getMoney().addX(new BigDecimal(applyBean.getPaymoney()).longValue(), 0);
                    MonitorUtil.getMoney().addC(addC.longValue());
                }
                AllServiceUtil.getUserTableService().updateUser(userTable);
                jedis.hset("order_number_control_orno", expensesReceipts.getErid() + "", expensesReceipts.getPaytime() + ":金额" + expensesReceipts.getRecharge());
            }
        } catch (Exception e) {
            e.printStackTrace();
            WriteOut.addtxt("充值报错:" + MainServerHandler.getErrorMessage(e), 9999);
        }
        RedisPoolUntil.returnResource(jedis);
        //充值日志
        AllServiceUtil.getRecordService().insert(new Record(8, GsonUtil.getGsonUtil().getgson().toJson(expensesReceipts)));
        AllServiceUtil.getExpensesReceiptsService().insert1(expensesReceipts);
        return true;
    }


}