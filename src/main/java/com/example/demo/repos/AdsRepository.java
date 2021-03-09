package com.example.demo.repos;

import com.example.demo.dto.ReduceUserIdFormAdsResponse;
import com.example.demo.entity.Ads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
    Page<Ads> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM ads WHERE user_id = :id", nativeQuery = true)
    List<Ads> findAdsByUserId(Long id);
}
