package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/all")
    public List<User> getAll(
            @RequestParam(required = false, defaultValue = "all" ) Integer size,
            @RequestParam(required = false, defaultValue = "1" )  Integer page
    ){
        return null;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return  null;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return null;
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){

    }
}
