package com.cc.rd.controller.order;

import com.cc.rd.controller.BaseController;
import com.cc.rd.request.order.OrderAddRequest;
import com.cc.rd.request.order.OrderSearchRequest;
import com.cc.rd.service.order.OrderService;
import com.cc.rd.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rd
 * @description: 订单接口
 * @author: cchen
 * @create: 2019-05-06 11:33
 */

@Api(description = "订单接口")
@RestController
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "添加订单")
    @PostMapping("/orders")
    public JSONResult addOrder(@RequestBody OrderAddRequest request) {
        orderService.addOrder(request, Long.valueOf(getUserId()));
        return JSONResult.success();
    }

    @ApiOperation(value = "获取所有拼团活动")
    @GetMapping("/orders")
    public JSONResult getList(OrderSearchRequest request) {
        return JSONResult.success(orderService.listOrderSearch(request));
    }
}
