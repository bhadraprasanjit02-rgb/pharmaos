package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.RegionRequest;
import com.pharmaos.org.dto.RegionResponse;
import com.pharmaos.org.entity.Division;
import com.pharmaos.org.entity.Region;
import com.pharmaos.org.mapper.RegionMapper;
import com.pharmaos.org.repository.DivisionRepository;
import com.pharmaos.org.repository.RegionRepository;
import com.pharmaos.org.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final DivisionRepository divisionRepository;
    private final RegionMapper regionMapper;

    @Override
    public RegionResponse create(RegionRequest request) {

        Division division = divisionRepository.findById(request.getDivisionId())
                .orElseThrow(() -> new RuntimeException("Division not found."));

        if (regionRepository.existsByDivisionAndRegionCode(
                division, request.getRegionCode())) {
            throw new RuntimeException("Region Code already exists.");
        }

        if (regionRepository.existsByDivisionAndRegionName(
                division, request.getRegionName())) {
            throw new RuntimeException("Region Name already exists.");
        }

        Region saved = regionRepository.save(
                regionMapper.toEntity(request, division));

        return regionMapper.toResponse(saved);
    }

    @Override
    public RegionResponse update(UUID id, RegionRequest request) {

        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Region not found."));

        Division division = divisionRepository.findById(request.getDivisionId())
                .orElseThrow(() -> new RuntimeException("Division not found."));

        region.setRegionCode(request.getRegionCode());
        region.setRegionName(request.getRegionName());
        region.setDescription(request.getDescription());
        region.setDivision(division);

        return regionMapper.toResponse(regionRepository.save(region));
    }

    @Override
    @Transactional(readOnly = true)
    public RegionResponse getById(UUID id) {

        return regionMapper.toResponse(
                regionRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Region not found."))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegionResponse> getAll() {

        return regionRepository.findAll()
                .stream()
                .map(regionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegionResponse> getByDivision(UUID divisionId) {

        return regionRepository.findByDivisionId(divisionId)
                .stream()
                .map(regionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {

        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Region not found."));

        regionRepository.delete(region);
    }
}