package com.zrosfjord.petclinic.bootstrap;

import com.zrosfjord.petclinic.models.Owner;
import com.zrosfjord.petclinic.models.Vet;
import com.zrosfjord.petclinic.services.OwnerService;
import com.zrosfjord.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner zack = new Owner();
        zack.setId(1L);
        zack.setFirstName("Zack");
        zack.setLastName("Rosfjord");

        ownerService.save(zack);

        Owner clark = new Owner();
        clark.setId(2L);
        clark.setFirstName("Clark");
        clark.setLastName("Matthews");

        ownerService.save(clark);

        System.out.println("Loaded Owners.....");

        Vet tonyStark = new Vet();
        tonyStark.setId(1L);
        tonyStark.setFirstName("Tony");
        tonyStark.setLastName("Stark");

        vetService.save(tonyStark);

        Vet tara = new Vet();
        tara.setId(2L);
        tara.setFirstName("Tara");
        tara.setLastName("Damscus");

        vetService.save(tara);

        System.out.println("Loaded Vets.......");
    }

}
