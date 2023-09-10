package org.come.readBean;

import org.come.model.QianDao;

import java.math.BigDecimal;
import java.util.Map;

public class AllQianDao
{
    // 所有npc的信息
    private Map<BigDecimal, QianDao> qianDaoConcurrentHashMap;

    public Map<BigDecimal, QianDao> getAllTalent() {
        return qianDaoConcurrentHashMap;
    }

    public void setAllTalent(Map<BigDecimal, QianDao> allTalent) {
        this.qianDaoConcurrentHashMap = allTalent;
    }
}
