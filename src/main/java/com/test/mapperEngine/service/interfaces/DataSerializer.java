package com.test.mapperEngine.service.interfaces;

public interface DataSerializer<T> {
    String serialize(T object) throws Exception;
}
