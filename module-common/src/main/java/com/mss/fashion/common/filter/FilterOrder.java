package com.mss.fashion.common.filter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** Smaller numbers have higher priority. */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilterOrder {
    public static final int CONTEXT_AWARE_FILTER = 1;
    public static final int HTTP_LOG_FILTER = 2;
}
