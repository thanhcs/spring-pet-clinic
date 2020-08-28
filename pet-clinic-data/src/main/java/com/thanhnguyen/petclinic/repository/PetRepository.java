package com.thanhnguyen.petclinic.repository;

import com.thanhnguyen.petclinic.entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
