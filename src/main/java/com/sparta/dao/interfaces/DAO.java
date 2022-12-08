package com.sparta.dao.interfaces;

import java.util.List;

public interface DAO<T> {

    List<T> findAll();
}
