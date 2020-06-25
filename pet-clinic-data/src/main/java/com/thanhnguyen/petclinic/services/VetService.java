package com.thanhnguyen.petclinic.services;

import com.thanhnguyen.petclinic.models.Owner;
import com.thanhnguyen.petclinic.models.Vet;

import java.util.Set;

public interface VetService {
    Owner findById(Long id);
    Owner save(Vet vet);
    Set<Vet> findAll();
}
