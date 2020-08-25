package com.thanhnguyen.petclinic.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vet {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Specialty> specialties = new ArrayList<>();
}
