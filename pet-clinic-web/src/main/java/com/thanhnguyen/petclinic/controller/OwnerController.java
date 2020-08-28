package com.thanhnguyen.petclinic.controller;

import com.thanhnguyen.petclinic.dto.Owner;
import com.thanhnguyen.petclinic.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OwnerController {
    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public OwnerController(OwnerService ownerService, ModelMapper modelMapper) {
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/owners"
    )
    public ResponseEntity<List<Owner>> getAll() {
        var owners = ownerService.findAll();
        List<Owner> dtos = owners.stream().map(owner -> modelMapper.map(owner, Owner.class)).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
