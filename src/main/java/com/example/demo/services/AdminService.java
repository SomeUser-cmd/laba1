package com.example.demo.services;

import com.example.demo.entity.Admin;
import com.example.demo.repos.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository repo;

    public List<Admin> getAllPagination(Pageable page){
        return repo.findAll(page).getContent();
    }

    public List<Admin> getAll(){
        return repo.findAll();
    }

    public Admin getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public Admin create(Admin admin) {
        return repo.save(admin);
    }

    public Admin update(Long id, Admin admin) {
       Admin myAdmin =  repo.findById(id).orElseThrow();
       myAdmin = admin;
       return repo.save(myAdmin);
    }

    public Admin delete(Long id, Admin admin) {
        repo.deleteById(id);
        return admin;
    }
}
