package com.pharmaos.org.service;

import com.pharmaos.org.dto.DivisionRequest;
import com.pharmaos.org.dto.DivisionResponse;

import java.util.List;
import java.util.UUID;

public interface DivisionService {

    DivisionResponse create(DivisionRequest request);

    DivisionResponse update(UUID id, DivisionRequest request);

    DivisionResponse getById(UUID id);

    List<DivisionResponse> getAll();

    List<DivisionResponse> getByBusinessUnit(UUID businessUnitId);

    void delete(UUID id);
}