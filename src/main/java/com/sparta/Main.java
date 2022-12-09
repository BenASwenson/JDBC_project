package com.sparta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.converter.XmlConverter;
import com.sparta.dao.mySql.EmployeeDAO;
import com.sparta.entities.Employee;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        Employee testEmployee = new Employee(1, LocalDate.of(1995,5,5), "test", "employee", "m", LocalDate.of(1995,5,6));
        ObjectMapper mapper = new ObjectMapper();
        XmlConverter converter = new XmlConverter();
        System.out.println(converter.XMLtoObject("<Employee><employeeNumber>1</employeeNumber><dob>1995-05-05</dob><firstName>test</firstName><lastName>employee</lastName><gender>m</gender><hireDate>1995-05-06</hireDate></Employee>"));
        System.out.println(converter.ObjectToXML(testEmployee));

        List<Employee> all = employeeDAO.findAll();
        try {
            EmployeeDAO.getInstance().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int counter = 0;
        for (Employee e: all) {
            System.out.println(e);
            counter++;
        }
        System.out.println(counter);
    }
}