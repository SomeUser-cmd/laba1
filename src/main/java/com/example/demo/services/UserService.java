package com.example.demo.services;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Ads;
import com.example.demo.entity.User;
import com.example.demo.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    public List<User> getAllPagination(Pageable page){
        return repo.findAll(page).getContent();
    }

    public List<User> getAll(){
        return repo.findAll();
    }

    public User getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public User create(User ads) {
        return repo.save(ads);
    }

    public User update(Long id, User ads) {
        User myAdmin =  repo.findById(id).orElseThrow();
        myAdmin = ads;
        return repo.save(myAdmin);
    }

    public User delete(Long id, User user) {
        repo.deleteById(id);
        return user;
    }
}
