package com.test.mapperEngine.mapper;

import com.test.mapperEngine.config.DataSource;
import com.test.mapperEngine.config.MappingConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GenericMapper {
    private final MappingConfig mappingConfig;
    private final Map<String, Function<Object, Object>> transformations = new HashMap<>();

    public GenericMapper(MappingConfig mappingConfig) {
        this.mappingConfig = mappingConfig;
        initializeTransformations();
    }

    private void initializeTransformations() {
        transformations.put("toUpperCase", value -> ((String) value).toUpperCase());
        // Add more transformations as needed
    }

    public Object map(Object sourceData, String sourceType, String targetType) throws Exception {
        // Logic to read source data, apply transformations, and produce target data
        for (DataSource source : mappingConfig.getMapping().getDataSource()) {
            if (source.getDataSourceType().equalsIgnoreCase("SOURCE") && source.getJsonType().equalsIgnoreCase(sourceType)) {
                // Extract data based on path (JSONPath or XPath)
                Object extractedData = extractData(sourceData, source.getPath(), source.getJsonType());
                
                for (DataSource target : mappingConfig.getMapping().getDataSource()) {
                    if (target.getDataSourceType().equalsIgnoreCase("TARGET") && target.getJsonType().equalsIgnoreCase(targetType)) {
                        // Perform the transformation based on target path and required transformations
                        return transformData(extractedData, target);
                    }
                }
            }
        }
        return null; // Or throw an exception if mapping fails
    }

    private Object extractData(Object sourceData, String path, String jsonType) {
        // Implement extraction logic here based on the type of sourceData (JSON/XML)
        if ("json".equalsIgnoreCase(jsonType)) {
            // Example: Use a JSON library to parse the JSON and extract data using path
            return sourceData; // Placeholder
        } else if ("xml".equalsIgnoreCase(jsonType)) {
            // Example: Use XML parsing to extract data based on XPath
            return sourceData; // Placeholder
        }
        return null;
    }

    private Object transformData(Object data, DataSource target) {
        // Apply transformations based on mapping configuration
        String transformation = target.getPath(); // Example: Could be a transformation expression
        if (transformations.containsKey(transformation)) {
            return transformations.get(transformation).apply(data);
        }
        return data; // No transformation
    }

    public String convertToXml(Object obj) throws Exception {
        // Convert Java object to XML string
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        // Convert object to XML here (pseudo-implementation)
        // You can use JAXB or any other library for actual conversion
        Node root = document.createElement("root");
        document.appendChild(root);
        
        // ... Add elements from obj to XML
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        return writer.toString();
    }
}
