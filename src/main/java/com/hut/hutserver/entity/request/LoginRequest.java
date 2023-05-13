package com.hut.hutserver.entity.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private Long userid;

    @NotNull
    @Length(min = 1, max = 10)
    private String userName;

    @NotNull
    @Length(min = 8, max = 100)
    private String password;
}
