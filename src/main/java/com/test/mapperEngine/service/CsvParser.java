package com.test.mapperEngine.service;

import com.opencsv.CSVReader;
import com.test.mapperEngine.model.Source;
import com.test.mapperEngine.service.interfaces.DataParser;

import java.io.StringReader;

public class CsvParser implements DataParser<Source> {
    @Override
    public Source parse(String input) throws Exception {
        try (CSVReader reader = new CSVReader(new StringReader(input))) {
            String[] data = reader.readNext();
            if (data != null) {
                return new Source(Integer.parseInt(data[0]), data[1], data[2], data[3]);
            }
        }
        return null;
    }
}
