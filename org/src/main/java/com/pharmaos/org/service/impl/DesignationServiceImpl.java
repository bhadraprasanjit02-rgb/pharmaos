package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.DesignationRequest;
import com.pharmaos.org.dto.DesignationResponse;
import com.pharmaos.org.entity.Designation;
import com.pharmaos.org.mapper.DesignationMapper;
import com.pharmaos.org.repository.DesignationRepository;
import com.pharmaos.org.service.DesignationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DesignationServiceImpl implements DesignationService {

    private final DesignationRepository designationRepository;
    private final DesignationMapper designationMapper;

    @Override
    public DesignationResponse create(DesignationRequest request) {

        if (designationRepository.existsByDesignationCode(request.getDesignationCode())) {
            throw new RuntimeException("Designation Code already exists.");
        }

        if (designationRepository.existsByDesignationName(request.getDesignationName())) {
            throw new RuntimeException("Designation Name already exists.");
        }

        Designation parent = null;

        if (request.getParentDesignationId() != null) {
            parent = designationRepository.findById(request.getParentDesignationId())
                    .orElseThrow(() ->
                            new RuntimeException("Parent Designation not found."));
        }

        Designation designation =
                designationMapper.toEntity(request, parent);

        return designationMapper.toResponse(
                designationRepository.save(designation));
    }

    @Override
    public DesignationResponse update(UUID id,
                                      DesignationRequest request) {

        Designation designation = designationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Designation not found."));

        Designation parent = null;

        if (request.getParentDesignationId() != null) {
            parent = designationRepository.findById(request.getParentDesignationId())
                    .orElseThrow(() ->
                            new RuntimeException("Parent Designation not found."));
        }

        designation.setDesignationCode(request.getDesignationCode());
        designation.setDesignationName(request.getDesignationName());
        designation.setHierarchyLevel(request.getHierarchyLevel());
        designation.setParentDesignation(parent);
        designation.setIsManager(request.getIsManager());
        designation.setIsFieldForce(request.getIsFieldForce());
        designation.setIsSalesRole(request.getIsSalesRole());
        designation.setDescription(request.getDescription());

        return designationMapper.toResponse(
                designationRepository.save(designation));
    }

    @Override
    @Transactional(readOnly = true)
    public DesignationResponse getById(UUID id) {

        return designationMapper.toResponse(
                designationRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Designation not found."))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<DesignationResponse> getAll() {

        return designationRepository.findAll()
                .stream()
                .map(designationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {

        Designation designation = designationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Designation not found."));

        designationRepository.delete(designation);
    }
}