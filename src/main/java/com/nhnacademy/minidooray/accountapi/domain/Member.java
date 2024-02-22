package com.nhnacademy.minidooray.accountapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "members")
public class Member {
    @Id
    @Column(name = "member_id")
    private String memberId;

    private String email;

    private String password;

    private String name;

    @JoinColumn(name = "state")
    @OneToOne
    private  MemeberState memeberState;

    public Member(String memberId, String email, String password, String name, MemeberState memeberState){
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.memeberState = memeberState;
    }
}
