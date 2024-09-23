package com.mss.fashion.common.context;

import java.io.IOException;
import java.util.UUID;

import com.mss.fashion.common.filter.FilterOrder;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(FilterOrder.CONTEXT_AWARE_FILTER)
public class ContextAwareFilter implements Filter {
    private static final String CORRELATION_ID_HEADER_NAME = "X-Correlation-Id";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final String correlationId = retrieveCorrelationId(httpServletRequest);
        RequestContextStore.setRequestContext(new RequestContext(correlationId));
        chain.doFilter(request, response);
        RequestContextStore.clearRequestContext();
    }

    public static String retrieveCorrelationId(HttpServletRequest httpServletRequest) {
        String correlationId = httpServletRequest.getHeader(CORRELATION_ID_HEADER_NAME);
        if (correlationId == null) {
            UUID uuid = UUID.randomUUID(); // uuid v4
            correlationId = uuid.toString();
        }
        return correlationId;
    }
}
