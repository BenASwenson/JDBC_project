package com.sparta.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

public interface DAO<T> extends AutoCloseable {

    List<T> findAll();
    List<T> findEmployeesByDeptAndDate(String dept_name, LocalDate from_date, LocalDate to_date);
}
