package com.example.demo.services;

import com.example.demo.entity.Admin;
import com.example.demo.repos.AdminRepository;
import com.example.demo.stubs.AdminStub;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith({MockitoExtension.class})
public class AdminServiceTest {
    private AdminService service;

    @Mock
    private AdminRepository repo;

    @BeforeEach
    void setup(){
        service = new AdminService(repo);
    }

    @Test
    void testSuccessfulGetById(){
        var admin = AdminStub.getRandomAdmin();
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.of(admin));

        var result = service.getById(AdminStub.ID);

        Assert.assertEquals(result.getId(), admin.getId());
        Assert.assertEquals(result.getFirst_name(), admin.getFirst_name());
        Assert.assertEquals(result.getLast_name(), admin.getLast_name());
        Assert.assertEquals(result.getRole(), admin.getRole());
        Assert.assertEquals(result.getPassword(), admin.getPassword());
    }

    @Test
    void testNotSuccessfulGetById(){
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.empty());

        var e = Assert.assertThrows(NoSuchElementException.class, ()->service.getById(AdminStub.ID));

        Assert.assertEquals(e.getMessage(), "No value present");
    }

    @Test
    void testSuccessfulCreate(){
        var admin = AdminStub.getRandomAdmin();
        Mockito.when(repo.save(Mockito.any())).thenReturn(admin);

        var result = service.create(admin);

        Assert.assertEquals(result.getId(), admin.getId());
        Assert.assertEquals(result.getFirst_name(), admin.getFirst_name());
        Assert.assertEquals(result.getLast_name(), admin.getLast_name());
        Assert.assertEquals(result.getRole(), admin.getRole());
        Assert.assertEquals(result.getPassword(), admin.getPassword());
    }

    @Test
    void testSuccessfulDelete(){
        var admin = AdminStub.getRandomAdmin();
        var result = service.delete(AdminStub.ID, admin);

        Assert.assertEquals(result.getId(), admin.getId());
        Assert.assertEquals(result.getFirst_name(), admin.getFirst_name());
        Assert.assertEquals(result.getLast_name(), admin.getLast_name());
        Assert.assertEquals(result.getRole(), admin.getRole());
        Assert.assertEquals(result.getPassword(), admin.getPassword());
    }

    @Test
    void testSuccessfulGetAll(){
        var admin =  AdminStub.getRandomAdmin();
        var list = new ArrayList<Admin>();
        list.add(admin);
        Mockito.when(repo.findAll()).thenReturn(list);
        var result = service.getAll();

        Assert.assertEquals(result.get(0).getId(), list.get(0).getId());
        Assert.assertEquals(result.get(0).getFirst_name(), list.get(0).getFirst_name());
        Assert.assertEquals(result.get(0).getLast_name(), list.get(0).getLast_name());
        Assert.assertEquals(result.get(0).getRole(), list.get(0).getRole());
        Assert.assertEquals(result.get(0).getPassword(), list.get(0).getPassword());
    }
}
