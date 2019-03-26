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

    private Integer avgScore;

    private Integer num;

    private Integer delivery;

}
    