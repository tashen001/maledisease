package com.nrb.maledisease.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangyunfei on 01/12/2016.
 */
public class SessionUtil {

    public static Object getAttribute(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

}
