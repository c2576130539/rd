package com.cc.rd.service.file.impl;

import com.alibaba.fastjson.JSON;
import com.cc.rd.dao.FileDataMapper;
import com.cc.rd.dao.FileInfoMapper;
import com.cc.rd.entity.FileData;
import com.cc.rd.entity.FileDataExample;
import com.cc.rd.entity.FileInfo;
import com.cc.rd.entity.FileInfoExample;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.file.FileDataService;
import com.cc.rd.service.file.FileInfoService;
import com.cc.rd.util.DateTimeUtils;
import com.cc.rd.util.MD5Utils;
import com.cc.rd.validator.FileInfoValidator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @program: FileInfoServiceImpl
 * @description: 文件管理逻辑接口实现
 * @author: cchen
 * @create: 2019-04-26 08:44
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    private static final Logger logger = LoggerFactory.getLogger(FileInfoServiceImpl.class);

    @Autowired
    private FileInfoMapper fileMapper;

    @Autowired
    private FileDataMapper dataMapper;

    @Autowired
    private FileInfoValidator validator;

    @Autowired
    private FileDataService dataService;

    @Override
    public FileInfo factoryOf(String originName, Long fileSize, String contentType) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setOriginName(originName);
        fileInfo.setDisplayName(originName);
        fileInfo.setIsDeleted(false);
        fileInfo.setCreatedAt(DateTimeUtils.utcNow());
        fileInfo.setUpdatedAt(DateTimeUtils.utcNow());
        fileInfo.setFileSize(fileSize);
        fileInfo.setFileExt(contentType);
        return fileInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String save(FileInfo file, byte[] data) {
        logger.info("FILE|save|S|{}|dataSize:{}", file, data.length);
        validator.beforeSave(file, data);

        String hash = MD5Utils.encodeMD5(file.getOriginName() + ":" + DateTimeUtils.utcNow());
        file.setFileHash(hash);
        fileMapper.insert(file);

        logger.info("FILE|save|-|fileInfoSaved|{}", file);

        FileData fileData = new FileData();
        fileData.setData(data);
        fileData.setFileHash(hash);
        dataMapper.insert(fileData);
        logger.info("FILE|save|Y|{}", file);
        return hash;
    }

    @Override
    public void delete(Long fileId) {
        logger.info("FILE|delete|S|{}", fileId);
        validator.beforeDelete(fileId);
        FileInfo file = fileMapper.selectByPrimaryKey(fileId);
        if (null == file || file.getIsDeleted()) {
            return;
        }

        FileInfo record = new FileInfo();
        record.setId(fileId);
        record.setIsDeleted(true);
        fileMapper.updateByPrimaryKeySelective(record);
        logger.info("FILE|delete|Y|{}", fileId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<String> fileHashs) {
        logger.info("FILE|delete|S|{}", JSON.toJSON(fileHashs));
        FileInfoExample example = new FileInfoExample();
        example.createCriteria().andFileHashIn(fileHashs).andIsDeletedEqualTo(false);

        FileInfo record = new FileInfo();
        record.setIsDeleted(true);

        fileMapper.updateByExampleSelective(record, example);

        FileDataExample fileDataExample = new FileDataExample();
        fileDataExample.createCriteria().andFileHashIn(fileHashs);
        dataMapper.deleteByExample(fileDataExample);
        logger.info("FILE|delete|Y|{}", JSON.toJSON(fileHashs));
    }

    @Override
    public FileInfo get(Long fileId) {
        validator.beforeGet(fileId);
        return fileMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public FileInfo get(String originalFileName) {
        FileInfoExample example = new FileInfoExample();
        example.createCriteria().andOriginNameEqualTo(originalFileName).andIsDeletedEqualTo(false);
        example.setOrderByClause(" updated_at desc ");

        List<FileInfo> fileInfoList = fileMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(fileInfoList) ||
                Boolean.TRUE.equals(fileInfoList.get(0).getIsDeleted())) {
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }
        return fileInfoList.get(0);
    }

    @Override
    public byte[] getData(Long fileId) {
        FileInfo f = get(fileId);

        if (null == f || f.getIsDeleted()) {
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }

        if (StringUtils.isEmpty(f.getFileHash())) {
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }

        return dataService.getByHash(f.getFileHash());
    }

    @Override
    public byte[] getData(String hash) {

        if (StringUtils.isEmpty(hash)) {
            return new byte[0];
        }

        logger.info("FILE|getData|S|{}", hash);
        FileDataExample example = new FileDataExample();
        example.createCriteria().andFileHashEqualTo(hash);
        example.setOrderByClause(" id desc ");

        List<FileData> files = dataMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(files)) {
            logger.info("FILE|getData|E|empty|{}", hash);
            return new byte[0];
        }

        logger.info("FILE|getData|-|{}", files.size());
        byte[] data = files.get(0).getData();
        logger.info("FILE|getData|-|{}", files.get(0).getData().length);
        return data;
    }


    @Override
    public String getFileName(String hash) {
        return getFileName(hash, false);
    }

    @Override
    public String getFileName(String hash, boolean ignoreException) {
        FileInfoExample example = new FileInfoExample();
        FileInfoExample.Criteria c = example.createCriteria();
        c.andIsDeletedEqualTo(false);
        c.andFileHashEqualTo(hash);
        List<FileInfo> fileInfoList = fileMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(fileInfoList)) {
            if (ignoreException) {
                return StringUtils.EMPTY;
            }
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }
        return fileInfoList.get(0).getOriginName();
    }

    @Override
    public List<FileInfo> getFileInfo(List<String> fileHashs) {
        FileInfoExample example = new FileInfoExample();
        example.createCriteria().andFileHashIn(fileHashs).andIsDeletedEqualTo(false);
        example.setOrderByClause(" updated_at desc ");
        return fileMapper.selectByExample(example);
    }
}
    