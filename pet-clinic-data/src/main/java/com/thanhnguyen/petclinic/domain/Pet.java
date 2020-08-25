package com.thanhnguyen.petclinic.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Pet {
    private Long id;
    private String name;
    private PetType petType;
    private Instant birthDate;
    private Owner owner;
}
