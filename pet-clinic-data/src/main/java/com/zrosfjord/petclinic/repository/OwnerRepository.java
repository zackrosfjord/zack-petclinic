package com.zrosfjord.petclinic.repository;

import com.zrosfjord.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
