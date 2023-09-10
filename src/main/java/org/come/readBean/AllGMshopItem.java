package org.come.readBean;

import org.come.model.GMshopItem;
import org.come.model.QianDao;

import java.math.BigDecimal;
import java.util.Map;

public class AllGMshopItem
{
    // 所有npc的信息
    private Map<BigDecimal, GMshopItem> gMshopItemConcurrentHashMap;

    public Map<BigDecimal, GMshopItem> getAllGMshopItem() {
        return gMshopItemConcurrentHashMap;
    }

    public void setAllGMshopItem(Map<BigDecimal, GMshopItem> gMshopItemConcurrentHashMap) {
        this.gMshopItemConcurrentHashMap = gMshopItemConcurrentHashMap;
    }
}
