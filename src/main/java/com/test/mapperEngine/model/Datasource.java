package com.test.mapperEngine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Datasource object, supporting different formats like JSON, XML, etc.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datasource {
    private String type; // json, xml, csv, database
    private List<Mapping> mappings; // List of field mappings
}