package com.sparta;

import com.sparta.dao.mySql.EmployeeDAO;
import com.sparta.entities.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
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