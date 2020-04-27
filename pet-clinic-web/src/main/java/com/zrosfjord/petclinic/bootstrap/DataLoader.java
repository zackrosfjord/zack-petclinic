package com.zrosfjord.petclinic.bootstrap;

import com.zrosfjord.petclinic.models.*;
import com.zrosfjord.petclinic.services.OwnerService;
import com.zrosfjord.petclinic.services.PetTypeService;
import com.zrosfjord.petclinic.services.SpecialtyService;
import com.zrosfjord.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType ferret = new PetType();
        ferret.setName("Ferret");
        PetType savedFerretPetType = petTypeService.save(ferret);

        System.out.println("Loaded PetTypes.....");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialties..");

        Owner zack = new Owner();
        zack.setFirstName("Zack");
        zack.setLastName("Rosfjord");
        zack.setAddress("1 Main St.");
        zack.setCity("Allentown");
        zack.setTelephone("+1(202) 555-5643");

        Pet zacksPet = new Pet();
        zacksPet.setType(savedFerretPetType);
        zacksPet.setName("Percival");
        zacksPet.setBirthDate(LocalDate.now());
        zacksPet.setOwner(zack);

        zack.getPets().add(zacksPet);

        ownerService.save(zack);

        Owner clark = new Owner();
        clark.setFirstName("Clark");
        clark.setLastName("Matthews");
        clark.setAddress("6 Main St.");
        clark.setCity("Miami");
        clark.setTelephone("+1(856) 555-5643");

        Pet clarksPet = new Pet();
        clarksPet.setOwner(clark);
        clarksPet.setName("Snowball");
        clarksPet.setType(savedDogPetType);
        clarksPet.setBirthDate(LocalDate.now());

        clark.getPets().add(clarksPet);

        ownerService.save(clark);

        System.out.println("Loaded Owners.......");

        Vet tonyStark = new Vet();
        tonyStark.setFirstName("Tony");
        tonyStark.setLastName("Stark");
        tonyStark.getSpecialties().add(savedRadiology);

        vetService.save(tonyStark);

        Vet tara = new Vet();
        tara.setFirstName("Tara");
        tara.setLastName("Damscus");
        tara.getSpecialties().add(savedSurgery);

        vetService.save(tara);

        System.out.println("Loaded Vets.........");
    }

}
