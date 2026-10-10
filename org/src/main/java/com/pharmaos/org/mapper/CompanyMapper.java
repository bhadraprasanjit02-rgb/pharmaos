package com.pharmaos.org.mapper;

import com.pharmaos.org.dto.CompanyRequest;
import com.pharmaos.org.dto.CompanyResponse;
import com.pharmaos.org.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company toEntity(CompanyRequest request) {

        Company company = new Company();

        company.setCompanyCode(request.getCompanyCode());
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

        return company;
    }

    public CompanyResponse toResponse(Company company) {

        CompanyResponse response = new CompanyResponse();

        response.setId(company.getId());
        response.setCompanyCode(company.getCompanyCode());
        response.setCompanyName(company.getCompanyName());
        response.setLegalName(company.getLegalName());
        response.setGstNumber(company.getGstNumber());
        response.setPanNumber(company.getPanNumber());
        response.setCinNumber(company.getCinNumber());
        response.setEmail(company.getEmail());
        response.setPhone(company.getPhone());
        response.setWebsite(company.getWebsite());
        response.setCountry(company.getCountry());
        response.setState(company.getState());
        response.setCity(company.getCity());
        response.setAddress(company.getAddress());
        response.setPostalCode(company.getPostalCode());
        response.setStatus(company.getStatus().name());

        return response;
    }
}