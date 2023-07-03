package com.mjc.school.repository;

import java.util.List;

public interface Repository<T> {
    List<T> readAll();

    T readById(Long id);

    T create(T model);

    T update(T model);

    Boolean exist(Long id);
    Boolean deleteById(Long id);

}
