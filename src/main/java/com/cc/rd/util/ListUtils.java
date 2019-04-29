package com.cc.rd.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 有时候lamda表达式太长 就放到这个类里面 让业务代码精简一些
 */
public class ListUtils {

    /**
     * 解决sql查询 in最大数据1000分割list
     * @param list
     * @param len
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int len) {
        if (list == null || list.size() < 0 || len < 1)
            return null;
        List<List<T>> result = new ArrayList<List<T>>();
        int size = list.size();
        int count = (size + len - 1) / len;
        for (int i = 0; i < count; i ++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : (i + 1) * len));
            result.add(subList);
        }
        return result;
    }
}
