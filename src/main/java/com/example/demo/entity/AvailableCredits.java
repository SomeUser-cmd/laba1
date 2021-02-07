package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity(name = "available_credits")
public class AvailableCredits {
    @Id
    private int id;

    private String name;
    private String description;
    private int min_sum;
    private int max_sum;
    private int min_term;
    private int max_term;
    private double percent;
}
