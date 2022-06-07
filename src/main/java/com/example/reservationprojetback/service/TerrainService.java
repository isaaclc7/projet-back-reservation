package com.example.reservationprojetback.service;

import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {

    private TerrainRepository terrainRepository;

    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }
    public List<Terrain> getTerrain() { return terrainRepository.findAll(); }
    public Optional<Terrain> getTerrainByNumero (String numero) {
        return terrainRepository.findByNumero(numero);
    }
}
