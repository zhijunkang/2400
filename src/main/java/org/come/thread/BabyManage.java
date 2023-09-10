package org.come.thread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.come.entity.Baby;
import org.come.tool.WriteOut;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

public class BabyManage implements DataBaseManage {
    private List<Baby> addList = new ArrayList<>();
    private List<BigDecimal> delList = new ArrayList<>();
    private List<Baby> updList = new ArrayList<>();

    @Override
    public void add(Object object) {
        this.addList.add((Baby) object);
        if (this.addList.size() > DataBaseManage.a) {
            try {
                AllServiceUtil.getBabyService().createBabyList(this.addList);
            } catch (Exception e) {
                for (int i = this.addList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getBabyService().createBabySingle(this.addList.get(i));
                    } catch (Exception e2) {
                        try {
                            System.out.println("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.addList.get(i)));
                            WriteOut.addtxt("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.addList.get(i)), 999);
                        } catch (Exception e3) {
                        }
                    }
                }
            }
            this.addList.clear();
        }

    }

    @Override
    public void del(Object object) {
        this.delList.add((BigDecimal) object);
        if (this.delList.size() > DataBaseManage.a) {
            try {
                AllServiceUtil.getBabyService().deleteBabyList(this.delList);
            } catch (Exception e) {
                for (int i = this.delList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getBabyService().deleteBabySingle(this.delList.get(i));
                    } catch (Exception e2) {
                        try {
                            System.out.println("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.delList.get(i)));
                            WriteOut.addtxt("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.delList.get(i)), 999);
                        } catch (Exception e3) {
                        }
                    }
                }
            }
            this.delList.clear();
        }
    }

    @Override
    public void upd(Object object) {
        this.updList.add((Baby) object);
        if (this.updList.size() > DataBaseManage.a) {
            try {
                AllServiceUtil.getBabyService().updateBabyList(this.updList);
            } catch (Exception e) {
                for (int i = this.updList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getBabyService().updateBabysql(this.updList.get(i));
                    } catch (Exception e2) {
                        try {
                            System.out.println("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.updList.get(i)));
                            WriteOut.addtxt("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.updList.get(i)), 999);
                        } catch (Exception e3) {
                        }
                    }
                }
            }
            this.updList.clear();
        }
    }

    @Override
    public void ClearList() {
        if (this.addList.size() != 0) {
            try {
                AllServiceUtil.getBabyService().createBabyList(this.addList);
            } catch (Exception e) {
                for (int i = this.addList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getBabyService().createBabySingle(this.addList.get(i));
                    } catch (Exception e2) {
                        try {
                            System.out.println("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.addList.get(i)));
                            WriteOut.addtxt("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.addList.get(i)), 999);
                        } catch (Exception e3) {
                        }
                    }
                }
            }
            this.addList.clear();
        }

        if (this.delList.size() != 0) {
            try {
                AllServiceUtil.getBabyService().deleteBabyList(this.delList);
            } catch (Exception e) {
                for (int i = this.delList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getBabyService().deleteBabySingle(this.delList.get(i));
                    } catch (Exception e2) {
                        try {
                            System.out.println("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.delList.get(i)));
                            WriteOut.addtxt("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.delList.get(i)), 999);
                        } catch (Exception e3) {
                        }
                    }
                }
            }
            this.delList.clear();
        }

        if (this.updList.size() != 0) {
            try {
                AllServiceUtil.getBabyService().updateBabyList(this.updList);
            } catch (Exception e) {
                for (int i = this.updList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getBabyService().updateBabysql(this.updList.get(i));
                    } catch (Exception e2) {
                        try {
                            System.out.println("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.updList.get(i)));
                            WriteOut.addtxt("同步数据库物品属性:" + GsonUtil.getGsonUtil().getgson().toJson(this.updList.get(i)), 999);
                        } catch (Exception e3) {
                        }
                    }
                }
            }
            this.updList.clear();
        }
    }

}
