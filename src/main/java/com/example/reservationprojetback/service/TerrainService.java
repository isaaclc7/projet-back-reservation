package com.example.reservationprojetback.service;

import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerrainService {

    private TerrainRepository terrainRepository;

    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }
    public List<Terrain> getTerrain() { return terrainRepository.findAll(); };
}
