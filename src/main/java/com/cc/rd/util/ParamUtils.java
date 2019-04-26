package com.cc.rd.util;

/**
 * @program: ParamUtils
 * @description: 校验数据
 * @author: cchen
 * @create: 2019-04-26 09:00
 */
public class ParamUtils {

    /**
     * 为空
     * @param object
     * @return
     */
    public static boolean isNull(Object object) {
        return null == object;
    }

    /**
     * 非空
     * @param object
     * @return
     */
    public static boolean isNotNull(Object object) {
        return null != object;
    }

    /**
     * 大于0
     * @param n
     * @return
     */
    public static boolean isGt0(Number n) {
        return null != n && n.longValue() > 0;
    }

    /**
     * 不小于0
     * @param n
     * @return
     */
    public static boolean isGtOrEq0(Number n) {
        return null != n && n.longValue() >= 0;
    }

    /**
     * 不是合法的ID
     *
     * @param n
     * @return
     */
    public static boolean isNotLegalId(Number n) {
        return !isGt0(n);
    }

    /**
     * 是合法的ID
     *
     * @param n
     * @return
     */
    public static boolean isLegalId(Number n) {
        return isGt0(n);
    }
}
    