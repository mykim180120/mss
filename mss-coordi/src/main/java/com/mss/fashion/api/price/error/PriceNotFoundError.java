package com.mss.fashion.api.price.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class PriceNotFoundError extends PriceServiceError {
    private final long brandId;
}
