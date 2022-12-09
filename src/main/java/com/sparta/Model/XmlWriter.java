package com.sparta.Model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sparta.entities.Employee;

import java.io.*;

public class XmlWriter implements Writer{
    private static String fileWithPath = "src/main/resources/";

    @Override
    public void writeTo(Employee employee, String file) {
        //  write to XML
        fileWithPath += file + ".xml";
        XmlMapper mapper = new XmlMapper();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileWithPath))) {
            bw.write(mapper.writeValueAsString(employee));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
