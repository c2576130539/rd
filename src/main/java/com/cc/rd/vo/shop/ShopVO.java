package com.cc.rd.vo.shop;

import lombok.Data;

import java.util.List;

/**
 * @program: ShopVO
 * @description: 店铺信息
 * @author: cchen
 * @create: 2019-03-20 18:29
 */
@Data
public class ShopVO {

    private Long shopId;

    private Long userId;

    private String shopName;

    private Boolean practice;

    private Integer shopAvgScore;

    private Integer shopNum;

    private Integer delivery;

    private Integer shopAdcode;

    private Integer shopCityCode;

    private String shopAdress;

    private String shopPhone;

    private Double shopLongitude;

    private Double shopLatitude;

    private String shopImage;

    private List<String> labelNaem;

}
    