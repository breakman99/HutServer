package com.hut.hutserver.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hut.hutserver.common.HutErrorCode;
import com.hut.hutserver.common.Result;
import com.hut.hutserver.entity.HutUserRelationshipEntity;
import com.hut.hutserver.entity.HutUsersEntity;
import com.hut.hutserver.entity.request.FollowUserReq;
import com.hut.hutserver.entity.request.LoginReq;
import com.hut.hutserver.entity.request.HutUserDTO;
import com.hut.hutserver.entity.response.FollowUserResp;
import com.hut.hutserver.entity.response.LoginResp;
import com.hut.hutserver.mapper.HutUserRelationshipMapper;
import com.hut.hutserver.mapper.HutUsersMapper;
import com.hut.hutserver.service.UserService;
import com.hut.hutserver.untils.CommonUtils;
import com.hut.hutserver.untils.ConvertUtils;
import com.hut.hutserver.untils.JWTManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    HutUsersMapper hutUsersMapper;

    @Autowired
    HutUserRelationshipMapper relationshipMapper;

    @Autowired
    JWTManager jwtManager;

    @Override
    public Result<LoginResp> userRegister(HutUserDTO registerRequest) {
        // check if userid existed
        LambdaQueryWrapper<HutUsersEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HutUsersEntity::getUsername, "username");
        if (hutUsersMapper.exists(wrapper)) {
            return Result.ok(HutErrorCode.USER_ALREADY_EXISTED);
        }
        //set password md5
        registerRequest.setPassword(CommonUtils.encrypt(registerRequest.getPassword()));
        // generate userid
        registerRequest.setUserId(CommonUtils.getNewUserID());
        HutUsersEntity hutUser = ConvertUtils.hutUserDTO2HutUsersEntity(registerRequest);
        //save HutUser
        if (hutUsersMapper.insert(hutUser) < 1) {
            log.error("[userRegister] user insert failed, user message:{}", hutUser);
            return Result.err(HutErrorCode.REGISTER_FAILED);
        }
        LoginResp res = new LoginResp();
        res.setHutUserDTO(registerRequest);
        res.setToken(jwtManager.generateToken(registerRequest.getUserId()));
        res.setLoginTime(new Date().getTime());
        return Result.ok(res);
    }

    @Override
    public Result<LoginResp> usernameLogin(LoginReq loginReq) {
        LambdaQueryWrapper<HutUsersEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HutUsersEntity::getUsername, loginReq.getUserName()).eq(HutUsersEntity::getPassword, "");
        HutUsersEntity resUser = hutUsersMapper.selectOne(wrapper);
        if (resUser == null || StringUtils.isBlank(resUser.getUsername()) || !StringUtils.equals(resUser.getUsername(), loginReq.getUserName())) {
            return Result.ok(HutErrorCode.USER_NOT_EXIST_OR_ERROR_PASSWORD);
        }
        LoginResp res = new LoginResp();
        res.setHutUserDTO(ConvertUtils.hutUsersEntity2HutUserDTO(resUser));
        res.setToken(jwtManager.generateToken(resUser.getUsername()));
        res.setLoginTime(new Date().getTime());
        return Result.ok(res);
    }

    @Override
    public Result<FollowUserResp> followUser(FollowUserReq followUserReq) {
        HutUsersEntity user = hutUsersMapper.selectById(followUserReq.getTargetUserId());
        if (user == null || StringUtils.isBlank(user.getUserId()) || !StringUtils.equals(user.getUserId(), followUserReq.getTargetUserId())) {
            Result.ok(HutErrorCode.USER_NOT_EXIST);
        }
        LambdaQueryWrapper<HutUserRelationshipEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HutUserRelationshipEntity::getUserId, followUserReq.getMyUserId())
                .eq(HutUserRelationshipEntity::getTargetUserId, followUserReq.getTargetUserId());
        HutUserRelationshipEntity relationship = relationshipMapper.selectOne(wrapper);
        if (relationship == null || StringUtils.isBlank(relationship.getUserId()) || !StringUtils.equals(relationship.getUserId(), relationship.getUserId())) {
            return Result.ok(HutErrorCode.USER_NOT_EXIST_OR_ERROR_PASSWORD);
        }
        FollowUserResp resp = new FollowUserResp();
        return Result.ok(resp);
    }

    @Override
    public Result<FollowUserResp> unfollowUser(FollowUserReq followUserReq) {
        HutUsersEntity user = hutUsersMapper.selectById(followUserReq.getTargetUserId());
        if (user == null || StringUtils.isBlank(user.getUserId()) || !StringUtils.equals(user.getUserId(), followUserReq.getTargetUserId())) {
            Result.ok(HutErrorCode.USER_NOT_EXIST);
        }
        FollowUserResp resp = new FollowUserResp();
        return Result.ok(resp);
    }
}



