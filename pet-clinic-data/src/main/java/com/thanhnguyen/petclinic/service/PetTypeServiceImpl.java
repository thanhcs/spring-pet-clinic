package com.thanhnguyen.petclinic.service;

import com.thanhnguyen.petclinic.domain.PetType;
import com.thanhnguyen.petclinic.repository.PetTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetTypeServiceImpl implements PetTypeService {
    private final PetTypeRepository petTypeRepository;
    private final ModelMapper modelMapper;

    public PetTypeServiceImpl(PetTypeRepository petTypeRepository, ModelMapper modelMapper) {
        this.petTypeRepository = petTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PetType findById(Long id) {
        var vetEntity = petTypeRepository.findById(id);
        return modelMapper.map(vetEntity, PetType.class);
    }

    @Override
    public PetType save(PetType petType) {
        var petTypeEntity  = modelMapper.map(petType, com.thanhnguyen.petclinic.entity.PetType.class);
        var savedEntity = petTypeRepository.save(petTypeEntity);
        return modelMapper.map(savedEntity, PetType.class);
    }

    @Override
    public List<PetType> findAll() {
        List<PetType> petTypes = new ArrayList<>();
        var petTypeEntities = petTypeRepository.findAll();
        petTypeEntities.forEach(entity -> petTypes.add(modelMapper.map(entity, PetType.class)));
        return petTypes;
    }

    @Override
    public void delete(PetType petType) {
        var vetEntity = modelMapper.map(petType, com.thanhnguyen.petclinic.entity.PetType.class);
        petTypeRepository.delete(vetEntity);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
