package com.zrosfjord.petclinic.service.jpa;

import com.zrosfjord.petclinic.model.Pet;
import com.zrosfjord.petclinic.repository.PetRepository;
import com.zrosfjord.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Profile({"jpa", "default"})
@Transactional
public class PetServiceJpa extends AbstractJpaService<Pet, PetRepository> implements PetService {

    public PetServiceJpa(PetRepository repository) {
        super(repository);
    }

}
