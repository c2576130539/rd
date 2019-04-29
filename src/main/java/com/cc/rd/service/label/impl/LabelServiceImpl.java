package com.cc.rd.service.label.impl;

import com.cc.rd.dao.LabelMapper;
import com.cc.rd.entity.Label;
import com.cc.rd.entity.LabelExample;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.label.LabelService;
import com.cc.rd.util.DateTimeUtils;
import com.cc.rd.vo.label.LabelVO;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @program: LabelServiceImpl
 * @description: 标签
 * @author: cchen
 * @create: 2019-04-27 08:00
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;


    @Override
    public Boolean addLabel(String labelName, Long userId) {
        if (!StringUtils.isEmpty(labelName)) {
            throw new ManagerException(ErrorCodeEnum.INVALID_INPUT_PARAM);
        }
        if (isExistLabel(labelName)) {
            throw new ManagerException((ErrorCodeEnum.LABEL_NAME_EXIST));
        }
        Label label = new Label();
        label.setContent(labelName);
        label.setCreatorUserId(userId);
        label.setCreationTime(DateTimeUtils.utcNow());
        labelMapper.insertSelective(label);
        return true;
    }

    @Override
    public List<LabelVO> getAllLabel() {
        List<LabelVO> labelVOList = Lists.newArrayList();
        LabelExample example = new LabelExample();
        example.createCriteria().andIsDeletedEqualTo(0);
        //数据库所有标签
        List<Label> labelList = labelMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(labelList)) {
            return labelVOList;
        }
        labelList.stream().forEach(l -> {
            LabelVO labelVO = new LabelVO();
            labelVO.setLabelId(l.getId());
            labelVO.setLabelName(l.getContent());
            labelVO.setLabelNum(l.getNum());
            labelVOList.add(labelVO);
        });
        return labelVOList;
    }

    /**
     * 是否存在
     * @param labelName
     * @return
     */
    private Boolean isExistLabel(String labelName) {
        LabelExample example = new LabelExample();
        example.createCriteria()
                .andIsDeletedEqualTo(0)
                .andContentEqualTo(labelName);
        List<Label> labelList = labelMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(labelList)) {
            return false;
        }
        return true;
    }
}
    