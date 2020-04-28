package com.zrosfjord.petclinic.repository;

import com.zrosfjord.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
