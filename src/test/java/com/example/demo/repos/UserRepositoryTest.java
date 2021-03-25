package com.example.demo.repos;

import com.example.demo.entity.UsersCredit;
import com.example.demo.stubs.UsersCreditStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private  UsersCreditRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindAll() {
        var ads =  UsersCredit.builder()
                .description("some desc")
                .percent(0.2)
                .alreadyPaid(2)
                .amount(10)
                .startDate(new Date(20,12,12))
                .endDate(new Date(20,12,18))
                .build();
        var list = new ArrayList<UsersCredit>();
        list.add(UsersCreditStub.getRandomCredit());
        entityManager.persist(ads);
        entityManager.flush();
        var actualAds = repo.findAll();
        Assertions.assertThat(actualAds.get(0).getId()).isEqualTo(list.get(0).getId());
    }
}
