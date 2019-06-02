package com.cc.rd.service.order.impl;

import com.cc.rd.dao.OrderInviteesMapper;
import com.cc.rd.entity.OrderInvitees;
import com.cc.rd.entity.User;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.order.OrderInviteesService;
import com.cc.rd.service.user.UserService;
import com.cc.rd.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: OrderInviteesServiceImpl
 * @description: 参与人逻辑实现
 * @author: cchen
 * @create: 2019-03-29 13:18
 */
@Service
public class OrderInviteesServiceImpl implements OrderInviteesService {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderInviteesMapper orderInviteesMapper;

    @Override
    public void addInvitees(Long userId, String orderId) {

        User user = userService.getUser(userId, null, null);
        if (user == null) {
            throw new ManagerException(ErrorCodeEnum.USER_NOT_EXIST);
        }
        OrderInvitees orderInvitees = new OrderInvitees();
        orderInvitees.setUserId(userId);
        orderInvitees.setEventId(orderId);
        orderInvitees.setResponseTime(DateTimeUtils.utcNow());
        orderInvitees.setResponseType(1);
        orderInviteesMapper.insertSelective(orderInvitees);
    }
}
    