package com.mss.fashion.api.price.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class PriceProductDto {
    private String brandName;
    private BigDecimal productPrice;
}
