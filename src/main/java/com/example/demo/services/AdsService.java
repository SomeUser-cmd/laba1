package com.example.demo.services;

import com.example.demo.entity.Ads;
import com.example.demo.repos.AdsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdsService {
    private final AdsRepository repo;

    public Ads getById(Long id){
        return repo.findById(id).orElseThrow();
    }
}
