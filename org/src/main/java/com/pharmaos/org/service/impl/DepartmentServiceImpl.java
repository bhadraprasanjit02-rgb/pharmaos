package com.pharmaos.org.service.impl;

import com.pharmaos.org.dto.DepartmentRequest;
import com.pharmaos.org.dto.DepartmentResponse;
import com.pharmaos.org.entity.Department;
import com.pharmaos.org.mapper.DepartmentMapper;
import com.pharmaos.org.repository.DepartmentRepository;
import com.pharmaos.org.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponse create(DepartmentRequest request) {

        if (departmentRepository.existsByDepartmentCode(request.getDepartmentCode())) {
            throw new RuntimeException("Department Code already exists.");
        }

        if (departmentRepository.existsByDepartmentName(request.getDepartmentName())) {
            throw new RuntimeException("Department Name already exists.");
        }

        Department department = departmentMapper.toEntity(request);

        return departmentMapper.toResponse(
                departmentRepository.save(department)
        );
    }

    @Override
    public DepartmentResponse update(UUID id, DepartmentRequest request) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found."));

        department.setDepartmentCode(request.getDepartmentCode());
        department.setDepartmentName(request.getDepartmentName());
        department.setDescription(request.getDescription());

        return departmentMapper.toResponse(
                departmentRepository.save(department)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentResponse getById(UUID id) {

        return departmentMapper.toResponse(
                departmentRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Department not found."))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentResponse> getAll() {

        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found."));

        departmentRepository.delete(department);
    }
}