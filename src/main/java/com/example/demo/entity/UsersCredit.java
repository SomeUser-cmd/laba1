package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;

@Data
@Entity(name = "users_credit")
public class UsersCredit {
    @Id
    private int id;

    private String name;
    private String description;
    private double amount;
    private double alreadyPaid;
    private double percent;
    private Date startDate;
    private Date endDate;

    @OneToOne
    private User user;
}
