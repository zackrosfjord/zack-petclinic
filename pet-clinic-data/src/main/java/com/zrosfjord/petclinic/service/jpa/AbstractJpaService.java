package com.zrosfjord.petclinic.service.jpa;

import com.zrosfjord.petclinic.model.BaseEntity;
import com.zrosfjord.petclinic.service.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class AbstractJpaService<T extends BaseEntity, R extends CrudRepository<T, Long>> implements CrudService<T> {

    protected R repository;

    public AbstractJpaService(R repository) {
        this.repository = repository;
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public T save(T object) {
        if (object != null) {
            return repository.save(object);
        } else {
            throw new RuntimeException("Object cannot be null!");
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void delete(T object) {
        repository.delete(object);
    }

}
