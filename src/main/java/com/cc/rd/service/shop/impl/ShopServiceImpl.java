package com.cc.rd.service.shop.impl;

import com.cc.rd.dao.ShopMapper;
import com.cc.rd.entity.ShopExample;
import com.cc.rd.request.shop.ShopAddRequest;
import com.cc.rd.request.shop.ShopSearchRequest;
import com.cc.rd.service.shop.ShopService;
import com.cc.rd.vo.shop.ShopVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void addShop(ShopAddRequest request) {

    }

    @Override
    public List<ShopVO> listShop(ShopSearchRequest request) {
        ShopExample example = new ShopExample();
        ShopExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isEmpty(request.getName())) {
            criteria.andNameLike('%' + request.getName() + '%');
        }
        if (null != request.getAdcode()) {
            criteria.andCityCodeEqualTo(request.getAdcode());
        }
        if (null != request.getCityCode()) {
            criteria.andCityCodeEqualTo(request.getCityCode());
        }
        //按什么顺序排
        if (null != request.getAvgScore()) {

        } else if (null != request.getDelivery()) {

        } else if (null != request.getNum()) {

        }
        criteria.andIsDeletedEqualTo(0);
        if (null != request.getLabelId()) {

        }
        //shopMapper.selectByExample()
        return null;
    }
}


