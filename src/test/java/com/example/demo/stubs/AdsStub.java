package com.example.demo.stubs;

import com.example.demo.entity.Ads;

public final class AdsStub {
    public static final Long ID = 1L;
    public static Ads ads = Ads.builder()
            .id(ID)
            .title("Some url")
            .url("sdfg sdfg sdfgsd f")
            .user_id(1L)
            .build();
    public static Ads getRandomAds(){
        return ads;
    }
}
