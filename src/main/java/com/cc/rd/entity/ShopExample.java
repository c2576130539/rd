package com.cc.rd.entity;

import java.util.ArrayList;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andPracticeIsNull() {
            addCriterion("practice is null");
            return (Criteria) this;
        }

        public Criteria andPracticeIsNotNull() {
            addCriterion("practice is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeEqualTo(Boolean value) {
            addCriterion("practice =", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotEqualTo(Boolean value) {
            addCriterion("practice <>", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeGreaterThan(Boolean value) {
            addCriterion("practice >", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("practice >=", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeLessThan(Boolean value) {
            addCriterion("practice <", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeLessThanOrEqualTo(Boolean value) {
            addCriterion("practice <=", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeIn(List<Boolean> values) {
            addCriterion("practice in", values, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotIn(List<Boolean> values) {
            addCriterion("practice not in", values, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeBetween(Boolean value1, Boolean value2) {
            addCriterion("practice between", value1, value2, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("practice not between", value1, value2, "practice");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreIsNull() {
            addCriterion("shop_avg_score is null");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreIsNotNull() {
            addCriterion("shop_avg_score is not null");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreEqualTo(Integer value) {
            addCriterion("shop_avg_score =", value, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreNotEqualTo(Integer value) {
            addCriterion("shop_avg_score <>", value, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreGreaterThan(Integer value) {
            addCriterion("shop_avg_score >", value, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_avg_score >=", value, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreLessThan(Integer value) {
            addCriterion("shop_avg_score <", value, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreLessThanOrEqualTo(Integer value) {
            addCriterion("shop_avg_score <=", value, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreIn(List<Integer> values) {
            addCriterion("shop_avg_score in", values, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreNotIn(List<Integer> values) {
            addCriterion("shop_avg_score not in", values, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreBetween(Integer value1, Integer value2) {
            addCriterion("shop_avg_score between", value1, value2, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopAvgScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_avg_score not between", value1, value2, "shopAvgScore");
            return (Criteria) this;
        }

        public Criteria andShopNumIsNull() {
            addCriterion("shop_num is null");
            return (Criteria) this;
        }

        public Criteria andShopNumIsNotNull() {
            addCriterion("shop_num is not null");
            return (Criteria) this;
        }

        public Criteria andShopNumEqualTo(Integer value) {
            addCriterion("shop_num =", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotEqualTo(Integer value) {
            addCriterion("shop_num <>", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumGreaterThan(Integer value) {
            addCriterion("shop_num >", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_num >=", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumLessThan(Integer value) {
            addCriterion("shop_num <", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumLessThanOrEqualTo(Integer value) {
            addCriterion("shop_num <=", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumIn(List<Integer> values) {
            addCriterion("shop_num in", values, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotIn(List<Integer> values) {
            addCriterion("shop_num not in", values, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumBetween(Integer value1, Integer value2) {
            addCriterion("shop_num between", value1, value2, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_num not between", value1, value2, "shopNum");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNull() {
            addCriterion("delivery is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNotNull() {
            addCriterion("delivery is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEqualTo(Integer value) {
            addCriterion("delivery =", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotEqualTo(Integer value) {
            addCriterion("delivery <>", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThan(Integer value) {
            addCriterion("delivery >", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery >=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThan(Integer value) {
            addCriterion("delivery <", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThanOrEqualTo(Integer value) {
            addCriterion("delivery <=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryIn(List<Integer> values) {
            addCriterion("delivery in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotIn(List<Integer> values) {
            addCriterion("delivery not in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryBetween(Integer value1, Integer value2) {
            addCriterion("delivery between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery not between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeIsNull() {
            addCriterion("shop_adcode is null");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeIsNotNull() {
            addCriterion("shop_adcode is not null");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeEqualTo(Integer value) {
            addCriterion("shop_adcode =", value, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeNotEqualTo(Integer value) {
            addCriterion("shop_adcode <>", value, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeGreaterThan(Integer value) {
            addCriterion("shop_adcode >", value, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_adcode >=", value, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeLessThan(Integer value) {
            addCriterion("shop_adcode <", value, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_adcode <=", value, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeIn(List<Integer> values) {
            addCriterion("shop_adcode in", values, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeNotIn(List<Integer> values) {
            addCriterion("shop_adcode not in", values, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeBetween(Integer value1, Integer value2) {
            addCriterion("shop_adcode between", value1, value2, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopAdcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_adcode not between", value1, value2, "shopAdcode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeIsNull() {
            addCriterion("shop_city_code is null");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeIsNotNull() {
            addCriterion("shop_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeEqualTo(Integer value) {
            addCriterion("shop_city_code =", value, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeNotEqualTo(Integer value) {
            addCriterion("shop_city_code <>", value, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeGreaterThan(Integer value) {
            addCriterion("shop_city_code >", value, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_city_code >=", value, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeLessThan(Integer value) {
            addCriterion("shop_city_code <", value, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_city_code <=", value, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeIn(List<Integer> values) {
            addCriterion("shop_city_code in", values, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeNotIn(List<Integer> values) {
            addCriterion("shop_city_code not in", values, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeBetween(Integer value1, Integer value2) {
            addCriterion("shop_city_code between", value1, value2, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopCityCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_city_code not between", value1, value2, "shopCityCode");
            return (Criteria) this;
        }

        public Criteria andShopAdressIsNull() {
            addCriterion("shop_adress is null");
            return (Criteria) this;
        }

        public Criteria andShopAdressIsNotNull() {
            addCriterion("shop_adress is not null");
            return (Criteria) this;
        }

        public Criteria andShopAdressEqualTo(String value) {
            addCriterion("shop_adress =", value, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressNotEqualTo(String value) {
            addCriterion("shop_adress <>", value, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressGreaterThan(String value) {
            addCriterion("shop_adress >", value, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressGreaterThanOrEqualTo(String value) {
            addCriterion("shop_adress >=", value, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressLessThan(String value) {
            addCriterion("shop_adress <", value, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressLessThanOrEqualTo(String value) {
            addCriterion("shop_adress <=", value, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressLike(String value) {
            addCriterion("shop_adress like", value, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressNotLike(String value) {
            addCriterion("shop_adress not like", value, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressIn(List<String> values) {
            addCriterion("shop_adress in", values, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressNotIn(List<String> values) {
            addCriterion("shop_adress not in", values, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressBetween(String value1, String value2) {
            addCriterion("shop_adress between", value1, value2, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopAdressNotBetween(String value1, String value2) {
            addCriterion("shop_adress not between", value1, value2, "shopAdress");
            return (Criteria) this;
        }

        public Criteria andShopPhoneIsNull() {
            addCriterion("shop_phone is null");
            return (Criteria) this;
        }

        public Criteria andShopPhoneIsNotNull() {
            addCriterion("shop_phone is not null");
            return (Criteria) this;
        }

        public Criteria andShopPhoneEqualTo(String value) {
            addCriterion("shop_phone =", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotEqualTo(String value) {
            addCriterion("shop_phone <>", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneGreaterThan(String value) {
            addCriterion("shop_phone >", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("shop_phone >=", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneLessThan(String value) {
            addCriterion("shop_phone <", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneLessThanOrEqualTo(String value) {
            addCriterion("shop_phone <=", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneLike(String value) {
            addCriterion("shop_phone like", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotLike(String value) {
            addCriterion("shop_phone not like", value, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneIn(List<String> values) {
            addCriterion("shop_phone in", values, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotIn(List<String> values) {
            addCriterion("shop_phone not in", values, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneBetween(String value1, String value2) {
            addCriterion("shop_phone between", value1, value2, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopPhoneNotBetween(String value1, String value2) {
            addCriterion("shop_phone not between", value1, value2, "shopPhone");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeIsNull() {
            addCriterion("shop_longitude is null");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeIsNotNull() {
            addCriterion("shop_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeEqualTo(Double value) {
            addCriterion("shop_longitude =", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeNotEqualTo(Double value) {
            addCriterion("shop_longitude <>", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeGreaterThan(Double value) {
            addCriterion("shop_longitude >", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("shop_longitude >=", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeLessThan(Double value) {
            addCriterion("shop_longitude <", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("shop_longitude <=", value, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeIn(List<Double> values) {
            addCriterion("shop_longitude in", values, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeNotIn(List<Double> values) {
            addCriterion("shop_longitude not in", values, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeBetween(Double value1, Double value2) {
            addCriterion("shop_longitude between", value1, value2, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("shop_longitude not between", value1, value2, "shopLongitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeIsNull() {
            addCriterion("shop_latitude is null");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeIsNotNull() {
            addCriterion("shop_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeEqualTo(Double value) {
            addCriterion("shop_latitude =", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeNotEqualTo(Double value) {
            addCriterion("shop_latitude <>", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeGreaterThan(Double value) {
            addCriterion("shop_latitude >", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("shop_latitude >=", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeLessThan(Double value) {
            addCriterion("shop_latitude <", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("shop_latitude <=", value, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeIn(List<Double> values) {
            addCriterion("shop_latitude in", values, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeNotIn(List<Double> values) {
            addCriterion("shop_latitude not in", values, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeBetween(Double value1, Double value2) {
            addCriterion("shop_latitude between", value1, value2, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("shop_latitude not between", value1, value2, "shopLatitude");
            return (Criteria) this;
        }

        public Criteria andShopImageIsNull() {
            addCriterion("shop_image is null");
            return (Criteria) this;
        }

        public Criteria andShopImageIsNotNull() {
            addCriterion("shop_image is not null");
            return (Criteria) this;
        }

        public Criteria andShopImageEqualTo(String value) {
            addCriterion("shop_image =", value, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageNotEqualTo(String value) {
            addCriterion("shop_image <>", value, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageGreaterThan(String value) {
            addCriterion("shop_image >", value, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageGreaterThanOrEqualTo(String value) {
            addCriterion("shop_image >=", value, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageLessThan(String value) {
            addCriterion("shop_image <", value, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageLessThanOrEqualTo(String value) {
            addCriterion("shop_image <=", value, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageLike(String value) {
            addCriterion("shop_image like", value, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageNotLike(String value) {
            addCriterion("shop_image not like", value, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageIn(List<String> values) {
            addCriterion("shop_image in", values, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageNotIn(List<String> values) {
            addCriterion("shop_image not in", values, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageBetween(String value1, String value2) {
            addCriterion("shop_image between", value1, value2, "shopImage");
            return (Criteria) this;
        }

        public Criteria andShopImageNotBetween(String value1, String value2) {
            addCriterion("shop_image not between", value1, value2, "shopImage");
            return (Criteria) this;
        }

        public Criteria andExtendIdIsNull() {
            addCriterion("extend_id is null");
            return (Criteria) this;
        }

        public Criteria andExtendIdIsNotNull() {
            addCriterion("extend_id is not null");
            return (Criteria) this;
        }

        public Criteria andExtendIdEqualTo(Long value) {
            addCriterion("extend_id =", value, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdNotEqualTo(Long value) {
            addCriterion("extend_id <>", value, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdGreaterThan(Long value) {
            addCriterion("extend_id >", value, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("extend_id >=", value, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdLessThan(Long value) {
            addCriterion("extend_id <", value, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdLessThanOrEqualTo(Long value) {
            addCriterion("extend_id <=", value, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdIn(List<Long> values) {
            addCriterion("extend_id in", values, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdNotIn(List<Long> values) {
            addCriterion("extend_id not in", values, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdBetween(Long value1, Long value2) {
            addCriterion("extend_id between", value1, value2, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIdNotBetween(Long value1, Long value2) {
            addCriterion("extend_id not between", value1, value2, "extendId");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("extend like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("extend not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("extend not between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Long value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Long value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Long value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Long value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Long value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Long value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Long> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Long> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Long value1, Long value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Long value1, Long value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Long value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Long value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Long value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Long value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Long value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Long value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Long> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Long> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Long value1, Long value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Long value1, Long value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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