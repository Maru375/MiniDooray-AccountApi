package com.nhnacademy.minidooray.accountapi.controller;

import com.nhnacademy.minidooray.accountapi.domain.MemberDto;
import com.nhnacademy.minidooray.accountapi.entity.Member;
import com.nhnacademy.minidooray.accountapi.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/{id}")
    public MemberDto getMember(@PathVariable String id) {
        return memberService.getMember(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable String id) {
        memberService.deleteMember(id);
        return "{\"delete :\"OK\"}";
    }


}
