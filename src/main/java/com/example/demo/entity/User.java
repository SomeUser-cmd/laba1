package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
public class User {
    @Id
    private int id;

    private String first_name;
    private String last_name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "ads_id")
    private Ads ads;

    @OneToOne
    private UsersCredit currentCredit;
}
