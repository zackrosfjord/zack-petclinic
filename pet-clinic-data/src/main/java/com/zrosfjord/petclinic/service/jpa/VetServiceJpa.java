package com.zrosfjord.petclinic.service.jpa;

import com.zrosfjord.petclinic.model.Vet;
import com.zrosfjord.petclinic.repository.VetRepository;
import com.zrosfjord.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"jpa", "default"})
public class VetServiceJpa extends AbstractJpaService<Vet, VetRepository> implements VetService {
    protected VetServiceJpa(VetRepository repository) {
        super(repository);
    }
}
