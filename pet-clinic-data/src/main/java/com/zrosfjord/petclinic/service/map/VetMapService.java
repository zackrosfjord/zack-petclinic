package com.zrosfjord.petclinic.service.map;

import com.zrosfjord.petclinic.model.Specialty;
import com.zrosfjord.petclinic.model.Vet;
import com.zrosfjord.petclinic.service.SpecialtyService;
import com.zrosfjord.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
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

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
