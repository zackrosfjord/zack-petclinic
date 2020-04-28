package com.zrosfjord.petclinic.repository;

import com.zrosfjord.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
