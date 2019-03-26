package com.cc.rd.service.shop;

import java.util.List;

/**
 * @program: ShopLabelService
 * @description: 商店标签逻辑接口
 * @author: cchen
 * @create: 2019-03-26 20:14
 */
public interface ShopLabelService {

    /**
     * 根据标签寻找商家
     * @param labelId
     * @return
     */
    List<Long> listShopId(Long labelId);
}