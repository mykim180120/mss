package com.mss.fashion.common.log;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import lombok.AllArgsConstructor;
import lombok.Getter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

// Ref. https://logback.qos.ch/manual/layouts.html
public class JsonLogLayout extends LayoutBase<ILoggingEvent> {
    private final Gson gson;

    public JsonLogLayout() {
        super();
        this.gson =
                new GsonBuilder().registerTypeAdapter(Date.class, new DateTimeSerializer()).create();
    }

    private static class DateTimeSerializer implements JsonSerializer<Date> {
        private final DateFormat dateFormat;

        public DateTimeSerializer() {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            dateFormat.setTimeZone(timeZone);
            this.dateFormat = dateFormat;
        }

        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(this.dateFormat.format(src));
        }
    }

    @AllArgsConstructor
    @Getter
    private static class LogOutput {
        private String message;
        private Date timestamp;
    }

    public String doLayout(ILoggingEvent event) {
        final LogOutput logOutput = new LogOutput(event.getMessage(), new Date(event.getTimeStamp()));
        return this.gson.toJson(logOutput) + CoreConstants.LINE_SEPARATOR;
    }
}
