package com.test.mapperEngine.service;

import com.test.mapperEngine.service.interfaces.Converter;

public class StringToIntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return source != null ? Integer.valueOf(source) : null;
    }
}


