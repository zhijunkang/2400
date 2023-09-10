package org.come.bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoSwitchBean {

    private Integer cuurentE;
    private Map<Integer,List<BigDecimal>> allEquip=new HashMap<>();
    private Map<String,String> allEquipName=new HashMap<>();
    private Map<Integer,String> tzName=new HashMap<>();

    private Integer cuurentS;
    private Map<Integer,List<Integer>> allSX=new HashMap<>();

    public Integer getCuurentE() {
        return cuurentE;
    }

    public void setCuurentE(Integer cuurentE) {
        this.cuurentE = cuurentE;
    }

    public Map<Integer, List<BigDecimal>> getAllEquip() {
        return allEquip;
    }

    public void setAllEquip(Map<Integer, List<BigDecimal>> allEquip) {
        this.allEquip = allEquip;
    }

    public Integer getCuurentS() {
        return cuurentS;
    }

    public void setCuurentS(Integer cuurentS) {
        this.cuurentS = cuurentS;
    }

    public Map<Integer, List<Integer>> getAllSX() {
        return allSX;
    }

    public void setAllSX(Map<Integer, List<Integer>> allSX) {
        this.allSX = allSX;
    }

    public Map<Integer, String> getTzName() {
        return tzName;
    }

    public void setTzName(Map<Integer, String> tzName) {
        this.tzName = tzName;
    }

    public Map<String, String> getAllEquipName() {
        return allEquipName;
    }

    public void setAllEquipName(Map<String, String> allEquipName) {
        this.allEquipName = allEquipName;
    }

    public String getEquipName(String name){
        String s1 = allEquipName.get(name);
        if (s1==null){
            return name;
        }
        return s1;
    }
}
