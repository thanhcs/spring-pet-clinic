package com.thanhnguyen.petclinic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "type")
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;
}
