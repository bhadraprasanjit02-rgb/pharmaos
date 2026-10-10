package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.DivisionRequest;
import com.pharmaos.org.dto.DivisionResponse;
import com.pharmaos.org.entity.BusinessUnit;
import com.pharmaos.org.entity.Division;
import com.pharmaos.org.mapper.DivisionMapper;
import com.pharmaos.org.repository.BusinessUnitRepository;
import com.pharmaos.org.repository.DivisionRepository;
import com.pharmaos.org.service.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;
    private final BusinessUnitRepository businessUnitRepository;
    private final DivisionMapper divisionMapper;

    @Override
    public DivisionResponse create(DivisionRequest request) {

        BusinessUnit businessUnit = businessUnitRepository.findById(request.getBusinessUnitId())
                .orElseThrow(() ->
                        new RuntimeException("Business Unit not found."));

        if (divisionRepository.existsByBusinessUnitAndDivisionCode(
                businessUnit,
                request.getDivisionCode())) {

            throw new RuntimeException("Division Code already exists.");
        }

        if (divisionRepository.existsByBusinessUnitAndDivisionName(
                businessUnit,
                request.getDivisionName())) {

            throw new RuntimeException("Division Name already exists.");
        }

        Division division =
                divisionMapper.toEntity(request, businessUnit);

        Division savedDivision =
                divisionRepository.save(division);

        return divisionMapper.toResponse(savedDivision);
    }

    @Override
    public DivisionResponse update(UUID id, DivisionRequest request) {

        Division division = divisionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Division not found."));

        BusinessUnit businessUnit = businessUnitRepository.findById(request.getBusinessUnitId())
                .orElseThrow(() ->
                        new RuntimeException("Business Unit not found."));

        division.setDivisionCode(request.getDivisionCode());
        division.setDivisionName(request.getDivisionName());
        division.setDescription(request.getDescription());
        division.setBusinessUnit(businessUnit);

        Division updatedDivision = divisionRepository.save(division);

        return divisionMapper.toResponse(updatedDivision);
    }

    @Override
    public DivisionResponse getById(UUID id) {

        Division division = divisionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Division not found."));

        return divisionMapper.toResponse(division);
    }

    @Override
    public List<DivisionResponse> getAll() {

        return divisionRepository.findAll()
                .stream()
                .map(divisionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<DivisionResponse> getByBusinessUnit(UUID businessUnitId) {

        return divisionRepository.findByBusinessUnitId(businessUnitId)
                .stream()
                .map(divisionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {

        Division division = divisionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Division not found."));

        divisionRepository.delete(division);
    }
}