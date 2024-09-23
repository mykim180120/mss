package com.mss.fashion.product.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class ProductNotFoundError extends ProductServiceError {
    private final long brandId;
}
