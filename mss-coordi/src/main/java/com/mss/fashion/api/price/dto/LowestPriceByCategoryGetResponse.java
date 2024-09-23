package com.mss.fashion.api.price.dto;

import java.math.BigDecimal;
import java.util.List;

public record LowestPriceByCategoryGetResponse(
        BigDecimal totalPrice,
        List<LowestPriceCategoryDto> lowestPriceCategoryDtoList) {}