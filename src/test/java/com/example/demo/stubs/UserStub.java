package com.example.demo.stubs;

import com.example.demo.entity.User;
import com.example.demo.entity.UsersCredit;

public final class UserStub {
    public static final Long ID = 1L;
    public static User user = User.builder()
            .id(ID)
            .first_name("Bogdan")
            .last_name("Seredenko")
            .password("initpassword")
            .currentCredit(UsersCreditStub.getRandomCredit())
            .ads(AdsStub.getRandomAds())
            .build();
    public static User getRandomUser(){
        return user;
    }
}
