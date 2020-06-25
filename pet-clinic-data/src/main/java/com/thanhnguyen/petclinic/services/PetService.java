package com.thanhnguyen.petclinic.services;

import com.thanhnguyen.petclinic.models.Owner;
import com.thanhnguyen.petclinic.models.Pet;

import java.util.Set;

public interface PetService {
    Owner findById(Long id);
    Owner save(Pet pet);
    Set<Pet> findAll();
}
