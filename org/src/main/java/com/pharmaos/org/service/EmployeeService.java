package com.pharmaos.org.service;

import com.pharmaos.org.dto.EmployeeRequest;
import com.pharmaos.org.dto.EmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest request);

    EmployeeResponse update(UUID id, EmployeeRequest request);

    EmployeeResponse getById(UUID id);

    List<EmployeeResponse> getAll();

    List<EmployeeResponse> getByHeadquarter(UUID headquarterId);

    List<EmployeeResponse> getByReportingManager(UUID managerId);

    void delete(UUID id);
}