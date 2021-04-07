package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.stubs.UserStub;
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

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserTest {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @MockBean
    UserRepository repo;

    @Autowired
    private MockMvc mvc;


    @Test
    void all() throws Exception {
        var admin = UserStub.getRandomUser();
        var list = new ArrayList<User>();
        list.add(admin);
        Mockito.when(repo.findAll()).thenReturn(list);

        mvc.perform(get("/users/all")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(admin.getFirst_name())));
    }

    @Test
    void id() throws Exception {
        var admin = UserStub.getRandomUser();
        Mockito.when(repo.findById(UserStub.ID)).thenReturn(java.util.Optional.ofNullable(admin));

        mvc.perform(get("/users/" + UserStub.ID)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getFirst_name())));
    }
    @Test
    void add() throws Exception {
        var admin = UserStub.getRandomUser();
        Mockito.when(repo.save(admin)).thenReturn(admin);

        mvc.perform(post("/users/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(admin))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getFirst_name())));
    }

    @Test
    void deleteUser() throws Exception {
        var admin = UserStub.getRandomUser();
        mvc.perform(delete("/users/delete/" + UserStub.ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(admin))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getFirst_name())));
    }
}
