package com.zrosfjord.petclinic.services.map;

import com.zrosfjord.petclinic.models.Owner;
import com.zrosfjord.petclinic.models.Pet;
import com.zrosfjord.petclinic.services.OwnerService;
import com.zrosfjord.petclinic.services.PetService;
import com.zrosfjord.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
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

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

}
