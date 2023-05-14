package com.hut.hutserver.handler;


import com.hut.hutserver.common.Result;
import com.hut.hutserver.entity.request.FollowUserReq;
import com.hut.hutserver.entity.request.LoginReq;
import com.hut.hutserver.entity.request.HutUserDTO;
import com.hut.hutserver.entity.response.FollowUserResp;
import com.hut.hutserver.entity.response.LoginResp;
import com.hut.hutserver.service.UserService;
import com.hut.hutserver.untils.JWTManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "V1-用户相关功能")
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserHandler extends BaseHandler {

    @Autowired
    UserService userService;

    @Autowired
    JWTManager jwtManager;

    @PostMapping("/register")
    @ApiOperation(value = "注册接口")
    Result<LoginResp> userRegister(@RequestBody @Validated HutUserDTO registerRequest) {
        return userService.userRegister(registerRequest);
    }

    @PostMapping("/username_login")
    @ApiOperation(value = "登录接口")
    Result<LoginResp> usernameLogin(@RequestBody @Validated LoginReq loginReq) {
        return userService.usernameLogin(loginReq);
    }

    @PostMapping("/follow_user")
    @ApiOperation(value = "关注用户接口")
    Result<FollowUserResp> followUser(@RequestBody @Validated FollowUserReq followUserReq) {
        return userService.followUser(followUserReq);
    }

    @PostMapping("/unfollow_user")
    @ApiOperation(value = "关注用户接口")
    Result<FollowUserResp> unfollowUser(@RequestBody @Validated FollowUserReq followUserReq) {
        return userService.unfollowUser(followUserReq);
    }
}













