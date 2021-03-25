package com.example.demo.stubs;

import com.example.demo.entity.AvailableCredits;

public final class AvailableCreditStub {
    public static final Long ID = 1L;
    public static AvailableCredits credit = AvailableCredits.builder()
            .id(ID)
            .description("some desc")
            .max_sum(10000)
            .min_sum(1000)
            .max_term(30)
            .min_term(5)
            .percent(0.2)
            .build();
    public static AvailableCredits getRandomCredit(){
        return credit;
    }
}
