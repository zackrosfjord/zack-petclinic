package com.zrosfjord.petclinic.service.jpa;

import com.zrosfjord.petclinic.model.Owner;
import com.zrosfjord.petclinic.repository.OwnerRepository;
import com.zrosfjord.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Profile({"jpa", "default"})
@Transactional
public class OwnerServiceJpa extends AbstractJpaService<Owner, OwnerRepository> implements OwnerService {

    public OwnerServiceJpa(OwnerRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

}
