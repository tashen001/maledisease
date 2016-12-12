package com.nrb.maledisease.patient.handler;

import com.nrb.maledisease.common.Result;
import com.nrb.maledisease.common.util.ResponseJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangyunfei on 06/12/2016.
 */
public class RestLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //TODO remove user info from redis
        LOGGER.info("Logout Success: ");
        Result result = Result.buildSuccessResult("退出成功");
        ResponseJsonUtil.responseJson(httpServletResponse, result);
    }
}