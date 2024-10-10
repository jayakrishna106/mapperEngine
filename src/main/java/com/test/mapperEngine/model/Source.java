package com.test.mapperEngine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Source {
    private int id;
    private String name;
    private String path;
    private String destination;
}
