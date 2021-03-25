package com.example.demo.services;

import com.example.demo.entity.UsersCredit;
import com.example.demo.repos.UsersCreditRepository;
import com.example.demo.stubs.UsersCreditStub;
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
public class UsersCreditServiceTest {
    private UsersCreditsService service;

    @Mock
    private UsersCreditRepository repo;

    @BeforeEach
    void setup(){
        service = new UsersCreditsService(repo);
    }

    @Test
    void testSuccessfulGetById(){
        var credit = UsersCreditStub.getRandomCredit();
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(credit));

        var result = service.getById(UsersCreditStub.ID);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getDescription(), credit.getDescription());
        Assert.assertEquals(result.getStartDate(), credit.getStartDate());
        Assert.assertEquals(result.getEndDate(), credit.getEndDate());
        Assert.assertEquals(result.getName(), credit.getName());
    }

    @Test
    void testNotSuccessfulGetById(){
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.empty());

        var e = Assert.assertThrows(NoSuchElementException.class, ()->service.getById(UsersCreditStub.ID));

        Assert.assertEquals(e.getMessage(), "No value present");
    }

    @Test
    void testSuccessfulCreate(){
        var credit = UsersCreditStub.getRandomCredit();
        Mockito.when(repo.save(Mockito.any())).thenReturn(credit);

        var result = service.create(credit);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getDescription(), credit.getDescription());
        Assert.assertEquals(result.getStartDate(), credit.getStartDate());
        Assert.assertEquals(result.getEndDate(), credit.getEndDate());
        Assert.assertEquals(result.getName(), credit.getName());
    }

    @Test
    void testSuccessfulDelete(){
        var credit = UsersCreditStub.getRandomCredit();
        var result = service.delete(UsersCreditStub.ID, credit);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getDescription(), credit.getDescription());
        Assert.assertEquals(result.getStartDate(), credit.getStartDate());
        Assert.assertEquals(result.getEndDate(), credit.getEndDate());
        Assert.assertEquals(result.getName(), credit.getName());
    }
}
