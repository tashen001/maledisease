package com.nrb.maledisease.patient.handler;

import com.nrb.maledisease.common.Result;
import com.nrb.maledisease.common.util.ResponseJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangyunfei on 06/12/2016.
 */
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //TODO load user info and set into session
        LOGGER.info("Login Success: ");
        Result result = Result.buildSuccessResult("登录成功");
        ResponseJsonUtil.responseJson(httpServletResponse, result);
    }
}
