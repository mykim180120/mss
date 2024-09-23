package com.mss.fashion.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MalformedUrlError extends BaseError {
    private final String wrongUrl;
}
