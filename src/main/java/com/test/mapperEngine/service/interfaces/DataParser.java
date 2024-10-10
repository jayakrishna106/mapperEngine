package com.test.mapperEngine.service.interfaces;

public interface DataParser<T> {
    T parse(String input) throws Exception;
}
