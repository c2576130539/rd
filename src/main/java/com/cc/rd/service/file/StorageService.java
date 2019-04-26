package com.cc.rd.service.file;

import com.cc.rd.vo.file.FileVO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @program: StorageService
 * @description: db
 * @author: cchen
 * @create: 2019-04-26 09:18
 */
public interface StorageService {

    default void changeFolderPermission(File dirFile) throws IOException {
        Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);

        Path path = Paths.get(dirFile.getAbsolutePath());
        Files.setPosixFilePermissions(path, perms);

    }

    void init();

    FileVO store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    void delete(String fileName);
}