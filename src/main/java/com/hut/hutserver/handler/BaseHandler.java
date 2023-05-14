package com.hut.hutserver.handler;


import com.hut.hutserver.untils.JWTManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseHandler {

    @Autowired
    private JWTManager jwtManager;

    @Autowired
    HttpServletRequest request;

    /**
     * 获取请求Token
     */
    private String getToken() {
        String token = request.getHeader(null);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(null);
        }
        return token;
    }
}












