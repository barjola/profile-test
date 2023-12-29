package com.profile.test.service;

import com.profile.test.exception.PriceNotFoundException;
import com.profile.test.mapper.PriceMapper;
import com.profile.test.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.profile.test.utils.MockUtils.aPriceEntity;
import static com.profile.test.utils.MockUtils.aPriceModel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @Mock
    private PriceMapper priceMapper;

    @Test
    void queryPrices_whenExists_shouldReturnPrice() {
        var date = LocalDateTime.now();
        var productId = 11L;
        var brandId = 22L;

        var priceEntity = aPriceEntity();
        var priceModel = aPriceModel();

        when(priceRepository.findFirstPriceBetweenDates(date, productId, brandId))
                .thenReturn(Optional.of(priceEntity));

        when(priceMapper.toDto(priceEntity)).thenReturn(priceModel);

        var result = priceService.queryPrice(date, productId, brandId);

        assertNotNull(result);
        assertEquals(priceModel, result);

    }

    @Test
    void queryPrices_whenNotExists_shouldThrowException() {
        var date = LocalDateTime.now();
        var productId = 11L;
        var brandId = 22L;

        when(priceRepository.findFirstPriceBetweenDates(date, productId, brandId))
                .thenReturn(Optional.empty());

        assertThrows(PriceNotFoundException.class, () ->
                priceService.queryPrice(date, productId, brandId));
    }

}