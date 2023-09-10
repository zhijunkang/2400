/*
 * Decompiled with CFR 0.150.
 */
package org.come.readBean;

import java.util.concurrent.ConcurrentHashMap;
import org.come.model.GoodsExchange;

public class allGoodsExchange {
    private ConcurrentHashMap<Integer, GoodsExchange> allGoodsExchange;

    public ConcurrentHashMap<Integer, GoodsExchange> getAllGoodsExchange() {
        return this.allGoodsExchange;
    }

    public void setAllGoodsExchange(ConcurrentHashMap<Integer, GoodsExchange> allGoodsExchange2) {
        this.allGoodsExchange = allGoodsExchange2;
    }
}

