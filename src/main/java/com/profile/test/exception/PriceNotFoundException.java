package com.profile.test.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(LocalDateTime date, Long productId, Long brandId) {
        super("Price not found for date: " + date + " productId: " + productId + " brandId: " + brandId);
    }
}
