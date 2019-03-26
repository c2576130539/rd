package com.cc.rd.service.shop;

import com.cc.rd.request.shop.ShopAddRequest;
import com.cc.rd.request.shop.ShopSearchRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @program: ShopService
 * @description: 店家逻辑接口
 * @author: cchen
 * @create: 2019-03-18 05:12
 */
public interface ShopService {

    /**
     * 添加商店
     * @param request
     * @param userId
     */
    void addShop(ShopAddRequest request, Long userId);

    /**
     * 搜索商店
     * @param request
     * @return
     */
    PageInfo listShopSearch(ShopSearchRequest request);

}