/*
 * Decompiled with CFR 0.150.
 */
package org.come.service;

import java.util.List;
import org.come.entity.Goodsexchange;
import org.come.entity.GoodsexchangeExample;

public interface IGoodsExchangeService {
    public int countByExample(GoodsexchangeExample var1);

    public int deleteByExample(GoodsexchangeExample var1);

    public int deleteByPrimaryKey(String var1);

    public int insert(Goodsexchange var1);

    public int insertSelective(Goodsexchange var1);

    public List<Goodsexchange> selectByExample(GoodsexchangeExample var1);

    public Goodsexchange selectByPrimaryKey(String var1);

    public int updateByExampleSelective(Goodsexchange var1, GoodsexchangeExample var2);

    public int updateByExample(Goodsexchange var1, GoodsexchangeExample var2);

    public int updateByPrimaryKeySelective(Goodsexchange var1);

    public int updateByPrimaryKey(Goodsexchange var1);

    public List<Goodsexchange> selectListAll();
}

