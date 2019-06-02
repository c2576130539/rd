package com.cc.rd.enums;

/**
 * @program: Constant
 * @description: 常量
 * @author: cchen
 * @create: 2019-03-06 22:34
 */
public class Constant {

    // 默认五分钟过期
    public static final Long DEFAULT_TTL = 1000 * 60 * 5L;

    public static final Integer DEFAULT_CODE_LENGTH = 4;

    public static final String APP_NAME = "rd";

    public static final String USER_NAME = "新人";

    public static final Integer PASSWORD_ERROR_NUMBER = 5;

    public static final String ERROR_NUM = "errnum";

    public static final Integer SEND_CODE_NUMBER = 3;

    public static final String DEFAULT_TELPHONE = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    /**
     * 内部服务令牌
     */
    public static final String INTERNAL_TOKEN = "19970222";

    public static final String REDIS_PREFIX_LOGGED_OUT_USER = "logout_user_";

    // 登出的用户, 在Redis里面记录多久他的用户名 (在这么多天内, 除非重新登陆, 否则无法访问系统)
    public static final Integer ONE_MONTHS = 30;

    public static final Integer ONE_DAY = 24;

    public static final Integer ONE_HOUR = 60;

    /**
     * 一分钟多少毫秒
     */
    public static final Long MINS = 60 * 1000L;

    /**
     * 一小时多少毫秒
     */
    public static final Long HOURS = ONE_HOUR * MINS;

    /**
     * 一天多少毫秒
     */
    public static final Long DAYS = ONE_DAY * HOURS;

    /**
     * 一个月多少毫秒
     */
    public static final Long MONTHS = ONE_MONTHS * DAYS;

    /**
     * 密码长度
     */
    public static final Integer MIN_PWD = 8;
    public static final Integer MAX_PWD = 16;
}
    