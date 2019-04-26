package com.cc.rd.vo.file;

import lombok.Data;

/**
 * @program: FileVO
 * @description: 文件前端显示
 * @author: cchen
 * @create: 2019-04-17 22:25
 */
@Data
public class FileVO {

    private String hash;
    private String originName;
    private Long fileSize;

}
    