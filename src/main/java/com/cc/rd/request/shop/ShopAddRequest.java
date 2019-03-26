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

    private String name;

    private String type;

    private Boolean practice;

    private String country;

    private String state;

    private String city;

    private String area;

    private String adress;

    private Double longitude;

    private Double latitude;
}
    