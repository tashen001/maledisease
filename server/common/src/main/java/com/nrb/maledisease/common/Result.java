package com.nrb.maledisease.common;

import com.nrb.maledisease.common.exception.BusinessException;
import com.nrb.maledisease.common.exception.ParamException;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyunfei on 27/11/2016.
 */
public class Result<T> {

    private static final int BUSINESSERROR = 520;

    private int code;
    private String message;
    private Map<String, Object> extraMap = new HashMap<String, Object>();
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
        result.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        result.setMessage(e.getMessage());
        return result;
    }

    public static Result buildAuthExceptionResult(String message) {
        Result result = new Result();
        result.setCode(HttpServletResponse.SC_UNAUTHORIZED);
        result.setMessage(message);
        return result;
    }

    public static Result buildInvalidParamResult(ParamException e) {
        Result result = new Result();
        result.setCode(HttpServletResponse.SC_BAD_REQUEST);
        result.setMessage(e.getMessage());
        return result;
    }

    public static Result buildBusinessErrorResult(BusinessException e) {
        Result result = new Result();
        result.setCode(Result.BUSINESSERROR);
        result.setMessage(e.getMessage());
        return result;
    }

    public static Result buildSuccessResult(String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(HttpServletResponse.SC_OK);
        return result;
    }

    public static <T> Result buildSuccessResult(T t) {
        Result result = new Result();
        result.setMessage("");
        result.setCode(HttpServletResponse.SC_OK);
        result.setData(t);
        return result;
    }

    public static <T> Result buildSuccessResult(String message, T t) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(HttpServletResponse.SC_OK);
        result.setData(t);
        return result;
    }
}
