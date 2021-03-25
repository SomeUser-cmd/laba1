package com.example.demo.repos;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Ads;
import com.example.demo.stubs.AdminStub;
import com.example.demo.stubs.AdsStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AdminRepositoryTest {
    @Autowired
    private  AdminRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindAll() {
        var ads =  Admin.builder()
                .first_name("Bogdan")
                .last_name("Seredenko")
                .password("initpassword")
                .role("superadmin")
                .build();
        var list = new ArrayList<Admin>();
        list.add(AdminStub.getRandomAdmin());
        entityManager.persist(ads);
        entityManager.flush();
        var actualAds = repo.findAll();
        Assertions.assertThat(actualAds.get(0).getId()).isEqualTo(list.get(0).getId());
    }
}
