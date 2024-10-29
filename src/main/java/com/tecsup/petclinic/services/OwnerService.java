package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;

public interface OwnerService {

    Owner create(Owner owner);
    Owner update(Owner owner);
    Owner findById(Integer id);
    void delete(Integer id);

}
