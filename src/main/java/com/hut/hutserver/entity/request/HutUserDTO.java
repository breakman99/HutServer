package com.hut.hutserver.entity.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;


/**
 * 注册请求表单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HutUserDTO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "用户ID不能为空")
    private String userId;

    @Email(message = "邮箱格式有误")
    private String email;

    @NotBlank(message = "密码不能为空")
    @Size(min = 8, message = "密码长度不能小于8位")
    private String password;

    private String college;

    @Length(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phoneNum;

    @Length(max = 200)
    private String bio;

    @URL
    private String avatarUrl;

    private Byte proFlag;
}




















