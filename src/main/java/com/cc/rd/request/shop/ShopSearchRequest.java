package com.cc.rd.request.shop;

import com.cc.rd.request.UserLocationRequest;
import lombok.Data;

/**
 * @program: ShopSearchRequest
 * @description: 搜索店家
 * @author: cchen
 * @create: 2019-03-20 19:54
 */
@Data
public class ShopSearchRequest extends UserLocationRequest {

    private String name;

    private Long labelId;

    private Integer adcode;

    private Integer cityCode;
    //评分0降序，1升序
    private Integer avgScore;
    //人气0降序，1升序
    private Integer num;
    //配送费0升序，1降序
    private Integer delivery;

    private Integer pageNum = 0;

    private Integer pageSize = 20;
}
    