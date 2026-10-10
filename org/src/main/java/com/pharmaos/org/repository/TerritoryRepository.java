package com.pharmaos.org.repository;

import com.pharmaos.org.entity.Region;
import com.pharmaos.org.entity.Territory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TerritoryRepository extends JpaRepository<Territory, UUID> {

    boolean existsByRegionAndTerritoryCode(
            Region region,
            String territoryCode
    );

    boolean existsByRegionAndTerritoryName(
            Region region,
            String territoryName
    );

    @EntityGraph(attributePaths = "region")
    List<Territory> findByRegionId(UUID regionId);

    @Override
    @EntityGraph(attributePaths = "region")
    List<Territory> findAll();

    @Override
    @EntityGraph(attributePaths = "region")
    Optional<Territory> findById(UUID id);
}