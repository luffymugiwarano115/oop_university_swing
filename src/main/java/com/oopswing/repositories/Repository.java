package com.oopswing.repositories;

import java.util.List;

public interface Repository<T> {
    void persist(T entity);

    void update(T entity);

    T findById(int id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
