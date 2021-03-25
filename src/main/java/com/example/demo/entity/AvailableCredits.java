package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "available_credits")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailableCredits {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int min_sum;
    private int max_sum;
    private int min_term;
    private int max_term;
    private double percent;
}
