package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.Vet;
import com.zrosfjord.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map"})
public class VisitServiceMap extends AbstractMapService<Vet> implements VetService {
}
