package com.zrosfjord.petclinic.service;

import com.zrosfjord.petclinic.model.Owner;

import java.util.Optional;

public interface OwnerService extends CrudService<Owner> {

    Optional<Owner> findByLastName(String lastName);

}
