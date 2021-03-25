package com.example.demo.repos;

import com.example.demo.entity.AvailableCredits;
import com.example.demo.entity.User;
import com.example.demo.entity.UsersCredit;
import com.example.demo.stubs.AdsStub;
import com.example.demo.stubs.AvailableCreditStub;
import com.example.demo.stubs.UserStub;
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
public class UsersCreditsRepositoryTest {
    @Autowired
    private  UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindAll() {
        var ads = User.builder()
                .first_name("Bogdan")
                .last_name("Seredenko")
                .password("initpassword")
                .build();
        var list = new ArrayList<User>();
        list.add(UserStub.getRandomUser());
        entityManager.persist(ads);
        entityManager.flush();
        var actualAds = repo.findAll();
        Assertions.assertThat(actualAds.get(0).getId()).isEqualTo(list.get(0).getId());
    }
}
