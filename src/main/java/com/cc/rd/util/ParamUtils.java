package com.cc.rd.util;

import java.util.Objects;

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

    /**
     * 添加验证元素(包含最大小值)
     *
     * @param target
     * @param min
     * @param max
     * @return
     */
    public static boolean isRightLength(Object target, int min, int max) {
        if (null == target) {
            return false;
        }
        if (target instanceof Integer) {
            int num = (int) target;
            if (num < min || num > max) {
                return false;
            }
        } else if (target instanceof Long) {
            long num = (long) target;
            if (num < min || num > max) {
                return false;
            }
        } else if (target instanceof String) {
            String s = (String) target;
            int num = s.length();
            if (num < min || num > max) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
    