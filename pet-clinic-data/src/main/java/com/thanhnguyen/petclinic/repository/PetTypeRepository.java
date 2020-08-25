package com.thanhnguyen.petclinic.repository;

import com.thanhnguyen.petclinic.entity.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
