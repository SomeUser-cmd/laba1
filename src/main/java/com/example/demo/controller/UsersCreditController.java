package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.entity.UsersCredit;
import com.example.demo.services.AdminService;
import com.example.demo.services.UsersCreditsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/usercredit")
public class UsersCreditController {
    private final UsersCreditsService service;

    @GetMapping("/all")
    public List<UsersCredit> getAll(
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
    public UsersCredit getUsersCreditById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/add")
    public UsersCredit createUsersCredit(@RequestBody UsersCredit usersCredit){
        return service.create(usersCredit);
    }

    @PutMapping("/edit/{id}")
    public UsersCredit update(@PathVariable Long id,@RequestBody UsersCredit usersCredit){
        return service.update(id, usersCredit);
    }

    @DeleteMapping("/delete/{id}")
    public UsersCredit deleteUsersCredit(@PathVariable Long id, @RequestBody UsersCredit credit){
        return service.delete(id, credit);
    }
}
