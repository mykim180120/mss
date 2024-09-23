package com.mss.fashion.common.context;

import org.springframework.lang.NonNull;

public record RequestContext(@NonNull String correlationId) {}
