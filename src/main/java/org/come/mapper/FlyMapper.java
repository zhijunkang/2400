package org.come.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.come.annotation.MyBatisAnnotation;
import org.come.entity.Fly;
import org.come.entity.FlyRoleUser;

/**
 * 飞行器
 *
 * @author 叶豪芳
 * @date : 2017年12月2日 下午3:46:48
 */
@MyBatisAnnotation
public interface FlyMapper {

    // 查找所有飞行器
    List<Fly> selectAllFlys();

    /**
     * 查找角色所有飞行器
     */
    List<Fly> selectFlysByRoleID(BigDecimal roleID);

    /**
     * 查找角色飞行器
     */
    Fly selectFlysByMID(BigDecimal mid);

    /**
     * 删除角色飞行器
     */
    void deleteFlysByMid(BigDecimal roleID);

    /**
     * 修改飞行器属性
     *
     * @param fly
     */
    void updateFly(Fly fly);

    /**
     * 添加飞行器
     *
     * @param fly
     */
    void insertFly(Fly fly);

    BigDecimal selectMaxID();


    List<FlyRoleUser> selectFly(@Param("mru") FlyRoleUser mru);

    Integer selectFlyCount(@Param("mru") FlyRoleUser mru);


    /** HGC-2020-01-20 */
    /**
     * 删除角色飞行器
     */
    void deleteFlysByMidList(List<BigDecimal> roleID);

    /**
     * 修改飞行器属性
     */
    void updateFlyList(List<Fly> fly);

    /**
     * 添加飞行器
     */
    void insertFlyList(List<Fly> fly);

    /**
     * 单条插入
     */
    void insertFlySingle(Fly fly);

}