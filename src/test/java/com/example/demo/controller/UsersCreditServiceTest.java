package com.example.demo.controller;

import com.example.demo.entity.UsersCredit;
import com.example.demo.repos.UsersCreditRepository;
import com.example.demo.stubs.UsersCreditStub;
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
public class UsersCreditServiceTest {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @MockBean
    UsersCreditRepository repo;

    @Autowired
    private MockMvc mvc;


    @Test
    void all() throws Exception {
        var admin = UsersCreditStub.getRandomCredit();
        var list = new ArrayList<UsersCredit>();
        list.add(admin);
        Mockito.when(repo.findAll()).thenReturn(list);

        mvc.perform(get("/usercredit/all")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(admin.getName())));
    }

    @Test
    void id() throws Exception {
        var admin = UsersCreditStub.getRandomCredit();
        Mockito.when(repo.findById(UsersCreditStub.ID)).thenReturn(java.util.Optional.ofNullable(admin));

        mvc.perform(get("/usercredit/" + UsersCreditStub.ID)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getName())));
    }
    @Test
    void add() throws Exception {
        var admin = UsersCreditStub.getRandomCredit();
        Mockito.when(repo.save(admin)).thenReturn(admin);

        mvc.perform(post("/usercredit/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(admin))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getName())));
    }

    @Test
    void deleteCredit() throws Exception {
        var admin = UsersCreditStub.getRandomCredit();
        mvc.perform(delete("/usercredit/delete/" + UsersCreditStub.ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(admin))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getName())));
    }
}
