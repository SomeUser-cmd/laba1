package com.example.demo.repos;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Ads;
import com.example.demo.stubs.AdminStub;
import com.example.demo.stubs.AdsStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AdsRepositoryTest {
    public static final Long USER_ID = 1L;
    @Autowired
    private  AdsRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindAdsByUserId() {
        var expectedAds = Ads.builder()
                .title("Some url")
                .url("sdfg sdfg sdfgsd f")
                .user_id(1L)
                .build();
        entityManager.persist(expectedAds);
        entityManager.flush();
        var actualAds = repo.findAdsByUserId(USER_ID);
        Assertions.assertThat(actualAds.get(0)).isEqualTo(expectedAds);
    }

    @Test
    void testFindAll() {
        var ads =  Ads.builder()
                .title("Some url")
                .url("sdfg sdfg sdfgsd f")
                .user_id(1L)
                .build();
        var list = new ArrayList<Ads>();
        list.add(AdsStub.getRandomAds());
        entityManager.persist(ads);
        entityManager.flush();
        var actualAds = repo.findAll();
        Assertions.assertThat(actualAds.get(0).getId()).isEqualTo(list.get(0).getId());
    }
}
