package com.cc.rd.service.file.impl;

import com.cc.rd.entity.FileInfo;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.file.FileInfoService;
import com.cc.rd.service.file.StorageService;
import com.cc.rd.util.DateTimeUtils;
import com.cc.rd.vo.file.FileVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @program: StorageServiceImpl
 * @description:
 * @author: cchen
 * @create: 2019-04-26 09:20
 */
@Service("dbStorage")
public class StorageServiceImpl implements StorageService {

    @Autowired
    private FileInfoService fileService;

    @Override
    public void init() {
    }

    @Override
    public FileVO store(MultipartFile file) {

        if (null == file || file.isEmpty()) {
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }

        String originName = file.getOriginalFilename();
        if (StringUtils.isEmpty(originName)) {
            originName = file.getName();
        }

        if (StringUtils.isEmpty(originName)) {
            throw new ManagerException(ErrorCodeEnum.FILE_NAME_NOT_EXIST);
        }

        try {
            originName = originName.replace("%", "").replace("#", "").replaceAll(" ","");
            // 检查是否有重名
            FileInfo existedFileInfo = fileService.get(originName);
            if (null != existedFileInfo) {
                originName = getRenameForDuplicate(originName);
            }
        } catch (ManagerException ignored) {
        }

        String hash = "";
        try {
            hash = fileService.save(fileService.factoryOf(originName, file.getSize(), file.getContentType()), file.getBytes());
        } catch (IOException ioe) {
            throw new ManagerException(ErrorCodeEnum.FILE_SAVE_FAILED);
        }
        FileVO fileVO = new FileVO();
        fileVO.setOriginName(originName);
        fileVO.setHash(hash);
        fileVO.setFileSize(file.getSize());
        return fileVO;
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public void delete(String fileName) {
        // db存储可以暂时不删除文件
    }

    private static String getRenameForDuplicate(String originName) {

        if (!StringUtils.contains(originName, ".")) {
            return originName + "-" + DateTimeUtils.utcNow();
        }

        String n = StringUtils.substringBeforeLast(originName, ".");
        String ext = StringUtils.substringAfterLast(originName, ".");
        return n + "-" + DateTimeUtils.utcNow() + "." + ext;
    }
}
    