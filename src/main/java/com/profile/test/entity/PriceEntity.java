package com.profile.test.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long priceList;

    private Long productId;

    private Integer priority;

    private BigDecimal price;

    @Column(name = "curr")
    private String currency;
}
