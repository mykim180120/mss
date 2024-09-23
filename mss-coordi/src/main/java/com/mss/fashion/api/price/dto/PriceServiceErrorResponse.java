package com.mss.fashion.api.price.dto;

import com.mss.fashion.common.error.dto.BaseErrorResponse;

public class PriceServiceErrorResponse extends BaseErrorResponse {
    public PriceServiceErrorResponse(long errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
