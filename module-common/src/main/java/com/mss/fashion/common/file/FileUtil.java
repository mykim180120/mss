package com.mss.fashion.common.file;

import java.io.IOException;
import java.io.InputStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.ClassPathResource;
import org.springframework.lang.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class FileUtil {
    @NonNull
    public static InputStream getResourceInputStream(@NonNull final String filePath) {
        ClassPathResource classPathResource = new ClassPathResource(filePath);
        try {
            return classPathResource.getInputStream();
        } catch (IOException e) {
            log.error("Failed to read [classpath:{}] file", filePath);
            throw new FileReadError();
        }
    }
}
