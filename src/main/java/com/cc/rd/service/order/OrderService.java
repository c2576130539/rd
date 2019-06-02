package com.cc.rd.service.order;

import com.cc.rd.request.order.OrderAddRequest;
import com.cc.rd.request.order.OrderSearchRequest;
import com.cc.rd.vo.order.OrderVO;
import com.github.pagehelper.PageInfo;

/**
 * @program: OrderService
 * @description: 拼团交友活动订单逻辑接口
 * @author: cchen
 * @create: 2019-03-29 13:12
 */
public interface OrderService {

    /**
     * 生成订单
     * @param request
     */
    void addOrder(OrderAddRequest request, Long userId);

    OrderVO listOrderSearch(OrderSearchRequest request);
}