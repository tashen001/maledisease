package com.nrb.maledisease.common;

import com.nrb.maledisease.common.exception.BusinessException;
import com.nrb.maledisease.common.exception.ParamException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyunfei on 27/11/2016.
 */
public class Result<T> {

    private ResultCodeEnum code;
    private String message;
    private Map<String, Object> extraMap = new HashMap<String, Object>();
    private T data;

    public String getCode() {
        return code.value();
    }

    public void setCode(ResultCodeEnum code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtraMap() {
        return extraMap;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addExtraMap(String key, Object value) {
        extraMap.put(key, value);
    }

    public static Result buildExceptionResult(Exception e) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.EXCEPTION);
        result.setMessage(e.getMessage());
        return result;
    }

    public static Result buildInvalidParamResult(ParamException e) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.INVALIDPARAM);
        result.setMessage(e.getMessage());
        return result;
    }

    public static Result buildBusinessErrorResult(BusinessException e) {
        Result result = new Result();
        result.setCode(ResultCodeEnum.BUSINESSERROR);
        result.setMessage(e.getMessage());
        return result;
    }

    public static Result buildSuccessResult(String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(ResultCodeEnum.SUCCESS);
        return result;
    }

    public static <T> Result buildSuccessResult(T t) {
        Result result = new Result();
        result.setMessage("");
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setData(t);
        return result;
    }

    public static <T> Result buildSuccessResult(String message, T t) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setData(t);
        return result;
    }
}
