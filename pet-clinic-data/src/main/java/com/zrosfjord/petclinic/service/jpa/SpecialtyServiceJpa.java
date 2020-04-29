package com.zrosfjord.petclinic.service.jpa;

import com.zrosfjord.petclinic.model.Specialty;
import com.zrosfjord.petclinic.repository.SpecialtyRepository;
import com.zrosfjord.petclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"jpa", "default"})
public class SpecialtyServiceJpa extends AbstractJpaService<Specialty, SpecialtyRepository> implements SpecialtyService {

    public SpecialtyServiceJpa(SpecialtyRepository repository) {
        super(repository);
    }
}
