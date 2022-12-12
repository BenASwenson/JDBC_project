package com.sparta.model;

import com.sparta.entities.Employee;
import com.sparta.view.*;

import java.util.List;

public class WriterFactory {
    String defaultName = "employees";
    static int counter = 0;

    public Writer createWriter(List<Employee> employeesToBeWritten, String format) {
        //format = UserInput.validateInput(format);

        if(format.equalsIgnoreCase("xml")) {
            counter++;
            return new XMLWriter(employeesToBeWritten, defaultName + counter);
        } else if(format.equalsIgnoreCase("json")) {
            counter++;
            return new JSONWriter(employeesToBeWritten, defaultName + counter);
        } else {
            return null;
        }
    }
}
