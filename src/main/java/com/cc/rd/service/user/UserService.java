package com.cc.rd.service.user;

import com.cc.rd.dto.UserDto;
import com.cc.rd.entity.User;

/**
 * @program: UserService
 * @description: 用户表逻辑接口
 * @author: cchen
 * @create: 2019-03-05 16:49
 */
public interface UserService {

    /**
     * @author: cchen
     * @Date 5:25 PM 2019/3/5
     * @program: authenticationSource,userName,nickName,
     gender,telphone,password,emailAddress,creatorUserId;
     * @description: 添加用户
     * @return: void
     */
    void addUser(UserDto userDto);

    /**
     * @author: cchen
     * @Date 10:51 PM 2019/3/6
     * @program:
     * @description: 根据用户id/telphone/email 来找用户信息
     * @return: com.cc.rd.entity.User
     */
    User getUser(Long userId, String telphone, String emailAddress);


    void UpdateUser(UserDto userDto);
}