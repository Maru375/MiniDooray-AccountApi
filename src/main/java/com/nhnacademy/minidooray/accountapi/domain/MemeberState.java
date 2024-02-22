package com.nhnacademy.minidooray.accountapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "memeber_state")
public class MemeberState {
    @Id
    private String state;
}
