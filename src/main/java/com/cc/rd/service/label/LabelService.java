package com.cc.rd.service.label;

import com.cc.rd.dto.shop.LabelDTO;
import com.cc.rd.vo.label.LabelVO;

import java.util.List;

/**
 * @program: LabelService
 * @description: 标签
 * @author: cchen
 * @create: 2019-04-27 07:59
 */
public interface LabelService {

    /**
     * 添加标签
     * @param labelName
     * @param userId
     * @return
     */
    Boolean addLabel(String labelName, Long userId);

    /**
     * 获取数据库中所有标签
     * @return
     */
    List<LabelVO> getAllLabel();

}