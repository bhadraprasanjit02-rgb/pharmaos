package com.pharmaos.org.service;

import com.pharmaos.org.dto.HeadquarterRequest;
import com.pharmaos.org.dto.HeadquarterResponse;

import java.util.List;
import java.util.UUID;

public interface HeadquarterService {

    HeadquarterResponse create(HeadquarterRequest request);

    HeadquarterResponse update(UUID id, HeadquarterRequest request);

    HeadquarterResponse getById(UUID id);

    List<HeadquarterResponse> getAll();

    List<HeadquarterResponse> getByTerritory(UUID territoryId);

    void delete(UUID id);
}