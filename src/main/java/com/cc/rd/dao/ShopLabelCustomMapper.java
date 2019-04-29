package com.cc.rd.dao;

import com.cc.rd.dto.shop.LabelDTO;
import com.cc.rd.dto.shop.ShopLabelDTO;
import com.cc.rd.entity.ShopLabel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: ShopLabelCustomMapper
 * @description: 自定义
 * @author: cchen
 * @create: 2019-04-26 21:24
 */
@Mapper
public interface ShopLabelCustomMapper {

    /**
     * 批量插入商店标签
     * @param shopId
     * @param labelIdList
     */
    void insertBatch(@Param("shopId") Long shopId, @Param("labelIdList") List<Long> labelIdList);

    /**
     * 根据商家Id 查询商家标签信息
     * @param shopId
     * @return
     */
    List<LabelDTO> getLabelByShopId(@Param("shopId") Long shopId);

    /**
     * 批量查询
     * @param shopIdList
     * @return
     */
    List<ShopLabelDTO> getLabelByShopIdList(@Param("shopIdList") List<Long> shopIdList);
}