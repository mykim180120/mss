package com.mss.fashion.common.error.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BaseErrorResponse {
    private final long errorCode;
    private final String errorMessage;
}
