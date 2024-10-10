package com.test.mapperEngine.service;

import com.test.mapperEngine.service.interfaces.Converter;

public class StringToBooleanConverter implements Converter<String, Boolean> {
    @Override
    public Boolean convert(String source) {
        return source != null ? Boolean.valueOf(source) : null;
    }
}