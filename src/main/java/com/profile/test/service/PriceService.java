package com.profile.test.service;

import com.profile.test.exception.PriceNotFoundException;
import com.profile.test.mapper.PriceMapper;
import com.profile.test.model.PriceModel;
import com.profile.test.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public PriceModel queryPrice(LocalDateTime date, Long productId, Long brandId) {
        return priceRepository.findFirstPriceBetweenDates(date, productId, brandId)
                .map(priceMapper::toDto)
                .orElseThrow(() -> new PriceNotFoundException(date, productId, brandId));
    }

}
