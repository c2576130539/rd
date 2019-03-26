package com.cc.rd.exception;

import com.cc.rd.enums.ErrorCodeEnum;

/**
 * @program: ManagerException
 * @description: 异常抛出
 * @author: cchen
 * @create: 2019-03-05 16:04
 */
public class ManagerException extends RuntimeException {

    private ErrorCodeEnum errorCodeEnum;

    public ManagerException(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }

    public ManagerException(ErrorCodeEnum errorCodeEnum, String edesc) {
        this.errorCodeEnum = errorCodeEnum;
        this.errorCodeEnum.seteDesc(edesc);
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public void setErrorCodeEnum(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }
}
    