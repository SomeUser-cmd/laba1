package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "ads")
public class Ads {
    @Id
    private Long id;

    private String url;
    private String title;

    @OneToMany(mappedBy = "ads")
    private Set<User> users;
}
