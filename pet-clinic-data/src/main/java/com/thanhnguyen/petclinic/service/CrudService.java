package com.thanhnguyen.petclinic.service;

import java.util.List;

public interface CrudService<T, ID> {
    T findById(ID id);
    T save(T object);
    List<T> findAll();
    void delete(T object);
    void deleteById(ID id);
}
