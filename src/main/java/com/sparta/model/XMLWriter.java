package com.sparta.model;

import com.sparta.converter.XMLConverter;
import com.sparta.entities.Employee;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class XMLWriter implements Writer{
    private String fileWithPath = "src/main/resources/";
    List<Employee> employees;

    public XMLWriter(List<Employee> employees, String file) {
        fileWithPath += file + ".xml";
        this.employees = employees;
    }

    @Override
    public void writeTo() {
        //  write to XML
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileWithPath))) {
            for(Employee employee : employees) {
                bw.write(XMLConverter.objectToXml(employee));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
