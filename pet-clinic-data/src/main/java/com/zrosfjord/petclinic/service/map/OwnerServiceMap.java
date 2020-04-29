package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.Owner;
import com.zrosfjord.petclinic.model.Pet;
import com.zrosfjord.petclinic.service.OwnerService;
import com.zrosfjord.petclinic.service.PetService;
import com.zrosfjord.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile({"map"})
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getType() != null) {
                        pet.setType(petTypeService.save(pet.getType()));
                    } else {
                        throw new RuntimeException("Pet Type is required!");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);
        } else {
            throw new RuntimeException("Object cannot be null!");
        }

    }

}
