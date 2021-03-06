package com.example.pulsaraopdemo.mybatis.po;

import java.util.ArrayList;
import java.util.List;

public class StuClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuClassExample() {
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

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andStuCnoIsNull() {
            addCriterion("stu_cno is null");
            return (Criteria) this;
        }

        public Criteria andStuCnoIsNotNull() {
            addCriterion("stu_cno is not null");
            return (Criteria) this;
        }

        public Criteria andStuCnoEqualTo(Integer value) {
            addCriterion("stu_cno =", value, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoNotEqualTo(Integer value) {
            addCriterion("stu_cno <>", value, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoGreaterThan(Integer value) {
            addCriterion("stu_cno >", value, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_cno >=", value, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoLessThan(Integer value) {
            addCriterion("stu_cno <", value, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoLessThanOrEqualTo(Integer value) {
            addCriterion("stu_cno <=", value, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoIn(List<Integer> values) {
            addCriterion("stu_cno in", values, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoNotIn(List<Integer> values) {
            addCriterion("stu_cno not in", values, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoBetween(Integer value1, Integer value2) {
            addCriterion("stu_cno between", value1, value2, "stuCno");
            return (Criteria) this;
        }

        public Criteria andStuCnoNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_cno not between", value1, value2, "stuCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoIsNull() {
            addCriterion("class_cno is null");
            return (Criteria) this;
        }

        public Criteria andClassCnoIsNotNull() {
            addCriterion("class_cno is not null");
            return (Criteria) this;
        }

        public Criteria andClassCnoEqualTo(Integer value) {
            addCriterion("class_cno =", value, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoNotEqualTo(Integer value) {
            addCriterion("class_cno <>", value, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoGreaterThan(Integer value) {
            addCriterion("class_cno >", value, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_cno >=", value, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoLessThan(Integer value) {
            addCriterion("class_cno <", value, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoLessThanOrEqualTo(Integer value) {
            addCriterion("class_cno <=", value, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoIn(List<Integer> values) {
            addCriterion("class_cno in", values, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoNotIn(List<Integer> values) {
            addCriterion("class_cno not in", values, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoBetween(Integer value1, Integer value2) {
            addCriterion("class_cno between", value1, value2, "classCno");
            return (Criteria) this;
        }

        public Criteria andClassCnoNotBetween(Integer value1, Integer value2) {
            addCriterion("class_cno not between", value1, value2, "classCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoIsNull() {
            addCriterion("teacher_cno is null");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoIsNotNull() {
            addCriterion("teacher_cno is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoEqualTo(Integer value) {
            addCriterion("teacher_cno =", value, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoNotEqualTo(Integer value) {
            addCriterion("teacher_cno <>", value, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoGreaterThan(Integer value) {
            addCriterion("teacher_cno >", value, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_cno >=", value, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoLessThan(Integer value) {
            addCriterion("teacher_cno <", value, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_cno <=", value, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoIn(List<Integer> values) {
            addCriterion("teacher_cno in", values, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoNotIn(List<Integer> values) {
            addCriterion("teacher_cno not in", values, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoBetween(Integer value1, Integer value2) {
            addCriterion("teacher_cno between", value1, value2, "teacherCno");
            return (Criteria) this;
        }

        public Criteria andTeacherCnoNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_cno not between", value1, value2, "teacherCno");
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