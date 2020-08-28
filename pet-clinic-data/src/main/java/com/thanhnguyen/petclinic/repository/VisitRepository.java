package com.thanhnguyen.petclinic.repository;

import com.thanhnguyen.petclinic.entity.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
