package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "admin")
public class Admin {
    @Id
    private Long id;

    private String role;
    private String first_name;
    private String last_name;
    private String password;
}
