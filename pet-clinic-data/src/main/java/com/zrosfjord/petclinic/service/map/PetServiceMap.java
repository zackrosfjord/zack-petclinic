package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.Pet;
import com.zrosfjord.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map"})
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {
}
