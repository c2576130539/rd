package com.cc.rd.entity;

public class Order {
    private Long id;

    private Integer orderNum;

    private String orderTitle;

    private String orderContent;

    private Long orderStarts;

    private Long orderEnds;

    private Integer orderType;

    private Integer orderState;

    private Long shopId;

    private Integer orderAdcode;

    private Integer orderCityCode;

    private Double orderLongitude;

    private Double orderLatitude;

    private String orderAddress;

    private String externalId;

    private Long updateBy;

    private Long updateAt;

    private Long createAt;

    private Long createBy;

    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public Long getOrderStarts() {
        return orderStarts;
    }

    public void setOrderStarts(Long orderStarts) {
        this.orderStarts = orderStarts;
    }

    public Long getOrderEnds() {
        return orderEnds;
    }

    public void setOrderEnds(Long orderEnds) {
        this.orderEnds = orderEnds;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderAdcode() {
        return orderAdcode;
    }

    public void setOrderAdcode(Integer orderAdcode) {
        this.orderAdcode = orderAdcode;
    }

    public Integer getOrderCityCode() {
        return orderCityCode;
    }

    public void setOrderCityCode(Integer orderCityCode) {
        this.orderCityCode = orderCityCode;
    }

    public Double getOrderLongitude() {
        return orderLongitude;
    }

    public void setOrderLongitude(Double orderLongitude) {
        this.orderLongitude = orderLongitude;
    }

    public Double getOrderLatitude() {
        return orderLatitude;
    }

    public void setOrderLatitude(Double orderLatitude) {
        this.orderLatitude = orderLatitude;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}