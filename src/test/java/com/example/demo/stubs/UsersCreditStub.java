package com.example.demo.stubs;

import com.example.demo.entity.UsersCredit;

import java.sql.Date;

public final class UsersCreditStub {
    public static final Long ID = 1L;
    public static UsersCredit credit = UsersCredit.builder()
            .id(ID)
            .description("some desc")
            .percent(0.2)
            .alreadyPaid(2)
            .amount(10)
            .startDate(new Date(20,12,12))
            .endDate(new Date(20,12,18))
            .build();
    public static UsersCredit getRandomCredit(){
        return credit;
    }
}
