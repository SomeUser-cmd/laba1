package com.example.demo.services;

import com.example.demo.entity.Admin;
import com.example.demo.repos.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository repo;

    public Admin getById(Long id){
        return repo.findById(id).orElseThrow();
    }
}
