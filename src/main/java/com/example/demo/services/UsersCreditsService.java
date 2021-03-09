package com.example.demo.services;


import com.example.demo.entity.UsersCredit;
import com.example.demo.repos.UsersCreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersCreditsService {
    private final UsersCreditRepository repo;

    public List<UsersCredit> getAllPagination(Pageable page){
        return repo.findAll(page).getContent();
    }

    public List<UsersCredit> getAll(){
        return repo.findAll();
    }

    public UsersCredit getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public UsersCredit create(UsersCredit ads) {
        return repo.save(ads);
    }

    public UsersCredit update(Long id, UsersCredit ads) {
        UsersCredit myAdmin =  repo.findById(id).orElseThrow();
        myAdmin = ads;
        return repo.save(myAdmin);
    }

    public UsersCredit delete(Long id, UsersCredit credit) {
        repo.deleteById(id);
        return credit;
    }
}
