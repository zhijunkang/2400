/*
 * Decompiled with CFR 0.150.
 */
package org.come.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsexchangeExample {
    protected String orderByClause;
    protected boolean distinct;
    private String goodsid;
    private int flag;
    private String goodsguid;
    protected List<Criteria> oredCriteria = new ArrayList<Criteria>();

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return this.orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return this.distinct;
    }

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public String getGoodsguid() {
        return this.goodsguid;
    }

    public void setGoodsguid(String goodsguid) {
        this.goodsguid = goodsguid;
    }

    public String getGoodsid() {
        return this.goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public static class Criterion {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return this.condition;
        }

        public Object getValue() {
            return this.value;
        }

        public Object getSecondValue() {
            return this.secondValue;
        }

        public boolean isNoValue() {
            return this.noValue;
        }

        public boolean isSingleValue() {
            return this.singleValue;
        }

        public boolean isBetweenValue() {
            return this.betweenValue;
        }

        public boolean isListValue() {
            return this.listValue;
        }

        public String getTypeHandler() {
            return this.typeHandler;
        }

        protected Criterion(String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public static class Criteria
    extends GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected static abstract class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList<Criterion>();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            this.criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGoodsguidIsNull() {
            this.addCriterion("GOODSGUID is null");
            return (Criteria)this;
        }

        public Criteria andGoodsguidIsNotNull() {
            this.addCriterion("GOODSGUID is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsguidEqualTo(String value) {
            this.addCriterion("GOODSGUID =", value, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidNotEqualTo(String value) {
            this.addCriterion("GOODSGUID <>", value, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidGreaterThan(String value) {
            this.addCriterion("GOODSGUID >", value, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidGreaterThanOrEqualTo(String value) {
            this.addCriterion("GOODSGUID >=", value, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidLessThan(String value) {
            this.addCriterion("GOODSGUID <", value, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidLessThanOrEqualTo(String value) {
            this.addCriterion("GOODSGUID <=", value, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidLike(String value) {
            this.addCriterion("GOODSGUID like", value, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidNotLike(String value) {
            this.addCriterion("GOODSGUID not like", value, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidIn(List<String> values) {
            this.addCriterion("GOODSGUID in", values, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidNotIn(List<String> values) {
            this.addCriterion("GOODSGUID not in", values, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidBetween(String value1, String value2) {
            this.addCriterion("GOODSGUID between", value1, value2, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andGoodsguidNotBetween(String value1, String value2) {
            this.addCriterion("GOODSGUID not between", value1, value2, "goodsguid");
            return (Criteria)this;
        }

        public Criteria andFlagIsNull() {
            this.addCriterion("FLAG is null");
            return (Criteria)this;
        }

        public Criteria andFlagIsNotNull() {
            this.addCriterion("FLAG is not null");
            return (Criteria)this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            this.addCriterion("FLAG =", value, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            this.addCriterion("FLAG <>", value, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            this.addCriterion("FLAG >", value, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("FLAG >=", value, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagLessThan(Integer value) {
            this.addCriterion("FLAG <", value, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            this.addCriterion("FLAG <=", value, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            this.addCriterion("FLAG in", values, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            this.addCriterion("FLAG not in", values, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            this.addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria)this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            this.addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria)this;
        }

        public Criteria andGoodsidIsNull() {
            this.addCriterion("GOODSID is null");
            return (Criteria)this;
        }

        public Criteria andGoodsidIsNotNull() {
            this.addCriterion("GOODSID is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsidEqualTo(String value) {
            this.addCriterion("GOODSID =", value, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidNotEqualTo(String value) {
            this.addCriterion("GOODSID <>", value, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidGreaterThan(String value) {
            this.addCriterion("GOODSID >", value, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(String value) {
            this.addCriterion("GOODSID >=", value, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidLessThan(String value) {
            this.addCriterion("GOODSID <", value, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(String value) {
            this.addCriterion("GOODSID <=", value, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidLike(String value) {
            this.addCriterion("GOODSID like", value, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidNotLike(String value) {
            this.addCriterion("GOODSID not like", value, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidIn(List<String> values) {
            this.addCriterion("GOODSID in", values, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidNotIn(List<String> values) {
            this.addCriterion("GOODSID not in", values, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidBetween(String value1, String value2) {
            this.addCriterion("GOODSID between", value1, value2, "goodsid");
            return (Criteria)this;
        }

        public Criteria andGoodsidNotBetween(String value1, String value2) {
            this.addCriterion("GOODSID not between", value1, value2, "goodsid");
            return (Criteria)this;
        }

        public Criteria andOuttimeIsNull() {
            this.addCriterion("OUTTIME is null");
            return (Criteria)this;
        }

        public Criteria andOuttimeIsNotNull() {
            this.addCriterion("OUTTIME is not null");
            return (Criteria)this;
        }

        public Criteria andOuttimeEqualTo(Date value) {
            this.addCriterion("OUTTIME =", value, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeNotEqualTo(Date value) {
            this.addCriterion("OUTTIME <>", value, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeGreaterThan(Date value) {
            this.addCriterion("OUTTIME >", value, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("OUTTIME >=", value, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeLessThan(Date value) {
            this.addCriterion("OUTTIME <", value, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeLessThanOrEqualTo(Date value) {
            this.addCriterion("OUTTIME <=", value, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeIn(List<Date> values) {
            this.addCriterion("OUTTIME in", values, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeNotIn(List<Date> values) {
            this.addCriterion("OUTTIME not in", values, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeBetween(Date value1, Date value2) {
            this.addCriterion("OUTTIME between", value1, value2, "outtime");
            return (Criteria)this;
        }

        public Criteria andOuttimeNotBetween(Date value1, Date value2) {
            this.addCriterion("OUTTIME not between", value1, value2, "outtime");
            return (Criteria)this;
        }
    }
}

