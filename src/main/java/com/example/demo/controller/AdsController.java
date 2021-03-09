package com.example.demo.controller;

import com.example.demo.dto.ReduceUserIdFormAdsResponse;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Ads;
import com.example.demo.services.AdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {
    private final AdsService service;

    @GetMapping("/all")
    public List<Ads> getAll(
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
    public Ads getAdsById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/add")
    public Ads createAds(@RequestBody Ads ads){
        return service.create(ads);
    }

    @PutMapping("/edit/{id}")
    public Ads update(@PathVariable Long id,@RequestBody Ads ads){
        return service.update(id,ads);
    }

    @DeleteMapping("delete/{id}")
    public Ads deleteAds(@PathVariable Long id, @RequestBody Ads ads){
        return service.delete(id, ads);
    }

    @GetMapping("/getByUserId/{id}")
    public List<ReduceUserIdFormAdsResponse> getByUserId(@PathVariable Long id){
        return service.getAdsByUserId(id);
    }
}
