package com.hut.hutserver.handler;


import com.hut.hutserver.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Api(tags = "V1-用户相关功能")
@RequestMapping("/api/v1/user")
public class UserHandler extends BaseHandler{

    @PostMapping("/common_login")
    @ApiOperation(value = "登录接口")
    Result<Object> login(String str) {
        if (str != null) {
            System.out.println("hhh");
        }
        return Result.ok(str);
    }
}
