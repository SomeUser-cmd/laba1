package com.example.demo.controller;

import com.example.demo.entity.Ads;
import com.example.demo.repos.AdsRepository;
import com.example.demo.stubs.AdsStub;
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
public class AdsControllerTest {
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @MockBean
    AdsRepository repo;

    @Autowired
    private MockMvc mvc;


    @Test
    void all() throws Exception {
        var admin = AdsStub.getRandomAds();
        var list = new ArrayList<Ads>();
        list.add(admin);
        Mockito.when(repo.findAll()).thenReturn(list);

        mvc.perform(get("/ads/all")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(admin.getUrl())));
    }

    @Test
    void id() throws Exception {
        var admin = AdsStub.getRandomAds();
        Mockito.when(repo.findById(AdsStub.ID)).thenReturn(java.util.Optional.ofNullable(admin));

        mvc.perform(get("/ads/" + AdsStub.ID)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getUrl())));
    }
    @Test
    void add() throws Exception {
        var admin = AdsStub.getRandomAds();
        Mockito.when(repo.save(admin)).thenReturn(admin);

        mvc.perform(post("/ads/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(admin))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getUrl())));
    }

    @Test
    void deleteAds() throws Exception {
        var admin = AdsStub.getRandomAds();
        mvc.perform(delete("/ads/delete/" + AdsStub.ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(admin))
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(admin.getUrl())));
    }
}
