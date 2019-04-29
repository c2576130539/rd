package com.cc.rd.controller.shop;

import com.cc.rd.controller.BaseController;
import com.cc.rd.request.shop.ShopAddRequest;
import com.cc.rd.request.shop.ShopLabelAddRequest;
import com.cc.rd.request.shop.ShopSearchRequest;
import com.cc.rd.service.shop.ShopLabelService;
import com.cc.rd.service.shop.ShopService;
import com.cc.rd.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ShopController
 * @description: 商店相关操作
 * @author: cchen
 * @create: 2019-03-26 20:47
 */
@Api(description = "商店相关操作")
@RestController
public class ShopController extends BaseController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopLabelService shopLabelService;

    @ApiOperation(value = "添加商店")
    @PostMapping("/shops")
    public JSONResult addShop(@RequestBody ShopAddRequest request) {
        return JSONResult.success(shopService.addShop(request, Long.valueOf(getUserId())));
    }

    @ApiOperation(value = "搜索商店")
    @PostMapping("/shops/search")
    public JSONResult searchShop(@RequestBody ShopSearchRequest request) {
        return JSONResult.success(shopService.listShopSearch(request));
    }

    @ApiOperation(value = "添加商店标签")
    @PostMapping("/shops/labels")
    public JSONResult addShopLabel(@RequestBody ShopLabelAddRequest request) {
        return JSONResult.success(shopLabelService.addShopLabel(request));
    }

}
    