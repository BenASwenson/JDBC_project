package com.sparta.Model;

import com.sparta.entities.Employee;
import java.io.File;

public interface Writer {
    abstract void writeTo(Employee employee, String file);
}
