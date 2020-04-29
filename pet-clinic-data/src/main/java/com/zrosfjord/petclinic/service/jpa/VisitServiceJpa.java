package com.zrosfjord.petclinic.service.jpa;

import com.zrosfjord.petclinic.model.Visit;
import com.zrosfjord.petclinic.repository.VisitRepository;
import com.zrosfjord.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Profile({"jpa", "default"})
@Transactional
public class VisitServiceJpa extends AbstractJpaService<Visit, VisitRepository> implements VisitService {
    public VisitServiceJpa(VisitRepository repository) {
        super(repository);
    }
}
