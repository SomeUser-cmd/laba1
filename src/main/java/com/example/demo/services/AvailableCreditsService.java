package com.example.demo.services;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Ads;
import com.example.demo.entity.AvailableCredits;
import com.example.demo.repos.AvailableCreditsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableCreditsService {
    private final AvailableCreditsRepository repo;

    public List<AvailableCredits> getAllPagination(Pageable page){
        return repo.findAll(page).getContent();
    }

    public List<AvailableCredits> getAll(){
        return repo.findAll();
    }

    public AvailableCredits getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public AvailableCredits create(AvailableCredits ads) {
        return repo.save(ads);
    }

    public AvailableCredits update(Long id, AvailableCredits ads) {
        AvailableCredits myAdmin =  repo.findById(id).orElseThrow();
        myAdmin = ads;
        return repo.save(myAdmin);
    }

    public AvailableCredits delete(Long id, AvailableCredits credit) {
        repo.deleteById(id);
        return credit;
    }
}
