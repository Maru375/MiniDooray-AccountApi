package com.nhnacademy.minidooray.accountapi.repository;

import com.nhnacademy.minidooray.accountapi.domain.MemeberState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberStateRepository extends JpaRepository<MemeberState, String> {
}
