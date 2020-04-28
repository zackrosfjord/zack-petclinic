package com.zrosfjord.petclinic.service;

import com.zrosfjord.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
