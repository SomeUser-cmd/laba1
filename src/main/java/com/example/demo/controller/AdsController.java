package com.example.demo.controller;

import com.example.demo.entity.Ads;
import com.example.demo.services.AdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {
    private final AdsService service;

    @GetMapping("/all")
    public List<Ads> getAll(
            @RequestParam(required = false, defaultValue = "all" ) Integer size,
            @RequestParam(required = false, defaultValue = "1" )  Integer page
    ){
        return null;
    }

    @GetMapping("/{id}")
    public Ads getAdsById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public Ads createAds(@RequestBody Ads ads){
        return null;
    }

    @PutMapping("/{id}")
    public Ads update(@PathVariable Long id,@RequestBody Ads ads){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAds(@PathVariable Long id){

    }
}
