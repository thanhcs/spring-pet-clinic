package com.thanhnguyen.petclinic.service;

import com.thanhnguyen.petclinic.domain.Visit;
import com.thanhnguyen.petclinic.repository.VisitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    private final VisitRepository visitRepository;
    private final ModelMapper modelMapper;

    public VisitServiceImpl(VisitRepository visitRepository, ModelMapper modelMapper) {
        this.visitRepository = visitRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Visit findById(Long id) {
        var visitEntity = visitRepository.findById(id);
        return modelMapper.map(visitEntity, Visit.class);
    }

    @Override
    public Visit save(Visit visit) {
        var visitEntity  = modelMapper.map(visit, com.thanhnguyen.petclinic.entity.Visit.class);
        var savedEntity = visitRepository.save(visitEntity);
        return modelMapper.map(savedEntity, Visit.class);
    }

    @Override
    public List<Visit> findAll() {
        List<Visit> visits = new ArrayList<>();
        var visitEntities = visitRepository.findAll();
        visitEntities.forEach(entity -> visits.add(modelMapper.map(entity, Visit.class)));
        return visits;
    }

    @Override
    public void delete(Visit visit) {
        var visitEntity = modelMapper.map(visit, com.thanhnguyen.petclinic.entity.Visit.class);
        visitRepository.delete(visitEntity);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
