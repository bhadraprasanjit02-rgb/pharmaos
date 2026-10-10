package com.pharmaos.org.service;

import com.pharmaos.org.dto.CompanyRequest;
import com.pharmaos.org.dto.CompanyResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyService {

    CompanyResponse create(CompanyRequest request);

    CompanyResponse update(UUID id, CompanyRequest request);

    CompanyResponse getById(UUID id);

    List<CompanyResponse> getAll();

    void delete(UUID id);
}