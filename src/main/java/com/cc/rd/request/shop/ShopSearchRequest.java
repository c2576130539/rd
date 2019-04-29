package com.cc.rd.request.shop;

import com.cc.rd.request.UserLocationRequest;
import lombok.Data;

import java.util.List;

/**
 * @program: ShopSearchRequest
 * @description: 搜索店家
 * @author: cchen
 * @create: 2019-03-20 19:54
 */
@Data
public class ShopSearchRequest extends UserLocationRequest {

    private String shopName;

    private List<Long> labelIdList;

    private Integer shopAdcode;

    private Integer shopCityCode;

    /**
     * 评分0降序，1升序
     */
    private Integer shopAvgScore;

    /**
     * 人气0降序，1升序
     */
    private Integer shopNum;

    /**
     * 配送费0升序，1降序
     */
    private Integer delivery;

    private Integer pageNum = 0;

    private Integer pageSize = 20;
}
    