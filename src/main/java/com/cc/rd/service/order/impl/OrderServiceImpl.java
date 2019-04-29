package com.cc.rd.service.order.impl;

import com.cc.rd.entity.Order;
import com.cc.rd.request.order.OrderAddRequest;
import com.cc.rd.request.order.OrderSearchRequest;
import com.cc.rd.service.order.OrderService;
import com.cc.rd.validator.FastValidator;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @program: OrderServiceImpl
 * @description: 拼团交友活动订单逻辑实现
 * @author: cchen
 * @create: 2019-03-29 13:13
 */
@Service
public class OrderServiceImpl implements OrderService {


    /**
     * 活动内容
     */
    private String content;

    /**
     * 开始时间
     */
    private Long starts;

    /**
     * 结束时间
     */
    private Long ends;

    /**
     * 是否公开
     */
    private Integer type;

    /**
     * 店家
     */
    private Long shopId;

    /**
     * 人数上限
     */
    private Integer number;

    /**
     * 城市
     */
    private Integer adcode;

    /**
     * 区
     */
    private Integer cityCode;

    private String address;

    @Override
    public void addOrder(OrderAddRequest request, Long userId) {
        FastValidator.start().notNull(request.getOrderTitle(), "title")
                .numNotNull(request.getOrderStarts(), "statTime")
                .numNotNull(request.getOrderEnds(), "endTime")
                .numNotNull(request.getOrderAdcode(), "city")
                .numNotNull(request.getOrderCityCode(), "area");
        Order order = new Order();
    }

    @Override
    public PageInfo listOrderSearch(OrderSearchRequest request) {
        return null;
    }
}
    