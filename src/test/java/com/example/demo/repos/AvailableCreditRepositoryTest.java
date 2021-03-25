package com.example.demo.repos;

import com.example.demo.entity.Admin;
import com.example.demo.entity.AvailableCredits;
import com.example.demo.stubs.AdminStub;
import com.example.demo.stubs.AvailableCreditStub;
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
public class AvailableCreditRepositoryTest {
    @Autowired
    private  AvailableCreditsRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindAll() {
        var ads =  AvailableCredits.builder()
                .description("some desc")
                .max_sum(10000)
                .min_sum(1000)
                .max_term(30)
                .min_term(5)
                .percent(0.2)
                .build();
        var list = new ArrayList<AvailableCredits>();
        list.add(AvailableCreditStub.getRandomCredit());
        entityManager.persist(ads);
        entityManager.flush();
        var actualAds = repo.findAll();
        Assertions.assertThat(actualAds.get(0).getId()).isEqualTo(list.get(0).getId());
    }
}
