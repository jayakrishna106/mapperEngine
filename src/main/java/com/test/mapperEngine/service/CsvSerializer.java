package com.test.mapperEngine.service;

import com.opencsv.CSVWriter;
import com.test.mapperEngine.model.Target;
import com.test.mapperEngine.service.interfaces.DataSerializer;

import java.io.StringWriter;

public class CsvSerializer implements DataSerializer<Target> {
    @Override
    public String serialize(Target target) throws Exception {
        StringWriter sw = new StringWriter();
        try (CSVWriter writer = new CSVWriter(sw)) {
            String[] data = {String.valueOf(target.getId()), target.getFullName(), target.getFilePath(), target.getTargetPath()};
            writer.writeNext(data);
        }
        return sw.toString();
    }
}
