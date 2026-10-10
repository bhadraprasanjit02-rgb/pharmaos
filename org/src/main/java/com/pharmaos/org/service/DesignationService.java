package com.pharmaos.org.service;

import com.pharmaos.org.dto.DesignationRequest;
import com.pharmaos.org.dto.DesignationResponse;

import java.util.List;
import java.util.UUID;

public interface DesignationService {

    DesignationResponse create(DesignationRequest request);

    DesignationResponse update(UUID id,
                               DesignationRequest request);

    DesignationResponse getById(UUID id);

    List<DesignationResponse> getAll();

    void delete(UUID id);

}