package com.thanhnguyen.petclinic.repository;

import com.thanhnguyen.petclinic.entity.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
