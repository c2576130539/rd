package com.cc.rd.service.shop.impl;

import com.cc.rd.dao.ShopLabelMapper;
import com.cc.rd.entity.ShopLabel;
import com.cc.rd.entity.ShopLabelExample;
import com.cc.rd.service.shop.ShopLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
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

    @Override
    public List<Long> listShopId(Long labelId) {
        ShopLabelExample example = new ShopLabelExample();
        example.createCriteria().andLabelIdEqualTo(labelId).andIsDeletedEqualTo(0);
        List<ShopLabel> shopLabelList = shopLabelMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(shopLabelList)) {
            return null;
        }
        return shopLabelList.stream().map(ShopLabel::getShopId).collect(Collectors.toList());
    }
}
    