package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.Specialty;
import com.zrosfjord.petclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map"})
public class SpecialtyServiceMap extends AbstractMapService<Specialty> implements SpecialtyService {
}
