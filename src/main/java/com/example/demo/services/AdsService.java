package com.example.demo.services;

import com.example.demo.dto.ReduceUserIdFormAdsResponse;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Ads;
import com.example.demo.repos.AdsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdsService {
    private final AdsRepository repo;

    public List<Ads> getAllPagination(Pageable page){
        return repo.findAll(page).getContent();
    }

    public List<Ads> getAll(){
        return repo.findAll();
    }

    public Ads getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public Ads create(Ads ads) {
        return repo.save(ads);
    }

    public Ads update(Long id, Ads ads) {
        Ads myAds =  repo.findById(id).orElseThrow();
        myAds = ads;
        return repo.save(myAds);
    }

    public Ads delete(Long id, Ads ads) {
        repo.deleteById(id);
        return ads;
    }

    public List<ReduceUserIdFormAdsResponse> getAdsByUserId(Long id){
        List<ReduceUserIdFormAdsResponse> list = new ArrayList<>();;
        repo.findAdsByUserId(id).forEach(ob -> {
            ReduceUserIdFormAdsResponse newOb = new ReduceUserIdFormAdsResponse(ob);
            list.add(newOb);
        });
        return list;
    }
}
