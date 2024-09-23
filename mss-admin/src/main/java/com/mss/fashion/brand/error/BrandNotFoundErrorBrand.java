package com.mss.fashion.brand.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class BrandNotFoundErrorBrand extends BrandServiceError {
    private final long brandId;
}
