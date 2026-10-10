package com.pharmaos.org.mapper;

import com.pharmaos.org.dto.DivisionRequest;
import com.pharmaos.org.dto.DivisionResponse;
import com.pharmaos.org.entity.BusinessUnit;
import com.pharmaos.org.entity.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    public Division toEntity(DivisionRequest request, BusinessUnit businessUnit) {

        Division division = new Division();

        division.setDivisionCode(request.getDivisionCode());
        division.setDivisionName(request.getDivisionName());
        division.setDescription(request.getDescription());
        division.setBusinessUnit(businessUnit);

        return division;
    }

    public DivisionResponse toResponse(Division division) {

        DivisionResponse response = new DivisionResponse();

        response.setId(division.getId());
        response.setDivisionCode(division.getDivisionCode());
        response.setDivisionName(division.getDivisionName());

        response.setBusinessUnitId(division.getBusinessUnit().getId());
        response.setBusinessUnitCode(division.getBusinessUnit().getBusinessUnitCode());
        response.setBusinessUnitName(division.getBusinessUnit().getBusinessUnitName());

        response.setDescription(division.getDescription());
        response.setStatus(division.getStatus().name());

        return response;
    }
}