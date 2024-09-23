package com.mss.fashion.common.error.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MalformedUrlErrorResponse extends BaseErrorResponse {
    public MalformedUrlErrorResponse() {
        super(CommonErrorConst.MALFORMED_URL_ERROR_CODE, CommonErrorConst.MALFORMED_URL_ERROR_MESSAGE);
    }
}
