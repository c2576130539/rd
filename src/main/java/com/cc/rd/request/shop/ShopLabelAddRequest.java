package com.cc.rd.request.shop;

import lombok.Data;

import java.util.List;

/**
 * @program: ShopLabelAddRequest
 * @description: 商店标签添加
 * @author: cchen
 * @create: 2019-04-26 21:16
 */
@Data
public class ShopLabelAddRequest {

    private Long shopId;

    private List<Long> labelIdList;
}
    