package com.cc.rd.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: RandomUtils
 * @description: 随机数
 * @author: cchen
 * @create: 2019-03-07 10:16
 */
public class RandomUtils {
    private RandomUtils() {
    }


    private static final String BASE_NUM = "1234567890";
    private static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUEWXYZ";
    private static final String ALPHABET_LOWER = "abcdefghijklmnopqrstuewxyz";
    private static final String ALPHABET = ALPHABET_UPPER + ALPHABET_LOWER;

    public static ThreadLocalRandom random() {
        return ThreadLocalRandom.current();
    }

    /**
     * 获取指定字符串
     *
     * @param length   长度
     * @param bound    边界
     * @param alphabet 字符串
     * @return
     */
    public static String nextString(int length, int bound, String alphabet) {
        if (length <= 0) {
            throw new IllegalArgumentException("length must be positive");
        }
        StringBuilder next = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num = random().nextInt(bound);
            char c = alphabet.charAt(num);
            next.append(c);
        }
        return next.toString();
    }

    public static String nextUpperString(int length) {
        return nextString(length, 26, ALPHABET_UPPER);
    }

    public static String nextLowerString(int length) {
        return nextString(length, 26, ALPHABET_LOWER);
    }

    /**
     * 获取指定长度的数字
     *
     * @param length
     * @return
     */
    public static int nextInt(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("length must be positive");
        }
        double a = length - 1;
        double b = length;
        int origin = new Double(Math.pow(10, a)).intValue();
        int bound = new Double(Math.pow(10, b)).intValue();
        return random().nextInt(origin, bound);
    }

}
    