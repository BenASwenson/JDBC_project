package com.sparta;

import com.sparta.dao.mySql.EmployeeDAO;
import com.sparta.entities.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        List<Employee> all = employeeDAO.findAll();
        int counter = 0;
        for (Employee e: all) {
            System.out.println(e);
            counter++;
        }
        System.out.println(counter);
    }
}