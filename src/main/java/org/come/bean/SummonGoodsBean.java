// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SummonGoodsBean.java

package org.come.bean;

import java.math.BigDecimal;

public class SummonGoodsBean
{

    public SummonGoodsBean()
    {
    }

    public int getOpertype()
    {
        return this.opertype;
    }

    public void setOpertype(int opertype)
    {
        this.opertype = opertype;
    }

    public BigDecimal getGoodsid()
    {
        return this.goodsid;
    }

    public void setGoodsid(BigDecimal goodsid)
    {
        this.goodsid = goodsid;
    }

    public BigDecimal getGoodid()
    {
        return this.goodid;
    }

    public void setGoodid(BigDecimal goodid)
    {
        this.goodid = goodid;
    }

    private int opertype;
    private BigDecimal goodsid;
    private BigDecimal goodid;
}
