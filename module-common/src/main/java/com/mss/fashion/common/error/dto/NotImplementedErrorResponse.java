package com.mss.fashion.common.error.dto;

public class NotImplementedErrorResponse extends BaseErrorResponse {

    public NotImplementedErrorResponse() {
        super(
                CommonErrorConst.NOT_IMPLEMENTED_ERROR_CODE,
                CommonErrorConst.NOT_IMPLEMENTED_ERROR_MESSAGE);
    }
}
