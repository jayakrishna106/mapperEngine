package com.test.mapperEngine.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataSource {
    private String jsonType; // e.g., json, xml
    private String id;       // Unique identifier for the data source
    private String name;     // Name of the data source
    private String description; // Description of the data source
    private String path;     // XPath or JSONPath
    private String dataSourceType; // SOURCE or TARGET
}