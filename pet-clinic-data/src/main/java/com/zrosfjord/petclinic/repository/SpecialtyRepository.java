package com.zrosfjord.petclinic.repository;

import com.zrosfjord.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
