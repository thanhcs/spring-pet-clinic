package com.thanhnguyen.petclinic.service;

import com.thanhnguyen.petclinic.domain.Specialty;
import com.thanhnguyen.petclinic.repository.SpecialtyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;
    private final ModelMapper modelMapper;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository, ModelMapper modelMapper) {
        this.specialtyRepository = specialtyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Specialty findById(Long id) {
        var specialtyEntity = specialtyRepository.findById(id);
        return modelMapper.map(specialtyEntity, Specialty.class);
    }

    @Override
    public Specialty save(Specialty specialty) {
        var specialtyEntity  = modelMapper.map(specialty, com.thanhnguyen.petclinic.entity.Specialty.class);
        var savedEntity = specialtyRepository.save(specialtyEntity);
        return modelMapper.map(savedEntity, Specialty.class);
    }

    @Override
    public List<Specialty> findAll() {
        List<Specialty> specialties = new ArrayList<>();
        var specialtyEntities = specialtyRepository.findAll();
        specialtyEntities.forEach(entity -> specialties.add(modelMapper.map(entity, Specialty.class)));
        return specialties;
    }

    @Override
    public void delete(Specialty specialty) {
        var specialTyEntity = modelMapper.map(specialty, com.thanhnguyen.petclinic.entity.Specialty.class);
        specialtyRepository.delete(specialTyEntity);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
