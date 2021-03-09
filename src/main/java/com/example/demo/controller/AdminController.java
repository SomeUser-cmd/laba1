package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {
    private final AdminService service;

    @GetMapping("/all")
    public List<Admin> getAll(
            @RequestParam(required = false, defaultValue = "0" ) Integer size,
            @RequestParam(required = false, defaultValue = "1" )  Integer page
    ){
        if (size == 0){
            return  service.getAll();
        }
        else {
            Pageable pageable = PageRequest.of(page, size);
            System.out.println(pageable.toString());
            return service.getAllPagination(pageable);
        }
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id){
        return service.getById(id);
    }


    @PostMapping("/add")
    public Admin createAdmin(@RequestBody Admin admin){
        return service.create(admin);
    }

    @PutMapping("/edit/{id}")
    public Admin update(@PathVariable Long id,@RequestBody Admin admin){
        return service.update(id,admin);
    }

    @DeleteMapping("/delete/{id}")
    public Admin deleteAdmin(@PathVariable Long id, @RequestBody Admin admin){
        return service.delete(id, admin);
    }
}
