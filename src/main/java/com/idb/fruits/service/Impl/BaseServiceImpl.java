package com.idb.fruits.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    // Add @Override annotation before the method signature
    // @Override
    // public void updateById(ID id) {
    //     Optional<T> optionalEntity = findById(id);
    //     if (optionalEntity.isPresent()) {
    //     }

    // }

}
