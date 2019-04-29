package com.cc.rd.service.shop;

import com.cc.rd.dto.shop.LabelDTO;
import com.cc.rd.request.shop.ShopLabelAddRequest;

import java.util.List;
import java.util.Map;

/**
 * @program: ShopLabelService
 * @description: 商店标签逻辑接口
 * @author: cchen
 * @create: 2019-03-26 20:14
 */
public interface ShopLabelService {


    Boolean addShopLabel(ShopLabelAddRequest request);

    /**
     * 根据标签寻找商家
     * @param labelIdList
     * @return
     */
    List<Long> listShopId(List<Long> labelIdList);

    /**
     * 根据商家Id 找到商家的标签信息
     * @param shopId
     * @return
     */
    List<LabelDTO> getLabelByShopId(Long shopId);

    /**
     * 多个商家Id 找到对应商家的标签信息
     * @param shopId
     * @return
     */
    Map<Long, List<LabelDTO>> getLabelByshopIdList(List<Long> shopId);
}