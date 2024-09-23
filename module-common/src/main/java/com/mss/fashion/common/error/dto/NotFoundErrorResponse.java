package com.mss.fashion.common.error.dto;

public class NotFoundErrorResponse extends BaseErrorResponse {
    public NotFoundErrorResponse() {
        super(CommonErrorConst.NOT_FOUND_ERROR_CODE, CommonErrorConst.NOT_FOUND_ERROR_MESSAGE);
    }
}
