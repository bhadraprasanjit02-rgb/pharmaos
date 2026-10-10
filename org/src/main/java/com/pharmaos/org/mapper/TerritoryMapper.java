package com.pharmaos.org.mapper;

import com.pharmaos.org.dto.TerritoryRequest;
import com.pharmaos.org.dto.TerritoryResponse;
import com.pharmaos.org.entity.Region;
import com.pharmaos.org.entity.Territory;
import org.springframework.stereotype.Component;

@Component
public class TerritoryMapper {

    public Territory toEntity(TerritoryRequest request, Region region) {

        Territory territory = new Territory();

        territory.setTerritoryCode(request.getTerritoryCode());
        territory.setTerritoryName(request.getTerritoryName());
        territory.setDescription(request.getDescription());
        territory.setRegion(region);

        return territory;
    }

    public TerritoryResponse toResponse(Territory territory) {

        TerritoryResponse response = new TerritoryResponse();

        response.setId(territory.getId());
        response.setTerritoryCode(territory.getTerritoryCode());
        response.setTerritoryName(territory.getTerritoryName());

        response.setRegionId(territory.getRegion().getId());
        response.setRegionCode(territory.getRegion().getRegionCode());
        response.setRegionName(territory.getRegion().getRegionName());

        response.setDescription(territory.getDescription());
       

        return response;
    }
}