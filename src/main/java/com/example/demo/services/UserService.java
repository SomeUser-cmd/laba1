package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    public User getById(Long id){
        return repo.findById(id).orElseThrow();
    }
}
