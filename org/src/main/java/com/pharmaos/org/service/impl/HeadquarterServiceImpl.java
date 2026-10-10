package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.HeadquarterRequest;
import com.pharmaos.org.dto.HeadquarterResponse;
import com.pharmaos.org.entity.Headquarter;
import com.pharmaos.org.entity.Territory;
import com.pharmaos.org.mapper.HeadquarterMapper;
import com.pharmaos.org.repository.HeadquarterRepository;
import com.pharmaos.org.repository.TerritoryRepository;
import com.pharmaos.org.service.HeadquarterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HeadquarterServiceImpl implements HeadquarterService {

    private final HeadquarterRepository headquarterRepository;
    private final TerritoryRepository territoryRepository;
    private final HeadquarterMapper headquarterMapper;

    @Override
    public HeadquarterResponse create(HeadquarterRequest request) {

        Territory territory = territoryRepository.findById(request.getTerritoryId())
                .orElseThrow(() -> new RuntimeException("Territory not found."));

        if (headquarterRepository.existsByTerritoryAndHqCode(
                territory,
                request.getHqCode())) {
            throw new RuntimeException("HQ Code already exists.");
        }

        if (headquarterRepository.existsByTerritoryAndHqName(
                territory,
                request.getHqName())) {
            throw new RuntimeException("HQ Name already exists.");
        }

        Headquarter hq =
                headquarterMapper.toEntity(request, territory);

        return headquarterMapper.toResponse(
                headquarterRepository.save(hq)
        );
    }

    @Override
    public HeadquarterResponse update(UUID id,
                                      HeadquarterRequest request) {

        Headquarter hq = headquarterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Headquarter not found."));

        Territory territory = territoryRepository.findById(request.getTerritoryId())
                .orElseThrow(() ->
                        new RuntimeException("Territory not found."));

        hq.setHqCode(request.getHqCode());
        hq.setHqName(request.getHqName());
        hq.setTerritory(territory);
        hq.setState(request.getState());
        hq.setDistrict(request.getDistrict());
        hq.setCity(request.getCity());
        hq.setPincode(request.getPincode());
        hq.setDescription(request.getDescription());

        return headquarterMapper.toResponse(
                headquarterRepository.save(hq)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public HeadquarterResponse getById(UUID id) {

        return headquarterMapper.toResponse(
                headquarterRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Headquarter not found."))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<HeadquarterResponse> getAll() {

        return headquarterRepository.findAll()
                .stream()
                .map(headquarterMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<HeadquarterResponse> getByTerritory(UUID territoryId) {

        return headquarterRepository.findByTerritoryId(territoryId)
                .stream()
                .map(headquarterMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {

        Headquarter hq = headquarterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Headquarter not found."));

        headquarterRepository.delete(hq);
    }
}