package com.cc.rd.service.user;

/**
 * @program: LogOutService
 * @description: 退出登录接口
 * @author: cchen
 * @create: 2019-03-08 15:21
 */
public interface LogOutService {

    /**
     * 设置用户为已登出状态
     * @param userId
     * @return
     */
    Boolean setLogoutStatus(String userId);

    /**
     * 清除用户的已登出状态
     * @param userId
     * @return
     */
    Boolean clearLogoutStatus(String userId);

    /**
     * 用户是否是已经登出的状态
     *
     * @param userId
     * @return
     */
    Boolean isLoggedOut(String userId);
}
