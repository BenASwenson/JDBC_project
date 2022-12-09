package com.sparta.model;

import com.sparta.entities.Employee;

public interface Writer {
    abstract void writeTo(Employee employee, String file);
}
