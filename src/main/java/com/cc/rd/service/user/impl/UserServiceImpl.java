package com.cc.rd.service.user.impl;

import com.cc.rd.dao.UserMapper;
import com.cc.rd.dto.UserDto;
import com.cc.rd.entity.User;
import com.cc.rd.entity.UserExample;
import com.cc.rd.service.user.UserService;
import com.cc.rd.util.DateTimeUtils;
import com.cc.rd.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @program: UserServiceImpl
 * @description: 用户表逻辑实现
 * @author: cchen
 * @create: 2019-03-05 18:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        //密码用小写 加密
        user.setPassword(MD5Utils.encodeMD5(userDto.getPassword()));
        user.setCreationTime(DateTimeUtils.utcNow());
        user.setIsDeleted(0);
        userMapper.insertSelective(user);
    }

    @Override
    public User getUser(Long userId, String telphone, String emailAddress) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (null != userId) {
            criteria.andIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(telphone)) {
            criteria.andTelphoneEqualTo(telphone);
        }
        if (!StringUtils.isEmpty(emailAddress)) {
            criteria.andEmailAddressEqualTo(emailAddress);
        }
        criteria.andIsDeletedEqualTo(0);
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

    @Override
    public void UpdateUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
    