package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.domain.Member;
import com.nhnacademy.minidooray.accountapi.repository.MemberRepository;

import java.util.List;

public class DoorayMemberService implements MemberService{
    private final MemberRepository memberRepository;

    public DoorayMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMember(String id) {
        return memberRepository.getById(id);
    }

    @Override
    public Member createMember(Member member) {
        if(memberRepository.findById(member.getMemberId()).isPresent()){
            throw new IllegalStateException("already exist" + member.getMemberId());
        }
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }
}
