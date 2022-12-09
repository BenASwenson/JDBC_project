package com.sparta;

import com.sparta.dao.mysql.EmployeeDAO;
import com.sparta.entities.Employee;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){

//        Scanner in = new Scanner(System.in);
//        System.out.println("choose the file name: ");
//        String fileName = in.next();


        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        int counter2 = 0;
        List<Employee> list2 = employeeDAO.findEmployeesByDeptAndDate("Development", LocalDate.of(1999,1, 1), LocalDate.of(2000,1,1));
        for (Employee e: list2){
            counter2++;
            System.out.println(e);
        }
        System.out.println(counter2);

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