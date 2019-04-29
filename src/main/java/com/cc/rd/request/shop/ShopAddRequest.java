package com.cc.rd.request.shop;

import lombok.Data;

import java.util.List;

/**
 * @program: ShopAddRequest
 * @description: 添加店铺
 * @author: cchen
 * @create: 2019-03-19 09:26
 */
@Data
public class ShopAddRequest {

    private Long userId;

    private String shopName;

    private Boolean practice;

    private Integer shopAdcode;

    private Integer shopCityCode;

    private String shopAdress;

    private String shopPhone;

    private Double shopLongitude;

    private Double shopLatitude;

    private String shopImage;

    private List<Long> labelIdList;
}
    