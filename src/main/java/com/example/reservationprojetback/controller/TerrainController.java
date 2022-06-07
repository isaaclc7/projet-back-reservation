package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TerrainController {

    @Autowired
    TerrainService terrainService;
    @GetMapping(path = "/terrains")
    public ResponseEntity<?> listTerrains() {
        List<Terrain> terrains = terrainService.getTerrain();
        return  ResponseEntity.ok(terrains);
    }
    @GetMapping(path = "/terrain")
    public ResponseEntity<Terrain> findTerrainByNumero(@RequestParam String numero) {
        Optional<Terrain> terrain = terrainService.getTerrainByNumero(numero);
        if (terrain.isPresent()) {
            return new ResponseEntity<>(terrain.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
