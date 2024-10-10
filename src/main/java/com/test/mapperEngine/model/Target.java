package com.test.mapperEngine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Target {
    private int id;
    private String fullName;
    private String filePath;
    private String targetPath;
}
