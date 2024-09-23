package com.mss.fashion.common.context;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.springframework.lang.NonNull;

import org.slf4j.MDC;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestContextStore {
    public static final String CORRELATION_ID_MDC_KEY = "CorrelationId";

    public static final RequestContext INITIALIZED = new RequestContext("Not Initialized");

    private static final ThreadLocal<RequestContext> requestContextContainer = new ThreadLocal<>();

    public static void clearRequestContext() {
        requestContextContainer.set(INITIALIZED);
        MDC.remove(CORRELATION_ID_MDC_KEY);
    }

    public static void setRequestContext(@NonNull RequestContext requestContext) {
        requestContextContainer.set(requestContext);
        MDC.put(CORRELATION_ID_MDC_KEY, requestContext.correlationId());
    }

    public static RequestContext getRequestContext() {
        RequestContext requestContext = requestContextContainer.get();
        if (requestContext == null) {
            return INITIALIZED;
        }
        return requestContext;
    }
}
