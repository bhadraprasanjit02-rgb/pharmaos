package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.BusinessUnitRequest;
import com.pharmaos.org.dto.BusinessUnitResponse;
import com.pharmaos.org.entity.BusinessUnit;
import com.pharmaos.org.entity.Company;
import com.pharmaos.org.repository.BusinessUnitRepository;
import com.pharmaos.org.repository.CompanyRepository;
import com.pharmaos.org.service.BusinessUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BusinessUnitServiceImpl implements BusinessUnitService {

    private final BusinessUnitRepository businessUnitRepository;
    private final CompanyRepository companyRepository;

    @Override
    public BusinessUnitResponse create(BusinessUnitRequest request) {

        if (businessUnitRepository.existsByBusinessUnitCode(request.getBusinessUnitCode())) {
            throw new RuntimeException("Business Unit Code already exists.");
        }

        if (businessUnitRepository.existsByBusinessUnitName(request.getBusinessUnitName())) {
            throw new RuntimeException("Business Unit Name already exists.");
        }

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found."));

        BusinessUnit businessUnit = new BusinessUnit();
        businessUnit.setBusinessUnitCode(request.getBusinessUnitCode());
        businessUnit.setBusinessUnitName(request.getBusinessUnitName());
        businessUnit.setDescription(request.getDescription());
        businessUnit.setCompany(company);

        BusinessUnit saved = businessUnitRepository.save(businessUnit);

        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public BusinessUnitResponse getById(UUID id) {

        BusinessUnit businessUnit = businessUnitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business Unit not found."));

        return mapToResponse(businessUnit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BusinessUnitResponse> getAll() {

        return businessUnitRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<BusinessUnitResponse> getByCompany(UUID companyId) {

        return businessUnitRepository.findByCompanyId(companyId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BusinessUnitResponse update(UUID id, BusinessUnitRequest request) {

        BusinessUnit businessUnit = businessUnitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business Unit not found."));

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found."));

        businessUnit.setBusinessUnitCode(request.getBusinessUnitCode());
        businessUnit.setBusinessUnitName(request.getBusinessUnitName());
        businessUnit.setDescription(request.getDescription());
        businessUnit.setCompany(company);

        BusinessUnit updated = businessUnitRepository.save(businessUnit);

        return mapToResponse(updated);
    }

    @Override
    public void delete(UUID id) {

        BusinessUnit businessUnit = businessUnitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business Unit not found."));

        businessUnitRepository.delete(businessUnit);
    }

    private BusinessUnitResponse mapToResponse(BusinessUnit businessUnit) {

        return new BusinessUnitResponse(
                businessUnit.getId(),
                businessUnit.getBusinessUnitCode(),
                businessUnit.getBusinessUnitName(),
                businessUnit.getDescription(),
                businessUnit.getCompany().getId(),
                businessUnit.getCompany().getCompanyName()
        );
    }
}