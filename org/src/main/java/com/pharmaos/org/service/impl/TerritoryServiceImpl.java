package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.TerritoryRequest;
import com.pharmaos.org.dto.TerritoryResponse;
import com.pharmaos.org.entity.Region;
import com.pharmaos.org.entity.Territory;
import com.pharmaos.org.mapper.TerritoryMapper;
import com.pharmaos.org.repository.RegionRepository;
import com.pharmaos.org.repository.TerritoryRepository;
import com.pharmaos.org.service.TerritoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TerritoryServiceImpl implements TerritoryService {

    private final TerritoryRepository territoryRepository;
    private final RegionRepository regionRepository;
    private final TerritoryMapper territoryMapper;

    @Override
    public TerritoryResponse create(TerritoryRequest request) {

        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RuntimeException("Region not found."));

        if (territoryRepository.existsByRegionAndTerritoryCode(region, request.getTerritoryCode())) {
            throw new RuntimeException("Territory Code already exists.");
        }

        if (territoryRepository.existsByRegionAndTerritoryName(region, request.getTerritoryName())) {
            throw new RuntimeException("Territory Name already exists.");
        }

        Territory territory = territoryMapper.toEntity(request, region);

        return territoryMapper.toResponse(
                territoryRepository.save(territory)
        );
    }

    @Override
    public TerritoryResponse update(UUID id, TerritoryRequest request) {

        Territory territory = territoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Territory not found."));

        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RuntimeException("Region not found."));

        territory.setTerritoryCode(request.getTerritoryCode());
        territory.setTerritoryName(request.getTerritoryName());
        territory.setDescription(request.getDescription());
        territory.setRegion(region);

        return territoryMapper.toResponse(
                territoryRepository.save(territory)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public TerritoryResponse getById(UUID id) {

        return territoryMapper.toResponse(
                territoryRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Territory not found."))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<TerritoryResponse> getAll() {

        return territoryRepository.findAll()
                .stream()
                .map(territoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TerritoryResponse> getByRegion(UUID regionId) {

        return territoryRepository.findByRegionId(regionId)
                .stream()
                .map(territoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {

        Territory territory = territoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Territory not found."));

        territoryRepository.delete(territory);
    }
}