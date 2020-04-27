package com.zrosfjord.petclinic.bootstrap;

import com.zrosfjord.petclinic.models.Owner;
import com.zrosfjord.petclinic.models.Pet;
import com.zrosfjord.petclinic.models.PetType;
import com.zrosfjord.petclinic.models.Vet;
import com.zrosfjord.petclinic.services.OwnerService;
import com.zrosfjord.petclinic.services.PetTypeService;
import com.zrosfjord.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType ferret = new PetType();
        ferret.setName("Ferret");
        PetType savedFerretPetType = petTypeService.save(ferret);

        System.out.println("Loaded PetTypes....");

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

        System.out.println("Loaded Owners.....");

        Vet tonyStark = new Vet();
        tonyStark.setFirstName("Tony");
        tonyStark.setLastName("Stark");

        vetService.save(tonyStark);

        Vet tara = new Vet();
        tara.setFirstName("Tara");
        tara.setLastName("Damscus");

        vetService.save(tara);

        System.out.println("Loaded Vets.......");
    }

}
