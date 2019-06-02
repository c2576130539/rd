package com.cc.rd.controller.file;

import com.cc.rd.controller.BaseController;
import com.cc.rd.entity.FileInfo;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.service.file.FileInfoService;
import com.cc.rd.service.file.StorageService;
import com.cc.rd.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: FileController
 * @description: 文件上传下载接口
 * @author: cchen
 * @create: 2019-04-17 22:21
 */
@Api(description = "文件相关接口")
@RestController
public class FileController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    @Qualifier("dbStorage")
    private StorageService storageService;

    @Autowired
    private FileInfoService storedFileService;

    @ApiOperation(value = "上传")
    @PostMapping("/files")
    public JSONResult upload(MultipartFile file) {
        return JSONResult.success(storageService.store(file));
    }

    /**
     * 文件下载, 目前是根据文件名来下载的，之后最好是可以改成根据{@link FileInfo#fileHash}
     *
     * @param fileName {@link FileInfo#originName}
     * @return 文件内容
     */
    @ApiOperation("下载文件")
    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity download(@PathVariable("fileName") String fileName) {
        logger.info("FILE|download|{}", fileName);
        if (StringUtils.isEmpty(fileName)) {
            throw new ManagerException(ErrorCodeEnum.FILE_NAME_NOT_EXIST);
        }

        FileInfo fileInfo = storedFileService.get(fileName);
        if (null == fileInfo
                || Boolean.TRUE.equals(fileInfo.getIsDeleted())
                || StringUtils.isEmpty(fileInfo.getFileHash())) {
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }

        byte[] fileData = storedFileService.getData(fileInfo.getFileHash());
        if (null == fileData || 0 == fileData.length) {
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }

        String originName = fileInfo.getOriginName();

        try {
            originName = URLEncoder.encode(originName, "utf-8");
        } catch (UnsupportedEncodingException ignored) {
        }

        return ResponseEntity.<byte[]>ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + originName)
                .contentType(MediaType.parseMediaType(fileInfo.getFileExt()))
                .contentLength(fileInfo.getFileSize())
                .body(fileData);
    }

    @ApiOperation("删除文件")
    @DeleteMapping("/file/{fileHash}")
    public JSONResult delete(@PathVariable("fileHash") String fileHash) {
        if (!StringUtils.isEmpty(fileHash)) {
            List<String> fileHashs = new ArrayList<>(1);
            fileHashs.add(fileHash);
            storedFileService.delete(fileHashs);
        }
        return JSONResult.success();
    }

}
    