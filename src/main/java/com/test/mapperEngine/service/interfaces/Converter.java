package com.test.mapperEngine.service.interfaces;

public interface Converter<S, T> {
    T convert(S source);
}
