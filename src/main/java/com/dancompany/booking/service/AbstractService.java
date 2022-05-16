package com.dancompany.booking.service;

import java.util.Collection;
import java.util.List;

public interface AbstractService<T> {
    T save(T entity);
    List<T> saveAll(List<T> entities);
    Collection<T> list(int limit);
    Collection<T> getAll();
    T getById(Long id);
    T update(T entity);
    Boolean deleteById(Long id);
    T updateById(Long id, T updatedEntity);
}

