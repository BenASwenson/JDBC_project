package com.sparta.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.converter.JSONConverter;
import com.sparta.entities.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONWriter implements Writer{
    private static String fileWithPath = "src/main/resources/";
    List<Employee> employees;

    public JSONWriter(List<Employee> employees, String file){
        fileWithPath += file + ".json";
        this.employees = employees;
    }

    @Override
    public void writeTo() {
        //  write to JSON
        try(BufferedWriter bw =  new BufferedWriter(new FileWriter(fileWithPath))){
            for(Employee employee : employees) {
                bw.write(JSONConverter.objectToJson(employee));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
