package com.nhnacademy.minidooray.accountapi.service;

import com.nhnacademy.minidooray.accountapi.domain.MemberDto;
import com.nhnacademy.minidooray.accountapi.entity.Member;
import com.nhnacademy.minidooray.accountapi.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public MemberDto getMember(String id) {
        Member member = memberRepository.findById(id).orElse(null);
        if(member != null){
            return new MemberDto(member);
        }
        return null;
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
