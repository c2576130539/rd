package com.cc.rd.request;

import lombok.Data;

/**
 * @program: PageRequet
 * @description: 分页查询
 * @author: cchen
 * @create: 2019-03-07 22:10
 */
@Data
public class PageRequet {

    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
    