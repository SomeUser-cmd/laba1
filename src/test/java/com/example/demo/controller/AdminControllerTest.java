package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.repos.AdminRepository;
import com.example.demo.stubs.AdminStub;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AdminControllerTest {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @MockBean
    AdminRepository repo;

    @Autowired
    private MockMvc mvc;


    @Test
    void all() throws Exception {
        var admin = AdminStub.getRandomAdmin();
        var list = new ArrayList<Admin>();
        list.add(admin);
        Mockito.when(repo.findAll()).thenReturn(list);

        mvc.perform(get("/admins/all")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(admin.getFirst_name())));
    }

    @Test
    void id() throws Exception {
        var admin = AdminStub.getRandomAdmin();
        Mockito.when(repo.findById(AdminStub.ID)).thenReturn(java.util.Optional.ofNullable(admin));

        mvc.perform(get("/admins/" + AdminStub.ID)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getFirst_name())));
    }
    @Test
    void add() throws Exception {
        var admin = AdminStub.getRandomAdmin();
        Mockito.when(repo.save(admin)).thenReturn(admin);

        mvc.perform(post("/admins/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(admin))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getFirst_name())));
    }

    @Test
    void deleteAdmin() throws Exception {
        var admin = AdminStub.getRandomAdmin();
        mvc.perform(delete("/admins/delete/" + AdminStub.ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(admin))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getFirst_name())));
    }
}
