package com.pharmaos.org.mapper;

import com.pharmaos.org.dto.RegionRequest;
import com.pharmaos.org.dto.RegionResponse;
import com.pharmaos.org.entity.Division;
import com.pharmaos.org.entity.Region;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {

    public Region toEntity(RegionRequest request, Division division) {

        Region region = new Region();

        region.setRegionCode(request.getRegionCode());
        region.setRegionName(request.getRegionName());
        region.setDescription(request.getDescription());
        region.setDivision(division);

        return region;
    }

    public RegionResponse toResponse(Region region) {

        RegionResponse response = new RegionResponse();

        response.setId(region.getId());
        response.setRegionCode(region.getRegionCode());
        response.setRegionName(region.getRegionName());

        response.setDivisionId(region.getDivision().getId());
        response.setDivisionCode(region.getDivision().getDivisionCode());
        response.setDivisionName(region.getDivision().getDivisionName());

        response.setDescription(region.getDescription());
        response.setStatus(region.getStatus().name());

        return response;
    }
}