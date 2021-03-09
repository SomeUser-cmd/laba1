package com.example.demo.repos;

import com.example.demo.entity.Admin;
import com.example.demo.entity.AvailableCredits;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableCreditsRepository extends JpaRepository<AvailableCredits, Long> {
    Page<AvailableCredits> findAll(Pageable pageable);
}
