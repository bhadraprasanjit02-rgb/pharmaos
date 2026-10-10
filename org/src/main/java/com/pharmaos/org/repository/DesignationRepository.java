package com.pharmaos.org.repository;

import com.pharmaos.org.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DesignationRepository extends JpaRepository<Designation, UUID> {

    boolean existsByDesignationCode(String designationCode);

    boolean existsByDesignationName(String designationName);

}