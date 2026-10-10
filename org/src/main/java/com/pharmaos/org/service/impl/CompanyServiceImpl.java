package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.CompanyRequest;
import com.pharmaos.org.dto.CompanyResponse;
import com.pharmaos.org.entity.Company;
import com.pharmaos.org.mapper.CompanyMapper;
import com.pharmaos.org.repository.CompanyRepository;
import com.pharmaos.org.service.CompanyService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponse create(CompanyRequest request) {

        if (companyRepository.existsByCompanyCode(request.getCompanyCode())) {
            throw new RuntimeException("Company Code already exists.");
        }

        if (companyRepository.existsByCompanyName(request.getCompanyName())) {
            throw new RuntimeException("Company Name already exists.");
        }

        if (request.getGstNumber() != null &&
                companyRepository.existsByGstNumber(request.getGstNumber())) {
            throw new RuntimeException("GST Number already exists.");
        }

        if (request.getPanNumber() != null &&
                companyRepository.existsByPanNumber(request.getPanNumber())) {
            throw new RuntimeException("PAN Number already exists.");
        }

        if (request.getCinNumber() != null &&
                companyRepository.existsByCinNumber(request.getCinNumber())) {
            throw new RuntimeException("CIN Number already exists.");
        }

        Company company = companyMapper.toEntity(request);

        Company savedCompany = companyRepository.save(company);

        return companyMapper.toResponse(savedCompany);
    }

    @Override
    public CompanyResponse update(UUID id, CompanyRequest request) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Company not found."));

        company.setCompanyName(request.getCompanyName());
        company.setLegalName(request.getLegalName());
        company.setGstNumber(request.getGstNumber());
        company.setPanNumber(request.getPanNumber());
        company.setCinNumber(request.getCinNumber());
        company.setEmail(request.getEmail());
        company.setPhone(request.getPhone());
        company.setWebsite(request.getWebsite());
        company.setCountry(request.getCountry());
        company.setState(request.getState());
        company.setCity(request.getCity());
        company.setAddress(request.getAddress());
        company.setPostalCode(request.getPostalCode());

        Company updatedCompany = companyRepository.save(company);

        return companyMapper.toResponse(updatedCompany);
    }

    @Override
    public CompanyResponse getById(UUID id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Company not found."));

        return companyMapper.toResponse(company);
    }

    @Override
    public List<CompanyResponse> getAll() {

   return companyRepository.findAll()
        .stream()
        .map(companyMapper::toResponse)
        .toList();
    }

    @Override
    public void delete(UUID id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Company not found."));

        companyRepository.delete(company);
    }
}