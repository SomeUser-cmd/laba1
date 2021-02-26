package com.example.demo.controller;

import com.example.demo.entity.AvailableCredits;
import com.example.demo.services.AvailableCreditsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/availablecredits")
public class AvailableCreditsController {
    private final AvailableCreditsService service;

    @GetMapping("/all")
    public List<AvailableCredits> getAll(
            @RequestParam(required = false, defaultValue = "all" ) Integer size,
            @RequestParam(required = false, defaultValue = "1" )  Integer page
    ){
        return null;
    }

    @GetMapping("/{id}")
    public AvailableCredits getAvailableCreditsById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public AvailableCredits createAvailableCredit(@RequestBody AvailableCredits availableCredit){
        return null;
    }

    @PutMapping("/{id}")
    public AvailableCredits update(@PathVariable Long id,@RequestBody AvailableCredits availableCredits){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAvailableCredit(@PathVariable Long id){

    }
}
