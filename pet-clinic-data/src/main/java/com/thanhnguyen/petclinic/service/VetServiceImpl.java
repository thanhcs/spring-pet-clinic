package com.thanhnguyen.petclinic.service;

import com.thanhnguyen.petclinic.domain.Vet;
import com.thanhnguyen.petclinic.repository.VetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VetServiceImpl implements VetService {
    private final VetRepository vetRepository;
    private final ModelMapper modelMapper;

    public VetServiceImpl(VetRepository vetRepository, ModelMapper modelMapper) {
        this.vetRepository = vetRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Vet findById(Long id) {
        var vetEntity = vetRepository.findById(id);
        return modelMapper.map(vetEntity, Vet.class);
    }

    @Override
    public Vet save(Vet vet) {
        var vetEntity  = modelMapper.map(vet, com.thanhnguyen.petclinic.entity.Vet.class);
        var savedEntity = vetRepository.save(vetEntity);
        return modelMapper.map(savedEntity, Vet.class);
    }

    @Override
    public List<Vet> findAll() {
        List<Vet> vets = new ArrayList<>();
        var vetEntities = vetRepository.findAll();
        vetEntities.forEach(entity -> vets.add(modelMapper.map(entity, Vet.class)));
        return vets;
    }

    @Override
    public void delete(Vet vet) {
        var vetEntity = modelMapper.map(vet, com.thanhnguyen.petclinic.entity.Vet.class);
        vetRepository.delete(vetEntity);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
