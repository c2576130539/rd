package com.cc.rd.service.file.impl;

import com.cc.rd.dao.FileDataMapper;
import com.cc.rd.entity.FileData;
import com.cc.rd.entity.FileDataExample;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.file.FileDataService;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @program: FileDataServiceImpl
 * @description: 文件数据逻辑实现
 * @author: cchen
 * @create: 2019-04-26 08:51
 */
@Service
public class FileDataServiceImpl implements FileDataService {

    @Autowired
    private FileDataMapper dataMapper;

    @Override
    public byte[] getByHash(String fileHash) {
        if (StringUtils.isEmpty(fileHash)) {
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }

        FileDataExample example = new FileDataExample();
        example.createCriteria().andFileHashEqualTo(StringUtils.upperCase(fileHash));

        List<FileData> dataList = dataMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(dataList)) {
            return new byte[0];
        }

        if (dataList.size() > 1) {
            throw new ManagerException(ErrorCodeEnum.FILE_DUPLICATE);
        }

        byte[] data = dataList.get(0).getData();
        return (null == data) ? new byte[0] : data;
    }
}
    