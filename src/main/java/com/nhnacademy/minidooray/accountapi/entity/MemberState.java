package com.nhnacademy.minidooray.accountapi.entity;

public enum MemberState {
    JOIN("가입"),
    WITHDRAW("탈퇴"),
    DORMANT("휴먼");

    private String stateName;

    MemberState(String stateName){
        this.stateName = stateName;
    }

    public String getStateName(){
        return stateName;
    }
}
