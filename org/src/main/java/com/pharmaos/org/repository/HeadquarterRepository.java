package com.pharmaos.org.repository;

import com.pharmaos.org.entity.Headquarter;
import com.pharmaos.org.entity.Territory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HeadquarterRepository extends JpaRepository<Headquarter, UUID> {

    boolean existsByTerritoryAndHqCode(Territory territory, String hqCode);

    boolean existsByTerritoryAndHqName(Territory territory, String hqName);

    @EntityGraph(attributePaths = "territory")
    List<Headquarter> findByTerritoryId(UUID territoryId);

    @Override
    @EntityGraph(attributePaths = "territory")
    List<Headquarter> findAll();

    @Override
    @EntityGraph(attributePaths = "territory")
    Optional<Headquarter> findById(UUID id);
}