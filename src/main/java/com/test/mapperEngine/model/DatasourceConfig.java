package com.test.mapperEngine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Represents a Datasource configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatasourceConfig {
    private Datasource datasource; // Single datasource for now
}



