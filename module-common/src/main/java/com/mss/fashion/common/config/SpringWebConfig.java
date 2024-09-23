package com.mss.fashion.common.config;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.mss.fashion.common.constant.StringFormatConst;
import com.mss.fashion.common.datetime.DateTimeUtil;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class SpringWebConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return (Jackson2ObjectMapperBuilder builder) -> {
            builder.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
            builder.serializers(
                    new LocalDateTimeSerializer(
                            DateTimeFormatter.ofPattern(StringFormatConst.DATE_TIME_OUTPUT_FORMAT)));
            builder.serializerByType(
                    ZonedDateTime.class,
                    new JsonSerializer<ZonedDateTime>() {
                        @Override
                        public void serialize(
                                ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers)
                                throws IOException {
                            gen.writeString(DateTimeUtil.toUtcIso8601(value));
                        }
                    });
        };
    }
}
