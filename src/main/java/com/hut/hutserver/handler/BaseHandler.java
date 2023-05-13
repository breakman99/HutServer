package com.hut.hutserver.handler;


import com.hut.hutserver.untils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public abstract class BaseHandler {

    @Autowired
    private JWTUtils jwtUtils;

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












