package com.mss.fashion.common.openapi;

import java.io.InputStream;
import java.util.Map;

import com.mss.fashion.common.file.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.info.BuildProperties;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import org.yaml.snakeyaml.Yaml;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenApiServiceImpl implements OpenApiService {

    private static final String OPEN_API_YAML_FILE = "openapi.yaml";

    private final BuildProperties buildProperties;

    @Override
    @NonNull
    public String generateOpenApiYamlContent() {
        final String version = this.buildProperties.getVersion();
        final InputStream inputStream = FileUtil.getResourceInputStream(OPEN_API_YAML_FILE);
        final Yaml yaml = new Yaml();
        final Map<String, Object> root = yaml.load(inputStream);
        final Object info = root.get("info");
        @SuppressWarnings("unchecked")
        final Map<String, Object> map = (Map<String, Object>) info;
        map.put("version", version);
        return yaml.dump(root);
    }
}
