package com.zrosfjord.petclinic.service.jpa;

import com.zrosfjord.petclinic.model.PetType;
import com.zrosfjord.petclinic.repository.PetTypeRepository;
import com.zrosfjord.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Profile({"jpa", "default"})
@Transactional
public class PetTypeServiceJpa extends AbstractJpaService<PetType, PetTypeRepository> implements PetTypeService {

    public PetTypeServiceJpa(PetTypeRepository repository) {
        super(repository);
    }
}
