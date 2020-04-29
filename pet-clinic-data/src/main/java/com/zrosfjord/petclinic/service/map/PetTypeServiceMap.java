package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.PetType;
import com.zrosfjord.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map"})
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService {
}
