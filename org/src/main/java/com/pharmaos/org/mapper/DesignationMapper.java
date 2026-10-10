package com.pharmaos.org.mapper;

import com.pharmaos.org.dto.DesignationRequest;
import com.pharmaos.org.dto.DesignationResponse;
import com.pharmaos.org.entity.Designation;
import org.springframework.stereotype.Component;

@Component
public class DesignationMapper {

    public Designation toEntity(DesignationRequest request, Designation parent) {

        Designation designation = new Designation();

        designation.setDesignationCode(request.getDesignationCode());
        designation.setDesignationName(request.getDesignationName());
        designation.setHierarchyLevel(request.getHierarchyLevel());
        designation.setParentDesignation(parent);
        designation.setIsManager(request.getIsManager());
        designation.setIsFieldForce(request.getIsFieldForce());
        designation.setIsSalesRole(request.getIsSalesRole());
        designation.setDescription(request.getDescription());

        return designation;
    }

    public DesignationResponse toResponse(Designation designation) {

        DesignationResponse response = new DesignationResponse();

        response.setId(designation.getId());
        response.setDesignationCode(designation.getDesignationCode());
        response.setDesignationName(designation.getDesignationName());
        response.setHierarchyLevel(designation.getHierarchyLevel());

        if (designation.getParentDesignation() != null) {
            response.setParentDesignationId(
                    designation.getParentDesignation().getId());

            response.setParentDesignationName(
                    designation.getParentDesignation().getDesignationName());
        }

        response.setIsManager(designation.getIsManager());
        response.setIsFieldForce(designation.getIsFieldForce());
        response.setIsSalesRole(designation.getIsSalesRole());

        response.setDescription(designation.getDescription());

        return response;
    }
}