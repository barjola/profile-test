package com.profile.test.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static com.profile.test.utils.MockUtils.aPriceEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PriceMapperTest {

    private final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    @Test
    void toDto() {
        var priceEntity = aPriceEntity();

        var result = mapper.toDto(priceEntity);

        assertNotNull(result);
        assertEquals(priceEntity.getProductId(), result.getProductId());
        assertEquals(priceEntity.getBrandId(), result.getBrandId());
        assertEquals(priceEntity.getPriceList(), result.getPriceList());
        assertEquals(priceEntity.getStartDate(), result.getStartDate());
        assertEquals(priceEntity.getEndDate(), result.getEndDate());
        assertEquals(priceEntity.getPrice(), result.getPrice());
        assertEquals(priceEntity.getCurrency(), result.getCurrency());

    }
}