package com.test.mapperEngine.service;

import java.util.function.Function;

public class FieldTransformations {
    // Example transformation function: Convert to Uppercase
    public static Function<String, String> toUpperCase = (input) -> input != null ? input.toUpperCase() : null;

    // Example transformation function: Trim string
    public static Function<String, String> trimString = (input) -> input != null ? input.trim() : null;

    // Example transformation function: Convert string to integer
    public static Function<String, Integer> stringToInt = (input) -> input != null ? Integer.parseInt(input) : null;
}
