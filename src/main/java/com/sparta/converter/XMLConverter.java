package com.sparta.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sparta.entities.Employee;

public class XMLConverter {

    public String ObjectToXML(Employee employee) {
        XmlMapper mapper = new XmlMapper();
        try {
            return mapper.writeValueAsString(employee);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee XMLtoObject(String str) {
        XmlMapper mapper = new XmlMapper();
        try {
            return mapper.readValue(str, Employee.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
