package com.example.demo.services;

import com.example.demo.repos.AdsRepository;
import com.example.demo.repos.AdsRepositoryTest;
import com.example.demo.stubs.AdsStub;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith({MockitoExtension.class})
public class AdsServiceTest {
    private AdsService service;

    @Mock
    private AdsRepository repo;

    @BeforeEach
    void setup(){
        service = new AdsService(repo);
    }

    @Test
    void testSuccessfulGetById(){
        var ads = AdsStub.getRandomAds();
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(ads));

        var result = service.getById(AdsStub.ID);

        Assert.assertEquals(result.getId(), ads.getId());
        Assert.assertEquals(result.getTitle(), ads.getTitle());
        Assert.assertEquals(result.getUrl(), ads.getUrl());
        Assert.assertEquals(result.getUser_id(), ads.getUser_id());
    }

    @Test
    void testNotSuccessfulGetById(){
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.empty());

        var e = Assert.assertThrows(NoSuchElementException.class, ()->service.getById(AdsStub.ID));

        Assert.assertEquals(e.getMessage(), "No value present");
    }

    @Test
    void testSuccessfulCreate(){
        var ads = AdsStub.getRandomAds();
        Mockito.when(repo.save(Mockito.any())).thenReturn(ads);

        var result = service.create(ads);

        Assert.assertEquals(result.getId(), ads.getId());
        Assert.assertEquals(result.getTitle(), ads.getTitle());
        Assert.assertEquals(result.getUrl(), ads.getUrl());
        Assert.assertEquals(result.getUser_id(), ads.getUser_id());
    }

    @Test
    void testSuccessfulDelete(){
        var ads = AdsStub.getRandomAds();
        var result = service.delete(AdsStub.ID, ads);

        Assert.assertEquals(result.getId(), ads.getId());
        Assert.assertEquals(result.getTitle(), ads.getTitle());
        Assert.assertEquals(result.getUrl(), ads.getUrl());
        Assert.assertEquals(result.getUser_id(), ads.getUser_id());
    }
}
