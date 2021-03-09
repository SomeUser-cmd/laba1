package com.example.demo.dto;

import com.example.demo.entity.Ads;
import lombok.Data;

import javax.persistence.Id;

@Data
public class ReduceUserIdFormAdsResponse {
    @Id
    private Long id;

    private String url;
    private String title;

    public ReduceUserIdFormAdsResponse(Ads ads) {
        this.id = ads.getId();
        this.url = ads.getUrl();
        this.title = ads.getTitle();
    }
}
