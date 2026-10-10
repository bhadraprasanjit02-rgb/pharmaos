package com.pharmaos.org.service;

import com.pharmaos.org.dto.DepartmentRequest;
import com.pharmaos.org.dto.DepartmentResponse;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    DepartmentResponse create(DepartmentRequest request);

    DepartmentResponse update(UUID id, DepartmentRequest request);

    DepartmentResponse getById(UUID id);

    List<DepartmentResponse> getAll();

    void delete(UUID id);
}