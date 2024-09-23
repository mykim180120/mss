package com.mss.fashion.common.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeZoneConfig {

    public TimeZoneConfig() {
        setTimeZone();
    }

    private void setTimeZone() {
        final TimeZone timeZone = TimeZone.getTimeZone("UTC");
        // change ZoneId "UTC" to "Z". it removes a displayName suffix "[UTC]".
        timeZone.setID("Z");
        TimeZone.setDefault(timeZone);
    }
}
