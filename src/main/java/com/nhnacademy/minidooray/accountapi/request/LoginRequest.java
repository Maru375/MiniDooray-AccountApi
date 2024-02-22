package com.nhnacademy.minidooray.accountapi.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "아이디를 입력하시오")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력하시오")
    private String password;


}
