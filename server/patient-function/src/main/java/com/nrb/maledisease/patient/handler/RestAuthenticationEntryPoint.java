package com.nrb.maledisease.patient.handler;

import com.nrb.maledisease.common.Result;
import com.nrb.maledisease.common.util.ResponseJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangyunfei on 06/12/2016.
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        LOGGER.debug(e.getMessage(), e);
        Result result = Result.buildAuthExceptionResult("没有权限：" + e.getMessage());
        ResponseJsonUtil.responseJson(httpServletResponse, result);
    }
}
