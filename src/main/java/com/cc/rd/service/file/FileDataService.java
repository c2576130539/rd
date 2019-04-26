package com.cc.rd.service.file;

/**
 * @program: FileDataService
 * @description: 文件数据逻辑接口
 * @author: cchen
 * @create: 2019-04-26 08:48
 */
public interface FileDataService {

    /**
     * 根据文件hash获得文件二进制内容
     *
     * @param fileHash hash for the file
     * @return binary file data
     */
    byte[] getByHash(String fileHash);
}