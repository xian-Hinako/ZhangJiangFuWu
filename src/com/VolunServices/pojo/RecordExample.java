package com.VolunServices.pojo;

import java.util.ArrayList;
import java.util.List;

public class RecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andReacordidIsNull() {
            addCriterion("reacordid is null");
            return (Criteria) this;
        }

        public Criteria andReacordidIsNotNull() {
            addCriterion("reacordid is not null");
            return (Criteria) this;
        }

        public Criteria andReacordidEqualTo(Integer value) {
            addCriterion("reacordid =", value, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidNotEqualTo(Integer value) {
            addCriterion("reacordid <>", value, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidGreaterThan(Integer value) {
            addCriterion("reacordid >", value, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("reacordid >=", value, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidLessThan(Integer value) {
            addCriterion("reacordid <", value, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidLessThanOrEqualTo(Integer value) {
            addCriterion("reacordid <=", value, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidIn(List<Integer> values) {
            addCriterion("reacordid in", values, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidNotIn(List<Integer> values) {
            addCriterion("reacordid not in", values, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidBetween(Integer value1, Integer value2) {
            addCriterion("reacordid between", value1, value2, "reacordid");
            return (Criteria) this;
        }

        public Criteria andReacordidNotBetween(Integer value1, Integer value2) {
            addCriterion("reacordid not between", value1, value2, "reacordid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andActidIsNull() {
            addCriterion("actid is null");
            return (Criteria) this;
        }

        public Criteria andActidIsNotNull() {
            addCriterion("actid is not null");
            return (Criteria) this;
        }

        public Criteria andActidEqualTo(Integer value) {
            addCriterion("actid =", value, "actid");
            return (Criteria) this;
        }

        public Criteria andActidNotEqualTo(Integer value) {
            addCriterion("actid <>", value, "actid");
            return (Criteria) this;
        }

        public Criteria andActidGreaterThan(Integer value) {
            addCriterion("actid >", value, "actid");
            return (Criteria) this;
        }

        public Criteria andActidGreaterThanOrEqualTo(Integer value) {
            addCriterion("actid >=", value, "actid");
            return (Criteria) this;
        }

        public Criteria andActidLessThan(Integer value) {
            addCriterion("actid <", value, "actid");
            return (Criteria) this;
        }

        public Criteria andActidLessThanOrEqualTo(Integer value) {
            addCriterion("actid <=", value, "actid");
            return (Criteria) this;
        }

        public Criteria andActidIn(List<Integer> values) {
            addCriterion("actid in", values, "actid");
            return (Criteria) this;
        }

        public Criteria andActidNotIn(List<Integer> values) {
            addCriterion("actid not in", values, "actid");
            return (Criteria) this;
        }

        public Criteria andActidBetween(Integer value1, Integer value2) {
            addCriterion("actid between", value1, value2, "actid");
            return (Criteria) this;
        }

        public Criteria andActidNotBetween(Integer value1, Integer value2) {
            addCriterion("actid not between", value1, value2, "actid");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Float value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Float value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Float value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Float value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Float value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Float value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Float> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Float> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Float value1, Float value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Float value1, Float value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
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
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
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
}