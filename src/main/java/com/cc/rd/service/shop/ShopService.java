package com.cc.rd.service.shop;

import com.cc.rd.request.shop.ShopAddRequest;
import com.cc.rd.request.shop.ShopSearchRequest;
import com.cc.rd.vo.shop.ShopVO;

import java.util.List;

/**
 * @program: ShopService
 * @description: 店家逻辑接口
 * @author: cchen
 * @create: 2019-03-18 05:12
 */
public interface ShopService {

    void addShop(ShopAddRequest request);

    List<ShopVO> listShop(ShopSearchRequest request);

}