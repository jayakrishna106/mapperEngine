package com.test.mapperEngine.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.mapperEngine.model.Source;
import com.test.mapperEngine.service.interfaces.DataParser;

public class JsonParser implements DataParser<Source> {
    @Override
    public Source parse(String input) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(input, Source.class);
    }
}
