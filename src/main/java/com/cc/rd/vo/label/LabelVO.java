package com.cc.rd.vo.label;

import lombok.Data;

/**
 * @program: LabelVO
 * @description: 标签返回前端
 * @author: cchen
 * @create: 2019-04-27 08:08
 */
@Data
public class LabelVO {

    private Long labelId;

    private String labelName;

    /**
     * 使用次数
     */
    private Long labelNum;
}
    