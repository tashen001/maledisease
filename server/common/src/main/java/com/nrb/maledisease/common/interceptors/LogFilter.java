package com.nrb.maledisease.common.interceptors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangyunfei on 04/12/2016.
 */
@Component
@WebFilter
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger("ACCESS");

    private static final Logger ERRORLOGGER = LoggerFactory.getLogger("ERROR");

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long beginTime = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long endTime = System.currentTimeMillis();
        long executeTime = endTime - beginTime;
        StringBuilder sb = new StringBuilder();
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        sb.append(getRemoteIP(httpServletRequest) + " - ");
        sb.append(httpServletRequest.getRequestURI() + " - ");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        sb.append(response.getStatus() + " - ");
        sb.append("Execute Time:" + executeTime + "ms" + " - ");
        sb.append("Param: " + getParamStr(httpServletRequest));
        LOGGER.info(sb.toString());
    }

    @Override
    public void destroy() {

    }

    private String getRemoteIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    private String getParamStr(HttpServletRequest request) {
        try {
            String json = objectMapper.writeValueAsString(request.getParameterMap());
            return json;
        } catch (JsonProcessingException e) {
            ERRORLOGGER.error(e.getMessage(), e);
            return "";
        }
    }
}
