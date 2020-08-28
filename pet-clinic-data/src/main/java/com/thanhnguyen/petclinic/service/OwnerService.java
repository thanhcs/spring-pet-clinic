package com.thanhnguyen.petclinic.service;


import com.thanhnguyen.petclinic.domain.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Set<Owner> findByLastName(String lastName);
}
