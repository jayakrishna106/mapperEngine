package com.test.mapperEngine.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MappingConfig {
    private Mapping mapping;

    @Data
    @NoArgsConstructor
    public static class Mapping {
        private String jsonType; // e.g., json, xml, csv
        private List<DataSource> dataSource;
    }

}
