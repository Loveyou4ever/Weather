package com.weather.domain.model;

import java.util.ArrayList;
import java.util.List;

public class AtmoPreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AtmoPreExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureIsNull() {
            addCriterion("atmospheric_pressure is null");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureIsNotNull() {
            addCriterion("atmospheric_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureEqualTo(Double value) {
            addCriterion("atmospheric_pressure =", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureNotEqualTo(Double value) {
            addCriterion("atmospheric_pressure <>", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureGreaterThan(Double value) {
            addCriterion("atmospheric_pressure >", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureGreaterThanOrEqualTo(Double value) {
            addCriterion("atmospheric_pressure >=", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureLessThan(Double value) {
            addCriterion("atmospheric_pressure <", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureLessThanOrEqualTo(Double value) {
            addCriterion("atmospheric_pressure <=", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureIn(List<Double> values) {
            addCriterion("atmospheric_pressure in", values, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureNotIn(List<Double> values) {
            addCriterion("atmospheric_pressure not in", values, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureBetween(Double value1, Double value2) {
            addCriterion("atmospheric_pressure between", value1, value2, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureNotBetween(Double value1, Double value2) {
            addCriterion("atmospheric_pressure not between", value1, value2, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andCatchTimeIsNull() {
            addCriterion("catch_time is null");
            return (Criteria) this;
        }

        public Criteria andCatchTimeIsNotNull() {
            addCriterion("catch_time is not null");
            return (Criteria) this;
        }

        public Criteria andCatchTimeEqualTo(String value) {
            addCriterion("catch_time =", value, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeNotEqualTo(String value) {
            addCriterion("catch_time <>", value, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeGreaterThan(String value) {
            addCriterion("catch_time >", value, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeGreaterThanOrEqualTo(String value) {
            addCriterion("catch_time >=", value, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeLessThan(String value) {
            addCriterion("catch_time <", value, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeLessThanOrEqualTo(String value) {
            addCriterion("catch_time <=", value, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeLike(String value) {
            addCriterion("catch_time like", value, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeNotLike(String value) {
            addCriterion("catch_time not like", value, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeIn(List<String> values) {
            addCriterion("catch_time in", values, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeNotIn(List<String> values) {
            addCriterion("catch_time not in", values, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeBetween(String value1, String value2) {
            addCriterion("catch_time between", value1, value2, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeNotBetween(String value1, String value2) {
            addCriterion("catch_time not between", value1, value2, "catchTime");
            return (Criteria) this;
        }

        public Criteria andCatchTimeLikeInsensitive(String value) {
            addCriterion("upper(catch_time) like", value.toUpperCase(), "catchTime");
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