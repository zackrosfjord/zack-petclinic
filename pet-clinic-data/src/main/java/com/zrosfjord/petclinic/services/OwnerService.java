package com.zrosfjord.petclinic.services;

import com.zrosfjord.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
