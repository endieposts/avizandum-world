package com.endie.avizandum.world.repository;

import com.endie.avizandum.world.model.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {

    Terrain findOneByTerrainId(@Param("terrainId") Long terrainId);
}
