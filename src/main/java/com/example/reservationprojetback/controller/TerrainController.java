package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.repository.TerrainRepository;
import com.example.reservationprojetback.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public class TerrainController {

    @Autowired
    TerrainService terrainService;
    @GetMapping("/terrains")
    public ResponseEntity<?> listTerrains() {
        List<Terrain> terrains = terrainService.getTerrain();
        return  ResponseEntity.ok(terrains);
    }

}
