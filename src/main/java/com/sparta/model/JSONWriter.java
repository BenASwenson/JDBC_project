package com.sparta.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.entities.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JSONWriter implements Writer{
    private static String fileWithPath = "src/main/resources/";
    List<Employee> employees;

    public JSONWriter(List<Employee> employees, String file){
        fileWithPath += file + ".json";
        this.employees = employees;
    }

    @Override
    public void writeTo(Employee employee, String file) {
        //  write to JSON
        fileWithPath += file + ".json";
        ObjectMapper mapper = new ObjectMapper();
        try(BufferedWriter bw =  new BufferedWriter(new FileWriter(fileWithPath))){
            bw.write(mapper.writeValueAsString(employee));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
