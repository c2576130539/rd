package com.cc.rd.validator;

import com.cc.rd.enums.Constant;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: FastValidator
 * @description: 检验
 * @author: cchen
 * @create: 2019-03-06 18:55
 */
public class FastValidator {

    /**
     * 构建验证器
     *
     * @return
     */
    public static FastValidator start() {
        return new FastValidator();
    }


    /**
     * 验证null
     *
     * @param objects
     */
    public FastValidator notNull(String objects) {

        if (StringUtils.isEmpty(objects)) {
            throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM);
        }

        return this;
    }

    public FastValidator notNull(String objects, String desc) {

        if (StringUtils.isEmpty(objects)) {
            throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM, desc + " can not be null");
        }

        return this;
    }

    /**
     * 所有都不为空
     *
     * @param objects
     * @return
     */
    public FastValidator notAnyNull(String... objects) {

        if (org.apache.commons.lang3.StringUtils.isAnyEmpty(objects)) {
            throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM);
        }

        return this;
    }

    /**
     * 添加验证元素(包含最大小值)
     *
     * @param target
     * @param min
     * @param max
     * @return
     */
    public FastValidator on(Object target, int min, int max) {
        Objects.requireNonNull(target);
        if (target instanceof Integer) {
            int num = (int) target;
            if (num < min || num > max) {
                throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM, "[" + target + "] not in between " + min + " and " + max);
            }
        } else if (target instanceof Long) {
            long num = (long) target;
            if (num < min || num > max) {
                throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM, "[" + target + "] not in between " + min + " and " + max);
            }
        } else if (target instanceof String) {
            String s = (String) target;
            int num = s.length();
            if (num < min || num > max) {
                throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM, "[" + target + "] not in between " + min + " and " + max);
            }
        } else {
            throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM, "target object can not be parsed");
        }

        return this;
    }

    /**
     * 验证最小值
     *
     * @param target
     * @param min
     * @return
     */
    public FastValidator onMin(Object target, int min) {
        return on(target, min, Integer.MAX_VALUE);
    }

    /**
     * 验证最大值
     *
     * @param target
     * @param max
     * @return
     */
    public FastValidator onMax(Object target, int max) {
        return on(target, Integer.MIN_VALUE, max);
    }

    /**
     * 验证手机号码是否符合格式要求
     *
     * @param telphone
     * @return
     */
    public FastValidator regTelphone(String telphone) {
        // 编译正则表达式
        Pattern pattern = Pattern.compile(Constant.DEFAULT_TELPHONE);
        Matcher matcher = pattern.matcher(telphone);
        // 字符串是否与正则表达式相匹配
        if (!matcher.matches()) {
            throw new ManagerException(ErrorCodeEnum.TELPHONE_ERROR);
        }
        return this;
    }
}
    