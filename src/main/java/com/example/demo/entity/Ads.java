package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "ads")
public class Ads {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long user_id;
    private String url;
    private String title;

    //@OneToMany(mappedBy = "ads")
    //private Set<User> users;
}
