package com.example.demo.services;

import com.example.demo.repos.UserRepository;
import com.example.demo.stubs.UserStub;
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
public class UserServiceTest {
    private UserService service;

    @Mock
    private UserRepository repo;

    @BeforeEach
    void setup(){
        service = new UserService(repo);
    }

    @Test
    void testSuccessfulGetById(){
        var credit = UserStub.getRandomUser();
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(credit));

        var result = service.getById(UserStub.ID);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getAds(), credit.getAds());
        Assert.assertEquals(result.getFirst_name(), credit.getFirst_name());
        Assert.assertEquals(result.getLast_name(), credit.getLast_name());
        Assert.assertEquals(result.getPassword(), credit.getPassword());
    }

    @Test
    void testNotSuccessfulGetById(){
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.empty());

        var e = Assert.assertThrows(NoSuchElementException.class, ()->service.getById(UserStub.ID));

        Assert.assertEquals(e.getMessage(), "No value present");
    }

    @Test
    void testSuccessfulCreate(){
        var credit = UserStub.getRandomUser();
        Mockito.when(repo.save(Mockito.any())).thenReturn(credit);

        var result = service.create(credit);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getAds(), credit.getAds());
        Assert.assertEquals(result.getFirst_name(), credit.getFirst_name());
        Assert.assertEquals(result.getLast_name(), credit.getLast_name());
        Assert.assertEquals(result.getPassword(), credit.getPassword());
    }

    @Test
    void testSuccessfulDelete(){
        var credit = UserStub.getRandomUser();
        var result = service.delete(UserStub.ID, credit);

        Assert.assertEquals(result.getId(), credit.getId());
        Assert.assertEquals(result.getAds(), credit.getAds());
        Assert.assertEquals(result.getFirst_name(), credit.getFirst_name());
        Assert.assertEquals(result.getLast_name(), credit.getLast_name());
        Assert.assertEquals(result.getPassword(), credit.getPassword());
    }
}
