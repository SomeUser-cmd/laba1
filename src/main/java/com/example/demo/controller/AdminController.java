package com.example.demo.controller;

import com.example.demo.entity.Admin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @GetMapping("/all")
    public List<Admin> getAll(
            @RequestParam(required = false, defaultValue = "all" ) Integer size,
            @RequestParam(required = false, defaultValue = "1" )  Integer page
    ){
        return null;
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id){
        return  null;
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin){
        return null;
    }

    @PutMapping("/{id}")
    public Admin update(@PathVariable Long id,@RequestBody Admin admin){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id){

    }
}
