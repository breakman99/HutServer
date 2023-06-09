package com.hut.hutserver.service;

import com.hut.hutserver.common.Result;
import com.hut.hutserver.entity.request.UserRelationReq;
import com.hut.hutserver.entity.request.LoginReq;
import com.hut.hutserver.entity.request.HutUserDTO;
import com.hut.hutserver.entity.response.FollowUserResp;
import com.hut.hutserver.entity.response.LoginResp;

public interface UserService {

    Result<LoginResp> userRegister(HutUserDTO registerRequest);

    Result<LoginResp> usernameLogin(LoginReq loginReq);

    Result<FollowUserResp> userRelationChange(UserRelationReq userRelationReq);
}
