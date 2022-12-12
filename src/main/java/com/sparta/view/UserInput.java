package com.sparta.view;

import java.time.LocalDate;
import java.util.*;

import static com.sparta.dao.mysql.EmployeeDAO.fromStringToLocalDate;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getDepartment(int input) {
        List<String> departments = new ArrayList<>(Arrays.asList("Customer Service", "Development", "Finance",
                "Human Resources", "Marketing", "Production", "Quality Management", "Research", "Sales"));
        int dept_no = input;
        while (dept_no < 1 || dept_no > 9) {
            System.out.println("Please enter a number between 1 and 9: ");
            dept_no = scanner.nextInt();
        }
        return departments.get(dept_no - 1);
    }

    public static LocalDate dateOneValidator(String date) {
        while (!date.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            System.out.println("Invalid date, please enter again: ");
            date = scanner.next();
        }
        return fromStringToLocalDate(date);
    }

    public static LocalDate dateTwoValidator(LocalDate from, String to) {
        while (!to.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$") ||
                fromStringToLocalDate(to).isBefore(from)) {
            System.out.println("Input Date, please enter again: ");
            to = scanner.next();
        }
        return fromStringToLocalDate(to);
    }

    public static String validateInput(String input) {
        if ("xml".equalsIgnoreCase(input) || "json".equalsIgnoreCase(input)) {
            return input;
        } else {
            System.out.print("Invalid input! Please enter 'xml' or 'json': ");
            input = scanner.next();
            return validateInput(input);
        }
    }
}