package com.test.mapperEngine.service;

import java.util.function.Function;

public class GenericMapper<Source, Target> {
    public Target map(Source source, Function<Source, Target> mappingFunction) {
        return mappingFunction.apply(source);
    }
}
