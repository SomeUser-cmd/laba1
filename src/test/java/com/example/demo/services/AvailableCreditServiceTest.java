package com.example.demo.services;

import com.example.demo.repos.AvailableCreditsRepository;
import com.example.demo.stubs.AvailableCreditStub;
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
public class AvailableCreditServiceTest {
    private AvailableCreditsService service;

    @Mock
    private AvailableCreditsRepository repo;

    @BeforeEach
    void setup(){
        service = new AvailableCreditsService(repo);
    }

    @Test
    void testSuccessfulGetById(){
        var credit = AvailableCreditStub.getRandomCredit();
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(credit));

        var result = service.getById(AvailableCreditStub.ID);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getDescription(), credit.getDescription());
        Assert.assertEquals(result.getMax_sum(), credit.getMax_sum());
        Assert.assertEquals(result.getMin_sum(), credit.getMin_sum());
        Assert.assertEquals(result.getMax_term(), credit.getMax_term());
        Assert.assertEquals(result.getMin_term(), credit.getMin_term());
        Assert.assertEquals(result.getName(), credit.getName());
    }

    @Test
    void testNotSuccessfulGetById(){
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.empty());

        var e = Assert.assertThrows(NoSuchElementException.class, ()->service.getById(AvailableCreditStub.ID));

        Assert.assertEquals(e.getMessage(), "No value present");
    }

    @Test
    void testSuccessfulCreate(){
        var credit = AvailableCreditStub.getRandomCredit();
        Mockito.when(repo.save(Mockito.any())).thenReturn(credit);

        var result = service.create(credit);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getDescription(), credit.getDescription());
        Assert.assertEquals(result.getMax_sum(), credit.getMax_sum());
        Assert.assertEquals(result.getMin_sum(), credit.getMin_sum());
        Assert.assertEquals(result.getMax_term(), credit.getMax_term());
        Assert.assertEquals(result.getMin_term(), credit.getMin_term());
        Assert.assertEquals(result.getName(), credit.getName());
    }

    @Test
    void testSuccessfulDelete(){
        var credit = AvailableCreditStub.getRandomCredit();
        var result = service.delete(AvailableCreditStub.ID, credit);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getDescription(), credit.getDescription());
        Assert.assertEquals(result.getMax_sum(), credit.getMax_sum());
        Assert.assertEquals(result.getMin_sum(), credit.getMin_sum());
        Assert.assertEquals(result.getMax_term(), credit.getMax_term());
        Assert.assertEquals(result.getMin_term(), credit.getMin_term());
        Assert.assertEquals(result.getName(), credit.getName());
    }
}
