package com.pharmaos.org.mapper;

import com.pharmaos.org.dto.HeadquarterRequest;
import com.pharmaos.org.dto.HeadquarterResponse;
import com.pharmaos.org.entity.Headquarter;
import com.pharmaos.org.entity.Territory;
import org.springframework.stereotype.Component;

@Component
public class HeadquarterMapper {

    public Headquarter toEntity(HeadquarterRequest request, Territory territory) {

        Headquarter hq = new Headquarter();

        hq.setHqCode(request.getHqCode());
        hq.setHqName(request.getHqName());
        hq.setTerritory(territory);
        hq.setState(request.getState());
        hq.setDistrict(request.getDistrict());
        hq.setCity(request.getCity());
        hq.setPincode(request.getPincode());
        hq.setDescription(request.getDescription());

        return hq;
    }

    public HeadquarterResponse toResponse(Headquarter hq) {

        HeadquarterResponse response = new HeadquarterResponse();

        response.setId(hq.getId());
        response.setHqCode(hq.getHqCode());
        response.setHqName(hq.getHqName());

        response.setTerritoryId(hq.getTerritory().getId());
        response.setTerritoryCode(hq.getTerritory().getTerritoryCode());
        response.setTerritoryName(hq.getTerritory().getTerritoryName());

        response.setState(hq.getState());
        response.setDistrict(hq.getDistrict());
        response.setCity(hq.getCity());
        response.setPincode(hq.getPincode());
        response.setDescription(hq.getDescription());

        return response;
    }
}