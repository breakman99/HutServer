package com.hut.hutserver.entity.response;


import com.hut.hutserver.entity.request.HutUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResp {
    private String token;
    private HutUserDTO hutUserDTO;
    private Long loginTime;
}
