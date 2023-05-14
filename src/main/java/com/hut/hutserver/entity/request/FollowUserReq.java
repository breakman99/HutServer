package com.hut.hutserver.entity.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowUserReq {
    String myUserId;
    @NotNull(message = "用户名不可为空")
    String targetUserId;
}
