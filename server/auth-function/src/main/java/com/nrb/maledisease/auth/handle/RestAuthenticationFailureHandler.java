package com.nrb.maledisease.auth.handle;

import com.nrb.maledisease.common.Result;
import com.nrb.maledisease.common.util.ResponseJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangyunfei on 12/12/2016.
 */
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        LOGGER.debug(e.getMessage(), e);
        Result result = Result.buildAuthExceptionResult("登录失败：" + e.getMessage());
        ResponseJsonUtil.responseJson(httpServletResponse, result);
    }
}
