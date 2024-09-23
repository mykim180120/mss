package com.mss.fashion.common.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    private final BuildProperties buildProperties;

    public HealthCheckController(@Autowired BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping("/")
    public SystemStatus getSystemStatus() {
        final String version = buildProperties.getVersion();
        return new SystemStatus(version);
    }
}
