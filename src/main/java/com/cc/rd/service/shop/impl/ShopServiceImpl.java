package com.cc.rd.service.shop.impl;

import com.cc.rd.dao.ShopMapper;
import com.cc.rd.entity.Shop;
import com.cc.rd.entity.ShopExample;
import com.cc.rd.entity.ShopLabel;
import com.cc.rd.request.shop.ShopAddRequest;
import com.cc.rd.request.shop.ShopLabelAddRequest;
import com.cc.rd.request.shop.ShopSearchRequest;
import com.cc.rd.service.shop.ShopLabelService;
import com.cc.rd.service.shop.ShopService;
import com.cc.rd.util.DateTimeUtils;
import com.cc.rd.util.PageUtils;
import com.cc.rd.validator.FastValidator;
import com.cc.rd.vo.shop.ShopVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ShopServiceImpl
 * @description: 店家逻辑接口实现
 * @author: cchen
 * @create: 2019-03-16 10:50
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ShopLabelService shopLabelService;

    @Override
    public Boolean addShop(ShopAddRequest request, Long userId) {
        FastValidator.start().notNull(request.getShopName())
                .notNull(request.getShopAdress());
        Shop shop = new Shop();
        BeanUtils.copyProperties(request, shop);
        shop.setCreateAt(DateTimeUtils.utcNow());
        shop.setCreateBy(userId);
        shopMapper.insertSelective(shop);
        if (!CollectionUtils.isEmpty(request.getLabelIdList())) {
            ShopLabelAddRequest request1 = new ShopLabelAddRequest();
            request1.setLabelIdList(request.getLabelIdList());
            request1.setShopId(shop.getId());
            shopLabelService.addShopLabel(request1);
        }
        return true;
    }

    @Override
    public PageInfo listShopSearch(ShopSearchRequest request) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isEmpty(request.getShopName())) {
            criteria.andShopNameLike('%' + request.getShopName() + '%');
        }
        if (null != request.getShopAdcode()) {
            criteria.andShopAdcodeEqualTo(request.getShopAdcode());
        }
        if (null != request.getShopCityCode()) {
            criteria.andShopCityCodeEqualTo(request.getShopCityCode());
        }
        if (!CollectionUtils.isEmpty(request.getLabelIdList())) {
            List<Long> shopIdList = shopLabelService.listShopId(request.getLabelIdList());
            criteria.andIdIn(shopIdList);
        }
        criteria.andIsDeletedEqualTo(0);
        //按开业升序
        StringBuffer orderBy = new StringBuffer("`practice` ASC");
        //默认按销量降序
        if (null != request.getShopNum()) {
            if (request.getShopNum() == 1) {
                orderBy.append(", `shop_num` DESC");
            } else {
                orderBy.append(", `shop_num` ASC");
            }
        } else {
            orderBy.append(", `shop_num` DESC");
        }
        if (null != request.getShopAvgScore()) {
            if (request.getShopAvgScore() == 1) {
                orderBy.append(", `shop_avg_score` DESC");
            } else {
                orderBy.append(", `shop_avg_score` ASC");
            }
        }
        if (null != request.getDelivery()) {
            if (request.getDelivery() == 0) {
                orderBy.append(", `delivery` DESC");
            } else {
                orderBy.append(", `delivery` ASC");
            }
        }
        List<ShopVO> shopVOList = new ArrayList<>();
        PageInfo<ShopVO> pageInfo = PageHelper.startPage(request.getPageNum(), request.getPageSize())
                .doSelectPageInfo(() -> shopMapper.selectByExample(example));
        BeanUtils.copyProperties(pageInfo.getList(), shopVOList);
        return PageUtils.toPageInfo(shopVOList, pageInfo);
    }
}


