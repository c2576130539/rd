package com.cc.rd.request.order;

import com.cc.rd.request.PageRequest;
import lombok.Data;

/**
 * @program: OrderSearchRequest
 * @description: 订单查询
 * @author: cchen
 * @create: 2019-03-30 19:08
 */
@Data
public class OrderSearchRequest extends PageRequest {

    private Integer number;

    private String title;

    private Long starts;

    private Long ends;

    private Long shopId;

    private Integer adcode;

    private Integer cityCode;

    private String address;
}
    