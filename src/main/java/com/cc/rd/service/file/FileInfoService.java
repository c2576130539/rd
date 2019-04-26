package com.cc.rd.service.file;

import com.cc.rd.entity.FileInfo;

import java.util.List;

/**
 * @program: FileInfoService
 * @description: 文件管理接口
 * @author: cchen
 * @create: 2019-04-26 08:44
 */
public interface FileInfoService {

    FileInfo factoryOf(String originName, Long fileSize, String contentType);

    /**
     * 保存文件
     *
     * @param file
     * @param data
     */
    String save(FileInfo file, byte[] data);

    /**
     * 软删除
     *
     * @param fileId
     */
    void delete(Long fileId);

    /**
     * 软删除
     *
     * @param fileHashs
     */
    void delete(List<String> fileHashs);

    /**
     * 单个文件
     *
     * @param fileId
     * @return
     */
    FileInfo get(Long fileId);

    /**
     * 单个文件 (按文件名)
     *
     * @param originalFileName
     * @return
     */
    FileInfo get(String originalFileName);

    /**
     * 单个文件的内容 用于下载等
     *
     * @param fileId
     * @return
     */
    byte[] getData(Long fileId);

    /**
     * @param hash
     * @return
     */
    byte[] getData(String hash);

    /**
     * 根据hash获取文件名
     *
     * @param hash
     * @return
     */
    String getFileName(String hash);

    String getFileName(String hash,boolean ignoreException);

    List<FileInfo> getFileInfo(List<String> fileHashs);
}