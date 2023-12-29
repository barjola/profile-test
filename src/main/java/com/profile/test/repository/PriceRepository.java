package com.profile.test.repository;

import com.profile.test.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface PriceRepository extends JpaRepository<PriceEntity, UUID> {

    @Query("""
                SELECT p
                FROM PriceEntity p
                WHERE :date BETWEEN p.startDate AND p.endDate
                    AND p.productId = :productId
                    AND p.brandId = :brandId
                ORDER BY p.priority DESC
                LIMIT 1
            """)
    Optional<PriceEntity> findFirstPriceBetweenDates(
            @Param("date") LocalDateTime date,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);
}
