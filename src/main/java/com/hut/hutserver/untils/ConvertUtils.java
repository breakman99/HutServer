package com.hut.hutserver.untils;

import com.hut.hutserver.entity.HutUsersEntity;
import com.hut.hutserver.entity.request.HutUserDTO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 在com.hut.hutserver.untils.GenerateUtils类中可以用classConvertUtils方法来生成Convert代码
 */
public class ConvertUtils {
    public static HutUsersEntity hutUserDTO2HutUsersEntity(HutUserDTO var1) {
        HutUsersEntity var2 = new HutUsersEntity();
        var2.setCollege(var1.getCollege());
        var2.setPassword(var1.getPassword());
        var2.setAvatarUrl(var1.getAvatarUrl());
        var2.setBio(var1.getBio());
        var2.setProFlag(var1.getProFlag());
        var2.setPhoneNum(var1.getPhoneNum());
        var2.setUserId(var1.getUserId());
        var2.setEmail(var1.getEmail());
        var2.setUsername(var1.getUsername());
        return var2;
    }
    public static HutUserDTO hutUsersEntity2HutUserDTO(HutUsersEntity var1) {
        HutUserDTO var2 = new HutUserDTO();
        var2.setCollege(var1.getCollege());
        var2.setPassword("Want to peek at passwords? No way!");
        var2.setAvatarUrl(var1.getAvatarUrl());
        var2.setBio(var1.getBio());
        var2.setProFlag(var1.getProFlag());
        var2.setPhoneNum(var1.getPhoneNum());
        var2.setUserId(var1.getUserId());
        var2.setEmail(var1.getEmail());
        var2.setUsername(var1.getUsername());
        return var2;
    }


}










