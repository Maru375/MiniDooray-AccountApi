package com.nhnacademy.minidooray.accountapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Table(name = "members")
public class Member {
    @Id
    @Column(name = "member_id")
    private String memberId;

    private String email;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberState state;
    public Member(String memberId, String email, String password, String name, MemberState state){
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.state = state;
    }
}
