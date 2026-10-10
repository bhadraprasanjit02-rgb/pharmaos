package com.pharmaos.org.service;

import com.pharmaos.org.dto.RegionRequest;
import com.pharmaos.org.dto.RegionResponse;

import java.util.List;
import java.util.UUID;

public interface RegionService {

    RegionResponse create(RegionRequest request);

    RegionResponse update(UUID id, RegionRequest request);

    RegionResponse getById(UUID id);

    List<RegionResponse> getAll();

    List<RegionResponse> getByDivision(UUID divisionId);

    void delete(UUID id);
}