package com.example.demo.controller;

import com.example.demo.entity.UsersCredit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usercredit")
public class UsersCreditController {
    @GetMapping("/all")
    public List<UsersCredit> getAll(
            @RequestParam(required = false, defaultValue = "all" ) Integer size,
            @RequestParam(required = false, defaultValue = "1" )  Integer page
    ){
        return null;
    }

    @GetMapping("/{id}")
    public UsersCredit getUsersCreditById(@PathVariable Long id){
        return  null;
    }

    @PostMapping
    public UsersCredit createUsersCredit(@RequestBody UsersCredit usersCredit){
        return null;
    }

    @PutMapping("/{id}")
    public UsersCredit update(@PathVariable Long id,@RequestBody UsersCredit usersCredit){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUsersCredit(@PathVariable Long id){

    }
}
