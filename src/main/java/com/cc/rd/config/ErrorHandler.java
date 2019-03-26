package com.cc.rd.config;

import com.cc.rd.exception.ManagerException;
import com.cc.rd.util.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: ErrorHandler
 * @description: 异常处理
 * @author: cchen
 * @create: 2019-03-05 16:40
 */
@RestControllerAdvice
public class ErrorHandler {

    private final static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(ManagerException.class)
    public JSONResult handleManagerException(ManagerException ex) {
        Integer code = ex.getErrorCodeEnum().getCode();
        String desc = ex.getErrorCodeEnum().geteDesc();
        logger.error("code={},msg={}", code, desc);
        return new JSONResult(desc, code);
    }
}
    