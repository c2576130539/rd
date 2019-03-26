package com.cc.rd.util;

import org.springframework.http.HttpStatus;

import java.util.Objects;

/**
 * @program: JSONResult
 * @description: restful
 * @author: cchen
 * @create: 2019-03-05 15:18
 */
public class JSONResult {

    private int code;
    private boolean success;
    private Object result;
    private Object error;

    public JSONResult(Object result, boolean success) {
        this.result = result;
        this.success = success;
    }

    public JSONResult(int code, Object result, boolean success) {
        this.code = code;
        this.result = result;
        this.success = success;
    }

    public static JSONResult result(Object result, boolean success) {
        return new JSONResult(result,success);
    }

    public static JSONResult success(Object result) {
        return new JSONResult(HttpStatus.OK.value(),result, true);
    }

    public static JSONResult success() {
        return success(null);
    }

    public static JSONResult fail(Object error) {
        JSONResult result = result(null, false);
        result.error = error;
        return result;
    }

    public JSONResult(Object result, boolean success, Object error) {
        this.result = result;
        this.success = success;
        this.error = error;
    }

    public JSONResult(Object error, int code) {
        this.code = code;
        this.success = Boolean.FALSE;
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
    