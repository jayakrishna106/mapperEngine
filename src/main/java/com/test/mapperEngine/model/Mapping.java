package com.test.mapperEngine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Mapping between fields (source and target paths, and data types)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mapping {
    private String id; // Random unique identifier for the mapping
    private String type; // Format type (json, xml, etc.)
    private String path; // JSONPath, XPath, or DB path
    private String dataType; // string, int, etc. (can be converted)
}
