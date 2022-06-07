package com.example.reservationprojetback.repository;

import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
    Optional<Terrain> findByNumero(String numero);
}
