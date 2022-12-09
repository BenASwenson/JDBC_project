package com.sparta.dao.mySql;

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

    private static PreparedStatement findAllPS = null;

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
        if (findAllPS == null) {
            try {
                findAllPS = conn.prepareStatement("SELECT * FROM employees");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }


    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        try {
            ResultSet resultSet = findAllPS.executeQuery();
            while (resultSet.next()) {
                list.add(new Employee(resultSet.getInt(1), fromStringToLocalDate(resultSet.getString(2)), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), fromStringToLocalDate(resultSet.getString(6))));
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
