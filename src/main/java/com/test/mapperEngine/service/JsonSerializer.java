package com.test.mapperEngine.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.mapperEngine.model.Target;
import com.test.mapperEngine.service.interfaces.DataSerializer;

public class JsonSerializer implements DataSerializer<Target> {
    @Override
    public String serialize(Target target) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(target);
    }
}
