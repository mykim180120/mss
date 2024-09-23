package com.mss.fashion.common.openapi;

import org.springframework.lang.NonNull;

public interface OpenApiService {
    @NonNull
    String generateOpenApiYamlContent();
}
