package com.cc.rd.request.order;

import com.cc.rd.request.PageRequest;
import lombok.Data;

import java.util.List;

/**
 * @program: OrderAddRequest
 * @description: 发起活动订单
 * @author: cchen
 * @create: 2019-03-29 13:23
 */
@Data
public class OrderAddRequest extends PageRequest {
    /**
     * 活动主题
     */
    private String title;

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
}
    