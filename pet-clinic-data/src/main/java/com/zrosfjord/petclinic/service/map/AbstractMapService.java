package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.BaseEntity;
import com.zrosfjord.petclinic.service.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity> implements CrudService<T> {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null!");
        }

        return object;
    }

    public void deleteById(Long id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        if (map.isEmpty()) {
            return 1L;
        } else {
            return Collections.max(map.keySet()) + 1;
        }
    }

}
