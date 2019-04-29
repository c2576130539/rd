package com.cc.rd.service.shop.impl;

import com.cc.rd.dao.ShopLabelCustomMapper;
import com.cc.rd.dao.ShopLabelMapper;
import com.cc.rd.dto.shop.LabelDTO;
import com.cc.rd.dto.shop.ShopLabelDTO;
import com.cc.rd.entity.ShopLabel;
import com.cc.rd.entity.ShopLabelExample;
import com.cc.rd.request.shop.ShopLabelAddRequest;
import com.cc.rd.service.shop.ShopLabelService;
import com.cc.rd.util.ParamUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @program: ShopLabelServiceImpl
 * @description: 商店标签逻辑实现
 * @author: cchen
 * @create: 2019-03-26 20:13
 */
@Service
public class ShopLabelServiceImpl implements ShopLabelService {

    @Autowired
    private ShopLabelMapper shopLabelMapper;

    @Autowired
    private ShopLabelCustomMapper shopLabelCustomMapper;

    @Override
    public Boolean addShopLabel(ShopLabelAddRequest request) {
        if (CollectionUtils.isEmpty(request.getLabelIdList())) {
            return false;
        }
        shopLabelCustomMapper.insertBatch(request.getShopId(), request.getLabelIdList());
        return true;
    }

    @Override
    public List<Long> listShopId(List<Long> labelIdList) {
        if (CollectionUtils.isEmpty(labelIdList)) {
            return Lists.newArrayList();
        }
        ShopLabelExample example = new ShopLabelExample();
        example.createCriteria().andLabelIdIn(labelIdList).andIsDeletedEqualTo(0);
        List<ShopLabel> shopLabelList = shopLabelMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(shopLabelList)) {
            return Lists.newArrayList();
        }
        return shopLabelList.stream().map(ShopLabel::getShopId).collect(Collectors.toList());
    }

    @Override
    public List<LabelDTO> getLabelByShopId(Long shopId) {
        if (StringUtils.isEmpty(shopId)) {
            return Lists.newArrayList();
        }
        return shopLabelCustomMapper.getLabelByShopId(shopId);
    }

    @Override
    public Map<Long, List<LabelDTO>> getLabelByshopIdList(List<Long> shopId) {
        if (CollectionUtils.isEmpty(shopId)) {
            return null;
        }
        List<ShopLabelDTO> shopLabelDTOList = shopLabelCustomMapper.getLabelByShopIdList(shopId);
        if (CollectionUtils.isEmpty(shopLabelDTOList)) {
            return null;
        }

        return shopLabelDTOList.stream().collect(Collectors.toMap(ShopLabelDTO::getShopId, ShopLabelDTO::getLabelList));
    }

}
    