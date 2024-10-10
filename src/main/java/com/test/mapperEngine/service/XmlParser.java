package com.test.mapperEngine.service;

import com.test.mapperEngine.model.Source;
import com.test.mapperEngine.service.interfaces.DataParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlParser implements DataParser<Source> {
    @Override
    public Source parse(String input) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Source.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Source) unmarshaller.unmarshal(new StringReader(input));
    }
}
