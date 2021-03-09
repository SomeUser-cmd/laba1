package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.AvailableCredits;
import com.example.demo.services.AvailableCreditsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/availablecredits")
public class AvailableCreditsController {
    private final AvailableCreditsService service;

    @GetMapping("/all")
    public List<AvailableCredits> getAll(
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
    public AvailableCredits getAvailableCreditsById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/add")
    public AvailableCredits createAvailableCredit(@RequestBody AvailableCredits availableCredit){
        return service.create(availableCredit);
    }

    @PutMapping("/edit/{id}")
    public AvailableCredits update(@PathVariable Long id,@RequestBody AvailableCredits availableCredits){
        return service.update(id, availableCredits);
    }

    @DeleteMapping("/delete/{id}")
    public AvailableCredits deleteAvailableCredit(@PathVariable Long id, @RequestBody AvailableCredits credit){
        return service.delete(id, credit);
    }
}
