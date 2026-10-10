package com.pharmaos.org.repository;

import com.pharmaos.org.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findByCompanyCode(String companyCode);

    Optional<Company> findByCompanyName(String companyName);

    boolean existsByCompanyCode(String companyCode);

    boolean existsByCompanyName(String companyName);

    boolean existsByGstNumber(String gstNumber);

    boolean existsByPanNumber(String panNumber);

    boolean existsByCinNumber(String cinNumber);

}