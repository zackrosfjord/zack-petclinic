package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.Specialty;
import com.zrosfjord.petclinic.model.Vet;
import com.zrosfjord.petclinic.service.SpecialtyService;
import com.zrosfjord.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map"})
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            if (object.getSpecialties().size() > 0) {
                object.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null) {
                        Specialty savedSpeciality = specialtyService.save(specialty);
                        specialty.setId(savedSpeciality.getId());
                    }
                });
            }

            return super.save(object);
        } else {
            throw new RuntimeException("Object cannot be null!");
        }

    }

}
