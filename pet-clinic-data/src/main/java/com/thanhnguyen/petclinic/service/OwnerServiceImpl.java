package com.thanhnguyen.petclinic.service;

import com.thanhnguyen.petclinic.domain.Owner;
import com.thanhnguyen.petclinic.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        var ownerEntities = ownerRepository.findByLastName(lastName);
        return ownerEntities.stream().map(owner -> modelMapper.map(owner, Owner.class)).collect(Collectors.toSet());
    }

    @Override
    public Owner findById(Long id) {
        var ownerEntity = ownerRepository.findById(id);
        return modelMapper.map(ownerEntity, Owner.class);
    }

    @Override
    public Owner save(Owner owner) {
        var ownerEntity = ownerRepository.save(modelMapper.map(owner, com.thanhnguyen.petclinic.entity.Owner.class));
        return modelMapper.map(ownerEntity, Owner.class);
    }

    @Override
    public List<Owner> findAll() {
        List<Owner> owners = new ArrayList<>();
        var ownerEntities = ownerRepository.findAll();
        ownerEntities.forEach(owner -> owners.add(modelMapper.map(owner, Owner.class)));
        return owners;
    }

    @Override
    public void delete(Owner owner) {
        var ownerEntity = modelMapper.map(owner, com.thanhnguyen.petclinic.entity.Owner.class);
        ownerRepository.delete(ownerEntity);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
