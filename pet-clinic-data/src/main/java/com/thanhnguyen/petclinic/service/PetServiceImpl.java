package com.thanhnguyen.petclinic.service;

import com.thanhnguyen.petclinic.domain.Pet;
import com.thanhnguyen.petclinic.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final ModelMapper modelMapper;

    public PetServiceImpl(PetRepository petRepository, ModelMapper modelMapper) {
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Pet findById(Long id) {
        var petEntity = petRepository.findById(id);
        return modelMapper.map(petEntity, Pet.class);
    }

    @Override
    public Pet save(Pet pet) {
        var petEntity = modelMapper.map(pet, com.thanhnguyen.petclinic.entity.Pet.class);
        var savedPetEntity = petRepository.save(petEntity);
        return modelMapper.map(savedPetEntity, Pet.class);
    }

    @Override
    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        var petEntities = petRepository.findAll();
        petEntities.forEach(entity -> pets.add(modelMapper.map(entity, Pet.class)));
        return pets;
    }

    @Override
    public void delete(Pet pet) {
        var petEntity = modelMapper.map(pet, com.thanhnguyen.petclinic.entity.Pet.class);
        petRepository.delete(petEntity);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
