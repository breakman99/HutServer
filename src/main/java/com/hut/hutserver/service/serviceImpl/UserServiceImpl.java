package com.hut.hutserver.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.hut.hutserver.common.HutErrorCode;
import com.hut.hutserver.common.Result;
import com.hut.hutserver.common.UserCommon;
import com.hut.hutserver.entity.HutUserRelationshipEntity;
import com.hut.hutserver.entity.HutUsersEntity;
import com.hut.hutserver.entity.request.UserRelationReq;
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
    public Result<FollowUserResp> userRelationChange(UserRelationReq userRelationReq) {
        // check the followed user's existence
        HutUsersEntity user = hutUsersMapper.selectById(userRelationReq.getTargetUserId());
        if (user == null || StringUtils.isBlank(user.getUserId()) || !StringUtils.equals(user.getUserId(), userRelationReq.getTargetUserId())) {
            Result.ok(HutErrorCode.USER_NOT_EXIST);
        }
        LambdaQueryWrapper<HutUserRelationshipEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HutUserRelationshipEntity::getUserId, userRelationReq.getMyUserId())
                .eq(HutUserRelationshipEntity::getTargetUserId, userRelationReq.getTargetUserId());
        // check if relationship existed
        HutUserRelationshipEntity relationship = relationshipMapper.selectOne(wrapper);
        FollowUserResp resp = new FollowUserResp();
        if (relationship == null) {
            // new a relation
            relationship = new HutUserRelationshipEntity();
            relationship.setUserId(userRelationReq.getMyUserId());
            relationship.setTargetUserId(userRelationReq.getTargetUserId());
            relationship.setRelationshipType(UserCommon.UserRelationship.FOLLOW);
            if (relationshipMapper.insert(relationship) < 1) {
                return Result.err(HutErrorCode.RELATIONSHIP_CHANGE_FAILED);
            }
        } else {
            LambdaUpdateWrapper<HutUserRelationshipEntity> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(HutUserRelationshipEntity::getTargetUserId, userRelationReq.getMyUserId()).eq(HutUserRelationshipEntity::getTargetUserId, userRelationReq.getTargetUserId());
            if (relationshipMapper.update(relationship, updateWrapper) < 1) {
                return Result.err(HutErrorCode.RELATIONSHIP_CHANGE_FAILED);
            }
        }
        return Result.ok(resp);
    }
}



