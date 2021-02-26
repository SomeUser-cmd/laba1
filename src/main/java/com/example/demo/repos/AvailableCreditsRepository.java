package com.example.demo.repos;

import com.example.demo.entity.AvailableCredits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableCreditsRepository extends JpaRepository<AvailableCredits, Long> {
}
