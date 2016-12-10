package com.nrb.maledisease.common;

import com.nrb.maledisease.common.exception.BusinessException;
import com.nrb.maledisease.common.exception.ParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangyunfei on 27/11/2016.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result errorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOGGER.error(e.getMessage(), e);
        if (e instanceof ParamException) {
            Result.buildInvalidParamResult((ParamException) e);
        }
        if (e instanceof BusinessException) {
            Result.buildBusinessErrorResult((BusinessException) e);
        }

        return Result.buildExceptionResult(e);
    }

}
