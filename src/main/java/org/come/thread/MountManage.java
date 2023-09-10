package org.come.thread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.come.entity.Mount;
import org.come.tool.WriteOut;
import org.come.until.AllServiceUtil;
import org.come.until.GsonUtil;

public class MountManage implements DataBaseManage {
    private List<Mount> addList = new ArrayList<>();
    private List<BigDecimal> delList = new ArrayList<>();
    private List<Mount> updList = new ArrayList<>();

    @Override
    public void add(Object object) {
        this.addList.add((Mount) object);
        if (this.addList.size() > DataBaseManage.a) {
            try {
                AllServiceUtil.getMountService().insertMountList(this.addList);
            } catch (Exception e) {
                for (int i = this.addList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getMountService().insertMountSingle(this.addList.get(i));
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
                AllServiceUtil.getMountService().deleteMountsByMidList(this.delList);
            } catch (Exception e) {
                for (int i = this.delList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getMountService().deleteMountsByMidsql(this.delList.get(i));
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
        this.updList.add((Mount) object);
        if (this.updList.size() > DataBaseManage.a) {
            try {
                AllServiceUtil.getMountService().updateMountList(this.updList);
            } catch (Exception e) {
                for (int i = this.updList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getMountService().updateMountsql(this.updList.get(i));
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
        if (this.delList.size() != 0) {
            try {
                AllServiceUtil.getMountService().deleteMountsByMidList(this.delList);
            } catch (Exception e) {
                for (int i = this.delList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getMountService().deleteMountsByMidsql(this.delList.get(i));
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
                AllServiceUtil.getMountService().updateMountList(this.updList);
            } catch (Exception e) {
                for (int i = this.updList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getMountService().updateMountsql(this.updList.get(i));
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

        if (this.addList.size() != 0) {
            try {
                AllServiceUtil.getMountService().insertMountList(this.addList);
            } catch (Exception e) {
                for (int i = this.addList.size() - 1; i >= 0; i--) {
                    try {
                        AllServiceUtil.getMountService().insertMountSingle(this.addList.get(i));
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
}
