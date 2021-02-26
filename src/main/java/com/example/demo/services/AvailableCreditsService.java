package com.example.demo.services;

import com.example.demo.entity.AvailableCredits;
import com.example.demo.repos.AvailableCreditsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AvailableCreditsService {
    private final AvailableCreditsRepository repo;

    public AvailableCredits getById(Long id){
        return repo.findById(id).orElseThrow();
    }
}
