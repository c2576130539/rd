package com.cc.rd.controller.order;

import com.cc.rd.controller.BaseController;
import com.cc.rd.entity.OrderInvitees;
import com.cc.rd.request.order.OrderAddRequest;
import com.cc.rd.service.order.OrderInviteesService;
import com.cc.rd.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rd
 * @description: 参与人
 * @author: cchen
 * @create: 2019-05-24 14:17
 */
@Api(description = "接口")
@RestController
public class OrderInviteesController extends BaseController {

    @Autowired
    private OrderInviteesService orderInviteesService;

    @ApiOperation(value = "添加订单")
    @PostMapping("/orders/invitees")
    public JSONResult addOrder(String eventId) {
        orderInviteesService.addInvitees(Long.valueOf(getUserId()), eventId);
        return JSONResult.success();
    }
}
