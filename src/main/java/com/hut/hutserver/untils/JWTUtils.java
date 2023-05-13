package com.hut.hutserver.untils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Slf4j
@Component
@ConfigurationProperties(prefix = "app.jwt")
public class JWTUtils {
    /**
     * 加密秘钥
     */
    private String secret;
    /**
     * 有效时间
     */
    private long expire;
    /**
     * 用户凭证
     */
    private String header;

    /**
     * 生成Token签名
     *
     *
     */
    public String generateToken(String username) {
        System.out.println("header=" + getHeader() + ", expire=" + getExpire() + ", secret=" + getSecret());
        Date nowDate = new Date();
        // 过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        String token;
        try {
            Algorithm algorithmHS = Algorithm.HMAC512(secret);
            token = JWT.create()
                    .withSubject(username)
                    .withIssuer("HutHelper")
                    .withExpiresAt(expireDate)
                    .sign(algorithmHS);
        } catch (JWTCreationException e) {
            log.warn("Invalid Signing configuration / Couldn't convert Claims, userBid: {}", username);
            return "";
        }
        return token;
    }

    /**
     * 验证token是否可用
     *
     * @param token
     * @author hanxu.breakman99
     */
    public boolean tokenVerifier(String token) {
        // 兜底策略，方便调试
        if ("DEBUG_TOKEN".equals(token)) {
            return true;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            JWT.require(algorithm)
                    .withIssuer("HutHelper")
                    .build()
                    .verify(token);
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            // todo 这里的错误需要做详细的判断
            return false;

        }
        return true;
    }

    /**
     * 获取签名信息
     *
     * @param token
     * @author hanxu.breakman99
     */
    public DecodedJWT getClaimByToken(String token) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withIssuer("HutHelper")
                    .build();
            decodedJWT = jwtVerifier.verify(token);
        } catch (JWTVerificationException exception) {
            log.warn("gei claim by token error, invalid token:{}", token);
            throw exception;
        }
        return decodedJWT;
    }
}
















