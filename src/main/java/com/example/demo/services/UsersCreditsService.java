package com.example.demo.services;

import com.example.demo.entity.UsersCredit;
import com.example.demo.repos.UsersCreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UsersCreditsService {
    private final UsersCreditRepository repo;

    public UsersCredit getById(Long id){
        return repo.findById(id).orElseThrow();
    }
}
