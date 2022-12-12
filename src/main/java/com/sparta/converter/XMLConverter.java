package com.sparta.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sparta.entities.Employee;

public class XMLConverter {

    public static String objectToXml(Employee employee) {
        XmlMapper mapper = new XmlMapper();
        try {
            return mapper.writeValueAsString(employee);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Employee XmlToObject(String str) {
        XmlMapper mapper = new XmlMapper();
        try {
            return mapper.readValue(str, Employee.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
