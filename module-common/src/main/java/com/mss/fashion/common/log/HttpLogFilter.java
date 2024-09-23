package com.mss.fashion.common.log;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.mss.fashion.common.filter.FilterOrder;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
@Order(FilterOrder.HTTP_LOG_FILTER)
@Slf4j
public class HttpLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final ContentCachingRequestWrapper cachedRequest =
                new ContentCachingRequestWrapper((HttpServletRequest) request);
        final ContentCachingResponseWrapper cachedResponse =
                new ContentCachingResponseWrapper((HttpServletResponse) response);
        HttpLogFilter.logRequest(cachedRequest);
        chain.doFilter(cachedRequest, cachedResponse);
        HttpLogFilter.logResponse(cachedRequest, cachedResponse);
    }

    static void logRequest(final ContentCachingRequestWrapper request) {
        final String method = request.getMethod();
        final String requestURI = request.getRequestURI();
        final String queryString = request.getQueryString();
        final String formattedQueryString = StringUtils.hasText(queryString) ? "?" + queryString : "";
        final String requestBody = HttpLogFilter.getRequestBody(request);
        if (requestBody.isEmpty()) {
            log.info("RCV | {} {}{}", method, requestURI, formattedQueryString);
        } else {
            log.info("RCV | {} {}{} | body = {}", method, requestURI, formattedQueryString, requestBody);
        }
    }

    static void logResponse(
            final ContentCachingRequestWrapper request, final ContentCachingResponseWrapper response) {
        final String method = request.getMethod();
        final String requestURI = request.getRequestURI();
        final String queryString = request.getQueryString();
        final String formattedQueryString = StringUtils.hasText(queryString) ? "?" + queryString : "";
        final int status = response.getStatus();
        final String responseBody = HttpLogFilter.getResponseBody(response);
        if (status < 500) {
            if (responseBody.isEmpty()) {
                log.info("SNT | {} {}{} | {}", method, requestURI, formattedQueryString, status);
            } else {
                log.info(
                        "SNT | {} {}{} | {} | body = {}",
                        method,
                        requestURI,
                        formattedQueryString,
                        status,
                        responseBody);
            }
        } else {
            if (responseBody.isEmpty()) {
                log.error("SNT | {} {}{} | {}", method, requestURI, formattedQueryString, status);
            } else {
                log.error(
                        "SNT | {} {}{} | {} | body = {}",
                        method,
                        requestURI,
                        formattedQueryString,
                        status,
                        responseBody);
            }
        }
    }

    @NonNull
    static String getRequestBody(final ContentCachingRequestWrapper request) {
        final InputStream inputStream = new ByteArrayInputStream(request.getContentAsByteArray());
        try {
            return StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException ignored) {
        }
        return "";
    }

    @NonNull
    static String getResponseBody(final ContentCachingResponseWrapper response) {
        final InputStream inputStream = response.getContentInputStream();
        try {
            final String responseBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            response.copyBodyToResponse();
            return responseBody;
        } catch (IOException ignored) {
        }
        return "";
    }
}
