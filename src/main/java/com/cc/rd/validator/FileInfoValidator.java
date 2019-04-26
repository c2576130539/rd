package com.cc.rd.validator;

import com.cc.rd.entity.FileInfo;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import com.cc.rd.util.ParamUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @program: FileInfoValidator
 * @description: 文件校验
 * @author: cchen
 * @create: 2019-04-26 09:03
 */
@Component
public class FileInfoValidator {

    public void beforeSave(FileInfo fileInfo, byte[] data) {
        if (null == fileInfo) {
            throw new ManagerException(ErrorCodeEnum.FILE_NOT_EXIST);
        }

        if (StringUtils.isEmpty(fileInfo.getOriginName())) {
            throw new ManagerException(ErrorCodeEnum.FILE_NAME_NOT_EXIST);
        }

        if (null == data) {
            throw new ManagerException(ErrorCodeEnum.FILE_DATA_NOT_EXIST);
        }
    }

    public void beforeDelete(Long id) {
        if (ParamUtils.isNotLegalId(id)) {
            throw new ManagerException(ErrorCodeEnum.FILE_DUPLICATE);
        }
    }

    public void beforeGet(Long id) {
        if (ParamUtils.isNotLegalId(id)) {
            throw new ManagerException(ErrorCodeEnum.FILE_DUPLICATE);
        }
    }

}

    