package com.sparta;

import com.sparta.dao.mysql.EmployeeDAO;
import com.sparta.entities.Employee;
import com.sparta.model.WriterFactory;
import com.sparta.view.UserInput;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();

        Scanner in = new Scanner(System.in);

        WriterFactory wf = new WriterFactory();

//        System.out.println("Please choose the department to select from: \n" +
//                "1: Customer Service, 2: Development, 3: Finance, 4: Human Resources, 5: Marketing, 6: Production, " +
//                "7: Quality Management, 8: Research, 9: Sales");

//        String deptName = UserInput.getDepartment(in.nextInt());
//        System.out.println("Enter from date: ");
//        LocalDate fromDate = UserInput.dateOneValidator(in.next());
//        System.out.println("Enter to date: ");
//        LocalDate toDate = UserInput.dateTwoValidator(fromDate, in.next());


        List<Employee> list2 = employeeDAO.findEmployeesByDeptAndDate("Development",
                LocalDate.of(1999,1,1), LocalDate.of(2001,1,1));
//        for (Employee e: list2){
//            System.out.println(e);
//        }

//        List<Employee> list3 = employeeDAO.findEmployeesByDeptAndDate(deptName, fromDate, toDate);
//        for (Employee e: list3){
//            System.out.println(e);
//        }

        // write list2 to xml/json using factory method
        System.out.println("What file format would you like to write to (xml/JSON): ");
        wf.createWriter(list2, validateInput(in.next())).writeTo();
        wf.createWriter(list2, validateInput(in.next())).writeTo();
    }
}