package com.cc.rd.vo.order;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @program: OrderVO
 * @description: 订单显示
 * @author: cchen
 * @create: 2019-03-30 15:29
 */
@Data
public class OrderVO {

    List<OrderListVO> orderList = Lists.newArrayList();

}

