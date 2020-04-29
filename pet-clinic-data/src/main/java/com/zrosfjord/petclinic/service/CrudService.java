package com.zrosfjord.petclinic.service;

import java.util.Optional;

public interface CrudService<T> {

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

    //TODO: Add a count

}
