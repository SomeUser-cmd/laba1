package com.example.demo.stubs;

import com.example.demo.entity.Admin;

public final class AdminStub {
    public static final Long ID = 1L;
    public static Admin admin = Admin.builder()
                                .id(ID)
                                .first_name("Bogdan")
                                .last_name("Seredenko")
                                .password("initpassword")
                                .role("superadmin")
                                .build();
    public static Admin getRandomAdmin(){
        return admin;
    }
}
