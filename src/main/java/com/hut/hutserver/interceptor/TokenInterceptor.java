package com.hut.hutserver.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.hut.hutserver.untils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@Slf4j
@Component("tokenInterceptor")
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // get token from header
        String token = request.getHeader(jwtUtils.getHeader());
        if (StringUtils.isBlank(token)) {
            // get token from param if header is null
            token = request.getParameter(jwtUtils.getHeader());
        }
        // verify token
        DecodedJWT decodedJWT = jwtUtils.getClaimByToken(token);
        if (decodedJWT == null) {
            log.warn("get null decodeJWT, token: {}", token);
            return false;
        }
        String bid = decodedJWT.getSubject();
        if (!Objects.equals(bid, "")) {
            request.setAttribute("USER_KEY", bid);
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[LogInterceptor] request access {} {}", request.getLocalAddr(), request.getRequestURL());
    }
}
