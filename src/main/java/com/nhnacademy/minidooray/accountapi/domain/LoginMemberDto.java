package com.nhnacademy.minidooray.accountapi.domain;

import com.nhnacademy.minidooray.accountapi.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginMemberDto {
    private final String memberId;
    private final String password;

    public LoginMemberDto(Member member) {
        this.memberId = member.getMemberId();
        this.password = member.getPassword();
    }

}
