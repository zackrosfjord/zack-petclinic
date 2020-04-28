package com.zrosfjord.petclinic.repository;

import com.zrosfjord.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
