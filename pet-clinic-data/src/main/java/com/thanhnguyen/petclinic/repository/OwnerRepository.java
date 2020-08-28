package com.thanhnguyen.petclinic.repository;

import com.thanhnguyen.petclinic.entity.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Set<Owner> findByLastName(String lastName);
}
