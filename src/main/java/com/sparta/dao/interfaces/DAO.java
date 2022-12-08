package com.sparta.dao.interfaces;

import java.util.List;

public interface DAO<T> extends AutoCloseable {

    List<T> findAll();
}
