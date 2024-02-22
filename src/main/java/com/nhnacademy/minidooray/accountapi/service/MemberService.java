package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMembers();

    Member getMember(String id);

    Member createMember(Member member);

    void deleteMember(String id);

}