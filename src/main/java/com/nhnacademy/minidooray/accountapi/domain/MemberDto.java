package com.nhnacademy.minidooray.accountapi.domain;


import com.nhnacademy.minidooray.accountapi.entity.Member;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private final String memberId;
    private final String name;
    private final String email;

    public MemberDto(Member member){
        this.memberId = member.getMemberId();
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
