package com.cc.rd.vo;

import lombok.Data;

/**
 * @program: PageVO
 * @description: 分页数据
 * @author: cchen
 * @create: 2019-03-26 21:14
 */
@Data
public class PageVO {

    private int limit;

    private int offset;

    private long total;
}
    