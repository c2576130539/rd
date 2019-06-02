package com.cc.rd.service.order.impl;

import com.cc.rd.dao.OrderMapper;
import com.cc.rd.entity.Order;
import com.cc.rd.entity.OrderExample;
import com.cc.rd.request.order.OrderAddRequest;
import com.cc.rd.request.order.OrderSearchRequest;
import com.cc.rd.service.order.OrderInviteesService;
import com.cc.rd.service.order.OrderService;
import com.cc.rd.util.DateTimeUtils;
import com.cc.rd.validator.FastValidator;
import com.cc.rd.vo.order.OrderListVO;
import com.cc.rd.vo.order.OrderVO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: OrderServiceImpl
 * @description: 拼团交友活动订单逻辑实现
 * @author: cchen
 * @create: 2019-03-29 13:13
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderInviteesService orderInviteesService;

    @Override
    public void addOrder(OrderAddRequest request, Long userId) {
        FastValidator.start().notNull(request.getOrderTitle(), "title");
        Order order = new Order();
        //BeanUtils.copyProperties(request, order);
        //order.setId(UUID.randomUUID().toString());
        order.setOrderTitle(request.getOrderTitle());
        order.setOrderContent(request.getOrderContent());
        order.setOrderStarts(request.getOrderStarts());
        order.setOrderEnds(request.getOrderEnds());
        order.setOrderAddress(request.getOrderAddress());
        order.setOrderCityCode(request.getOrderCityCode());
        order.setOrderAdcode(request.getOrderAdcode());
        order.setOrderLatitude(request.getOrderLatitude());
        order.setOrderLongitude(request.getOrderLongitude());
        order.setOrderType(0);

        order.setOrderState(0);
        order.setCreateAt(DateTimeUtils.utcNow());
        order.setCreateBy(userId);
        order.setIsDeleted(0);
        orderMapper.ccinsert(order);
        //orderMapper.insert(order);
        orderInviteesService.addInvitees(userId, order.getId().toString());
    }

    @Override
    public OrderVO listOrderSearch(OrderSearchRequest request) {
        OrderVO orderVO = new OrderVO();
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_starts");
        example.createCriteria().andIsDeletedEqualTo(0).andOrderTypeEqualTo(0);
        List<Order> orderList = orderMapper.selectByExample(example);
        List<OrderListVO> orderListVOList = Lists.newArrayList();
        orderList.forEach(o -> {
            OrderListVO orderListVO = new OrderListVO();
            orderListVO.setOrderId(o.getId().toString());
            orderListVO.setTitle("主题:" + o.getOrderTitle());
            orderListVO.setPlace("地点:" + o.getOrderAddress());
            String time = DateTimeUtils.getMil2mmTimeFormat(String.valueOf(o.getOrderStarts()))
                    + " ~ " + DateTimeUtils.getMil2mmTimeFormat(String.valueOf(o.getOrderEnds()));
            orderListVO.setTime("起止时间:" + time);
            orderListVO.setNumber("人数:1");
            orderListVOList.add(orderListVO);
        });

        orderVO.setOrderList(orderListVOList);
        return orderVO;
    }
}
    