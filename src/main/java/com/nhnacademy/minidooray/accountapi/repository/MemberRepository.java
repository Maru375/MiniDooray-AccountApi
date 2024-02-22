package com.nhnacademy.minidooray.accountapi.repository;

import com.nhnacademy.minidooray.accountapi.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
