package com.pharmaos.org.service;

import com.pharmaos.org.dto.TerritoryRequest;
import com.pharmaos.org.dto.TerritoryResponse;

import java.util.List;
import java.util.UUID;

public interface TerritoryService {

    TerritoryResponse create(TerritoryRequest request);

    TerritoryResponse update(UUID id, TerritoryRequest request);

    TerritoryResponse getById(UUID id);

    List<TerritoryResponse> getAll();

    List<TerritoryResponse> getByRegion(UUID regionId);

    void delete(UUID id);
}