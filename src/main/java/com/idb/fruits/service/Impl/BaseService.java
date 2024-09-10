package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    // T updateT(ID id, T t);
    void deleteById(ID id);
}