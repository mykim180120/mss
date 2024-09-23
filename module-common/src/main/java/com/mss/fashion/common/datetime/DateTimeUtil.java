package com.mss.fashion.common.datetime;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeUtil {

    public static final DateTimeFormatter DEFAULT_ZONED_DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    public static final String ISO8601_REGEX =
            "^(?:[1-9]\\d{3}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1\\d|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[1-9]\\d(?:0[48]|[2468][048]|[13579][26])|(?:[2468][048]|[13579][26])00)-02-29)T(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d(?:\\.\\d{1,9})?(?:Z|[+-][01]\\d:[0-5]\\d)$";

    public static String toIso8601(@NonNull ZonedDateTime zonedDateTime, @NonNull ZoneId zoneId) {
        return zonedDateTime.withZoneSameInstant(zoneId).format(DEFAULT_ZONED_DATE_TIME_FORMATTER);
    }

    public static String toUtcIso8601(@NonNull ZonedDateTime zonedDateTime) {
        return toIso8601(zonedDateTime, ZoneOffset.UTC);
    }
}
