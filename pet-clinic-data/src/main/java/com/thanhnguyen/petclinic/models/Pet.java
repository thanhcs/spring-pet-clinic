package com.thanhnguyen.petclinic.models;

import java.time.Instant;

public class Pet extends BaseEntity {
    private PetType petTypes;
    private Owner owner;
    private Instant birthDate;
}
