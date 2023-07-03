package com.mjc.school.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();

    T getById(Long id);

    T addNew(T model);

    T update(T model);

    Boolean exist(Long id);
    Boolean deleteById(Long id);

}
