package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "ads_id")
    private Ads ads;

    @OneToOne
    private UsersCredit currentCredit;
}
