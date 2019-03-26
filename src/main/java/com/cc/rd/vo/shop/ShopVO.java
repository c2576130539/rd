package com.cc.rd.vo.shop;

import lombok.Data;

/**
 * @program: ShopVO
 * @description: 店铺信息
 * @author: cchen
 * @create: 2019-03-20 18:29
 */
@Data
public class ShopVO {

    private Long id;

    private String name;

    private Boolean practice;

    private String shopRuleId;

    private Integer avgScore;

    private Integer num;

    private Integer delivery;

    private String adress;

    private Double longitude;

    private Double latitude;
}
    