package com.mss.fashion.api.price.dto;

import lombok.Getter;

@Getter
public class PriceNotFoundErrorResponse extends PriceServiceErrorResponse {
    private final long brandId;

    public PriceNotFoundErrorResponse(long brandId){
        super(PriceServiceErrorConst.PRICE_NOT_FOUND_ERROR_CODE,
                PriceServiceErrorConst.PRICE_NOT_FOUND_ERROR_MESSAGE);
        this.brandId = brandId;
    }
}
