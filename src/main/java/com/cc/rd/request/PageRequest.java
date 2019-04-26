package com.cc.rd.request;

import lombok.Data;

/**
 * @program: PageRequest
 * @description: 分页查询请求参数
 * @author: cchen
 * @create: 2019-03-26 21:20
 */
@Data
public class PageRequest {

    private Integer pageNum;

    private Integer pageSize;
}
    