/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 */
package org.come.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.come.annotation.MyBatisAnnotation;
import org.come.entity.Goodsexchange;
import org.come.entity.GoodsexchangeExample;

@MyBatisAnnotation
public interface GoodsexchangeMapper {
    public int countByExample(GoodsexchangeExample var1);

    public int deleteByExample(GoodsexchangeExample var1);

    public int deleteByPrimaryKey(String var1);

    public int insert(Goodsexchange var1);

    public int insertSelective(Goodsexchange var1);

    public List<Goodsexchange> selectByExample(GoodsexchangeExample var1);

    public Goodsexchange selectByPrimaryKey(String var1);

    public int updateByExampleSelective(@Param(value="record") Goodsexchange var1, @Param(value="example") GoodsexchangeExample var2);

    public int updateByExample(@Param(value="record") Goodsexchange var1, @Param(value="example") GoodsexchangeExample var2);

    public int updateByPrimaryKeySelective(Goodsexchange var1);

    public int updateByPrimaryKey(Goodsexchange var1);

    public List<Goodsexchange> selectListAll();
}

