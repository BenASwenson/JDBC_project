package com.sparta.dao.mysql;

import com.sparta.dao.interfaces.DAO;
import com.sparta.entities.Employee;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO implements DAO<Employee> {

    private static EmployeeDAO instance = null;

    private static Connection conn = null;

    public static EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new EmployeeDAO();
        }
        if (conn == null) {
            Properties properties = new Properties();
            try {
                properties.load(new FileReader("src/main/resources/dbconnect.properties"));
                conn = DriverManager.getConnection(properties.getProperty("mysql.url"),
                        properties.getProperty("mysql.username"),
                        properties.getProperty("mysql.password"));
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }


    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM employees"
            );
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("emp_no"), fromStringToLocalDate(rs.getString("birth_date")),
                        rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"),
                        fromStringToLocalDate(rs.getString("hire_date"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Employee> findEmployeesByDeptAndDate(String dept_name, LocalDate from_date, LocalDate to_date) {
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT \n" +
                            "    E.emp_no,\n" +
                            "    birth_date,\n" +
                            "    first_name,\n" +
                            "    last_name,\n" +
                            "    gender,\n" +
                            "    hire_date,\n" +
                            "    D.dept_no,\n" +
                            "    dept_name,\n" +
                            "    from_date,\n" +
                            "    to_date\n" +
                            "FROM\n" +
                            "    employees AS E\n" +
                            "        INNER JOIN\n" +
                            "    dept_emp AS DE ON DE.emp_no = E.emp_no\n" +
                            "        LEFT JOIN\n" +
                            "    departments AS D ON DE.dept_no = D.dept_no\n" +
                            "WHERE\n" +
                            "    (dept_name = ?\n" +
                            "        AND from_date > ?\n" +
                            "        AND to_date < ?);\n");
            preparedStatement.setString(1, dept_name);
            preparedStatement.setString(2, String.valueOf(from_date));
            preparedStatement.setString(3, String.valueOf(to_date));

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("emp_no"), fromStringToLocalDate(rs.getString("birth_date")),
                        rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"),
                        fromStringToLocalDate(rs.getString("hire_date"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

    public static LocalDate fromStringToLocalDate(String date) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(date, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e);
        }
    }
}
