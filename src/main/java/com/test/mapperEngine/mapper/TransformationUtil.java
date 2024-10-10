package com.example.mapper.service;

import com.test.mapperEngine.model.DatasourceConfig;
import com.test.mapperEngine.model.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.util.Map;
import java.util.HashMap;

@Service
class MappingService {

    @Autowired
    private Configuration freemarkerConfig; // Inject the Freemarker config

    public String transform(DatasourceConfig datasourceConfig, Object sourceData) throws Exception {
        // Iterate over mappings, extract and transform source data
        Map<String, Object> transformedData = new HashMap<>();

        for (Mapping mapping : datasourceConfig.getDatasource().getMappings()) {
            Object extractedData = extractData(mapping, sourceData);
            transformedData.put(mapping.getId(), convertDataType(mapping.getDataType(), extractedData));
        }

        // Use Freemarker to generate the target output based on the transformed data
        return generateTargetOutput(transformedData, "target-template.ftl");
    }

    // Extract data using the mapping's path (e.g., JSONPath, XPath)
    private Object extractData(Mapping mapping, Object sourceData) {
        // Handle different formats (json, xml, etc.)
        switch (mapping.getType()) {
            case "json":
                return extractJsonData(mapping.getPath(), sourceData);
            case "xml":
                return extractXmlData(mapping.getPath(), sourceData);
            case "csv":
                return extractCsvData(mapping.getPath(), sourceData);
            default:
                throw new IllegalArgumentException("Unsupported source type");
        }
    }

    // Placeholder function for JSON data extraction using JSONPath
    private Object extractJsonData(String jsonPath, Object jsonData) {
        // Implement JSONPath extraction logic (using Jackson or other libraries)
        return null; // Return extracted value
    }

    // Placeholder function for XML data extraction using XPath
    private Object extractXmlData(String xpath, Object xmlData) {
        // Implement XPath extraction logic
        return null; // Return extracted value
    }

    // Placeholder function for CSV data extraction (assuming simple mapping)
    private Object extractCsvData(String path, Object csvData) {
        // Implement CSV extraction logic
        return null; // Return extracted value
    }

    // Convert data to the specified target data type
    private Object convertDataType(String dataType, Object data) {
        // Perform type conversion logic
        switch (dataType) {
            case "string":
                return data.toString();
            case "int":
                return Integer.parseInt(data.toString());
            case "double":
                return Double.parseDouble(data.toString());
            default:
                return data; // Default is no conversion
        }
    }

    // Use Freemarker to generate the target output using a template
    private String generateTargetOutput(Map<String, Object> transformedData, String templateName) throws Exception {
        Template template = freemarkerConfig.getTemplate(templateName);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, transformedData);
    }
}
