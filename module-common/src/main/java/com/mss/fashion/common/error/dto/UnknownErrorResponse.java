package com.mss.fashion.common.error.dto;

public class UnknownErrorResponse extends BaseErrorResponse {
    public UnknownErrorResponse() {
        super(CommonErrorConst.UNKNOWN_ERROR_CODE, CommonErrorConst.UNKNOWN_ERROR_MESSAGE);
    }
}
