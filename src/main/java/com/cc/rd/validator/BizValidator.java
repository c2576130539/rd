package com.cc.rd.validator;

import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: BizValidator
 * @description: 数据库中数据是否存在
 * @author: cchen
 * @create: 2019-03-07 22:52
 */
@Component
public class BizValidator {

    @Autowired
    private UserService userService;

    /**
     *验证用户是否存在，存在报错，不存在则正确
     */
    public Boolean isExistUser(Long userId, String telphone, String emailAdress) {
        User user = userService.getUser(userId, telphone, emailAdress);
        if (null != user) {
            throw new ManagerException(ErrorCodeEnum.USER_EXIST);
        }
        return true;
    }
}
    