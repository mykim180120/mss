package com.mss.fashion.api.price.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PriceCategoryDto {
    private String categoryName;
    private PriceProductDto greatestPriceProduct;
    private PriceProductDto lowestPriceProduct;
}
