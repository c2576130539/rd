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

    /**
     * 人数上限
     */
    private Integer orderNum;

    /**
     * 活动主题
     */
    private String orderTitle;

    /**
     * 开始时间
     */
    private Long orderStarts;

    /**
     * 结束时间
     */
    private Long orderEnds;

    private Long shopId;

    /**
     * 城市
     */
    private Integer orderAdcode;

    /**
     * 区
     */
    private Integer orderCityCode;

    private String address;
}
    