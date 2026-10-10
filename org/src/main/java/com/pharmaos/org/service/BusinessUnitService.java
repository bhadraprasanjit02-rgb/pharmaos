package com.pharmaos.org.service;

import com.pharmaos.org.dto.BusinessUnitRequest;
import com.pharmaos.org.dto.BusinessUnitResponse;

import java.util.List;
import java.util.UUID;

public interface BusinessUnitService {

    BusinessUnitResponse create(BusinessUnitRequest request);

    BusinessUnitResponse getById(UUID id);

    List<BusinessUnitResponse> getAll();

    List<BusinessUnitResponse> getByCompany(UUID companyId);

    BusinessUnitResponse update(UUID id, BusinessUnitRequest request);

    void delete(UUID id);
}