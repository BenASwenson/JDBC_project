package com.sparta.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.entities.Employee;

public class JSONConverter {

    public static String objectToJson(Employee employee) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(employee);
    }

    public static Employee jsonToObject(String s) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, Employee.class);
    }


}
