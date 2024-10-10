package com.test.mapperEngine.controller;

import com.test.mapperEngine.model.DatasourceConfig;
import com.test.mapperEngine.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    @Autowired
    private MappingService mappingService;

    @PostMapping("/transform")
    public String transform(@RequestBody DatasourceConfig datasourceConfig, @RequestBody Object sourceData) throws Exception {
        // Call the service to transform the source data based on the config
        return mappingService.transform(datasourceConfig, sourceData);
    }

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "Service is Running";
    }
}
