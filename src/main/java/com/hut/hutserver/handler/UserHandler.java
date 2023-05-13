package com.hut.hutserver.handler;


import com.hut.hutserver.common.Result;
import com.hut.hutserver.entity.request.LoginRequest;
import com.hut.hutserver.entity.request.RegisterRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Api(tags = "V1-用户相关功能")
@RequestMapping("/api/v1/user")
public class UserHandler extends BaseHandler {

    @PostMapping("/common_login")
    @ApiOperation(value = "登录接口")
    Result<Object> userRegister(@RequestBody @Validated RegisterRequest registerRequest) {
        return Result.ok(null);
    }

    @PostMapping("/common_login")
    @ApiOperation(value = "登录接口")
    Result<Object> jwtLogin(@RequestBody @Validated LoginRequest loginRequest) {
        return Result.ok(null);
    }
}
