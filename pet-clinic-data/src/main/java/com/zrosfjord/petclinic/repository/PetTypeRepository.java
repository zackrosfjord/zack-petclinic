package com.zrosfjord.petclinic.repository;

import com.zrosfjord.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
