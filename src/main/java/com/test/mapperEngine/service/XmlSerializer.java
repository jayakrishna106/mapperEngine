package com.test.mapperEngine.service;

import com.test.mapperEngine.model.Target;
import com.test.mapperEngine.service.interfaces.DataSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlSerializer implements DataSerializer<Target> {
    @Override
    public String serialize(Target target) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Target.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        StringWriter sw = new StringWriter();
        marshaller.marshal(target, sw);
        return sw.toString();
    }
}
