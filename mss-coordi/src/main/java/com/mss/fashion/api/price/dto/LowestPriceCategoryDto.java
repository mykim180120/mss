package com.mss.fashion.api.price.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
public class LowestPriceCategoryDto {
    private BigDecimal totalPrice;
    private List<LowestPriceCategoryDto> lowestPriceCategoryDtoList;
}
