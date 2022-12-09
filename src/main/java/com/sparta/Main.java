package com.sparta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.Model.XmlWriter;
import com.sparta.converter.XmlConverter;
import com.sparta.dao.mySql.EmployeeDAO;
import com.sparta.entities.Employee;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();

//        List<Employee> list2 = employeeDAO.findEmployeesByDeptAndDate("Development", LocalDate.of(2005,5, 5));
//        for (Employee e: list2){
//            System.out.println(e);
//        }

//        Employee testEmployee = new Employee(1, LocalDate.of(1995,5,5), "test", "employee", "m", LocalDate.of(1995,5,6));
//        XmlWriter xmlWriter = new XmlWriter();
//        //  \/\/ METHOD TO TEST \/\/
//        xmlWriter.writeTo(testEmployee, "testEmployee");
//        //  /\/\ METHOD TO TEST /\/\
//        ObjectMapper mapper = new ObjectMapper();
//        XmlConverter converter = new XmlConverter();
//        System.out.println(converter.XMLtoObject("<Employee><employeeNumber>1</employeeNumber><dob>1995-05-05</dob><firstName>test</firstName><lastName>employee</lastName><gender>m</gender><hireDate>1995-05-06</hireDate></Employee>"));
//        System.out.println(converter.ObjectToXML(testEmployee));
//
//        List<Employee> all = employeeDAO.findAll();
//        try {
//            EmployeeDAO.getInstance().close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        int counter = 0;
//        for (Employee e: all) {
//            System.out.println(e);
//            counter++;
//        }
//        System.out.println(counter);
    }
}