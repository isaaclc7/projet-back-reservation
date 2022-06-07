package com.example.reservationprojetback.repository;

import com.example.reservationprojetback.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
}