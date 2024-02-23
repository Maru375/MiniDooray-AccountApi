package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.domain.MemberDto;
import com.nhnacademy.minidooray.accountapi.domain.MemberNameOnly;
import com.nhnacademy.minidooray.accountapi.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMembers();

    MemberDto getMember(String id);

    Member createMember(Member member);

    void deleteMember(String id);

}