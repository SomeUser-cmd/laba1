package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity(name = "users_credit")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersCredit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double amount;
    private double alreadyPaid;
    private double percent;
    private Date startDate;
    private Date endDate;

}
