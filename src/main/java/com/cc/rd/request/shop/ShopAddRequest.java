package com.cc.rd.request.shop;

import lombok.Data;

/**
 * @program: ShopAddRequest
 * @description: 添加店铺
 * @author: cchen
 * @create: 2019-03-19 09:26
 */
@Data
public class ShopAddRequest {

    private String userId;

    private String name;

    private Integer practice;

    private Integer adcode;

    private Integer cityCode;

    private String adress;

    private String phone;

    private Double longitude;

    private Double latitude;
}
    