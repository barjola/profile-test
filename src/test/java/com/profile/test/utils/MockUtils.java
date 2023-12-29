package com.profile.test.utils;

import com.profile.test.entity.PriceEntity;
import com.profile.test.model.PriceModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class MockUtils {

    public static PriceEntity aPriceEntity() {
        return PriceEntity.builder()
                .id(UUID.randomUUID())
                .productId(11L)
                .brandId(22L)
                .priceList(33L)
                .price(new BigDecimal("44.0"))
                .currency("EUR")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(1))
                .build();
    }

    public static PriceModel aPriceModel() {
        return PriceModel.builder()
                .productId(11L)
                .brandId(22L)
                .priceList(33L)
                .price(new BigDecimal("44.0"))
                .currency("EUR")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(1))
                .build();
    }
}
