package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.services.AdminService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping("/all")
    public List<User> getAll(
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
    public User getUserById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user){
        return service.create(user);
    }

    @PutMapping("/edit/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        return service.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable Long id , @RequestBody User user){
    return  service.delete(id, user);
    }
}
