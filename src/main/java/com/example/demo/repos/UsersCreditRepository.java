package com.example.demo.repos;

import com.example.demo.entity.Admin;
import com.example.demo.entity.UsersCredit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersCreditRepository extends JpaRepository<UsersCredit, Long> {
    Page<UsersCredit> findAll(Pageable pageable);
}
