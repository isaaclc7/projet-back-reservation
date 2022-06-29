package com.example.reservationprojetback.service;

import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {

    private TerrainRepository terrainRepository;

    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<Terrain> getTerrains() { return terrainRepository.findAll(); }

    public Optional<Terrain> getTerrainById(Integer id) { return terrainRepository.findById(id); }

    public Optional<Terrain> getTerrainByNumero (String numero) {
        return terrainRepository.findByNumero(numero);
    }

    public Terrain createTerrain (Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public void deleteTerrain(@Min(1) Integer id) {
        terrainRepository.deleteById(id);
    }
}
