package org.come.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.come.entity.Fly;
import org.come.entity.FlyRoleUser;
import org.come.entity.FlySkill;
import org.come.mapper.FlyMapper;
import org.come.redis.RedisCacheUtil;
import org.come.redis.RedisControl;
import org.come.redis.RedisParameterUtil;
import org.come.service.IFlyService;
import org.come.until.MybatisUntil;
import org.springframework.context.ApplicationContext;

import come.tool.Role.RoleData;
import come.tool.Role.RolePool;

public class FlyServiceImpl implements IFlyService {
    private FlyMapper flyMapper;

    public FlyServiceImpl() {

        ApplicationContext ctx = MybatisUntil.getApplicationContext();
        // id为类名且首字母小写才能被自动扫描扫到
        flyMapper = (FlyMapper) ctx.getBean("flyMapper");

    }
    /**根据角色ID查找角色飞行器*/
@Override
    public List<Fly> selectFlysByRoleID( BigDecimal roleID ) {
        List<Fly> flys = RedisControl.getS(RedisParameterUtil.FLY, roleID.toString(), Fly.class);
        return flys;
    }
    /**查找角色飞行器*/
@Override
    public Fly selectFlysByMID(BigDecimal mid) {
        Fly fly=RedisControl.getV(RedisParameterUtil.FLY, mid.toString(), Fly.class);
        return fly;
    }
    /**删除角色飞行器*/
    @Override
    public void deleteFlysByMid(BigDecimal roleID) {
        Fly fly=RedisControl.getV(RedisParameterUtil.FLY,roleID.toString(), Fly.class);
        if (fly!=null) {
            // 删除角色下的飞行器
            RedisControl.deletrValue(RedisParameterUtil.FLY, fly.getRoleid().toString(), fly.getMid().toString());
            // 删除数据表中的数据
            RedisControl.delForKey(RedisParameterUtil.FLY, fly.getMid().toString());
            // 加入操作表
            RedisControl.insertController(RedisParameterUtil.FLY, fly.getMid().toString(), RedisControl.CDELETE);
            RoleData data=RolePool.getRoleData(fly.getRoleid());

        }
    }
    /**修改飞行器属性*/
    @Override
    public void updateFly(Fly fly) {
        Fly fly2=RedisControl.getV(RedisParameterUtil.FLY, fly.getMid().toString(), Fly.class);
        if (fly2!=null) {
            RedisControl.insertKeyT(RedisParameterUtil.FLY, fly2.getMid().toString(),fly2);
            // 加入操作表
            RedisControl.insertController(RedisParameterUtil.FLY, fly2.getMid().toString(), 2+"");
        }
    }
    @Override
    public void updateFlyRedis(Fly fly) {
        // TODO Auto-generated method stub
        RedisControl.insertKeyT(RedisParameterUtil.FLY, fly.getMid().toString(), fly);
        // 加入操作表
        RedisControl.insertController(RedisParameterUtil.FLY, fly.getMid().toString(), 2+"");
    }
    /**添加飞行器*/
    @Override
    public void insertFly(Fly fly) {
        fly.setMid(RedisCacheUtil.getFly_pk());
        fly.setExp(0);
       // fly.setSkin("shanzi1");

      //  List<FlySkill> flyskill=new ArrayList<>();

        RedisControl.insertKeyT(RedisParameterUtil.FLY, fly.getMid().toString(),fly);
        // 插入人物飞行器
        RedisControl.insertListRedis(RedisParameterUtil.FLY, fly.getRoleid().toString(), fly.getMid().toString());
        // 加入操作表
        RedisControl.insertController(RedisParameterUtil.FLY, fly.getMid().toString(), 1+"");
    }

    // 查找所有飞行器
    @Override
    public List<Fly> selectAllFlys() {
        return flyMapper.selectAllFlys();
    }
    @Override
    public BigDecimal selectMaxID() {
        return flyMapper.selectMaxID();
    }
    @Override
    public void deleteFlysByMidsql(BigDecimal roleID) {
        // TODO Auto-generated method stub
        flyMapper.deleteFlysByMid(roleID);
    }
    @Override
    public void updateFlysql(Fly fly) {
        // TODO Auto-generated method stub
        flyMapper.updateFly(fly);
    }
    @Override
    public void insertFlysql(Fly fly) {
        // TODO Auto-generated method stub
        flyMapper.insertFly(fly);
    }

    private final Integer limit = 10;

    @Override
    public List<FlyRoleUser> selectFly(FlyRoleUser mru) {
        // TODO Auto-generated method stub
        Integer start = ((mru.getPageNum() - 1) * limit) + 1;
        Integer end = start + limit;
        mru.setStart(start);
        mru.setEnd(end);
        List<FlyRoleUser> flyList = flyMapper.selectFly(mru);
        return flyList;
    }

    @Override
    public Integer selectFlyCount(FlyRoleUser mru) {
        // TODO Auto-generated method stub
        Integer flyCount = flyMapper.selectFlyCount(mru);
        return flyCount;
    }

    @Override
    public void deleteFlysByMidList(List<BigDecimal> roleID) {
        // TODO Auto-generated method stub
        flyMapper.deleteFlysByMidList(roleID);

    }
    @Override

    public void updateFlyList(List<Fly> fly) {
        // TODO Auto-generated method stub
        flyMapper.updateFlyList(fly);

    }

    @Override
    public void insertFlyList(List<Fly> fly) {
        // TODO Auto-generated method stub
        flyMapper.insertFlyList(fly);
    }

    @Override
    public void insertFlySingle(Fly fly) {
        // TODO Auto-generated method stub
        flyMapper.insertFlySingle(fly);
    }
}
