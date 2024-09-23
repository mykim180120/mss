package com.mss.fashion.api.price.dto;

public record PriceByCategoryGetResponse(
        String categoryName,
        PriceProductDto greatestPriceProduct,
        PriceProductDto lowestPriceProduct) {}
