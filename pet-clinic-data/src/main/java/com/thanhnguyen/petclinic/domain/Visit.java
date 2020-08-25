package com.thanhnguyen.petclinic.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Visit {
    private Long id;
    private Instant date;
    private String description;
    private Pet pet;
}
