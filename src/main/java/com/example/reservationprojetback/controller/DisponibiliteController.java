package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Disponibilite;
import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.service.DisponibiliteService;
import com.example.reservationprojetback.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api")

public class DisponibiliteController {

    @Autowired
    private DisponibiliteService disponibiliteService;
    private TerrainService terrainService;

    @GetMapping(path = "/disponibilites")
    public ResponseEntity<Disponibilite> findDisponibiliteByTerrain(@RequestParam String numero) {
        Optional<Terrain> terrain = terrainService.getTerrainByNumero(numero);
        List<Disponibilite> disponibilite = disponibiliteService.getDisponibilite();
        if (terrain.isPresent()) {
            String numeroTerrain = terrain.get().getNumero();
            disponibilite.stream().filter(terrain.get().getNumero())
            ResponseEntity.ok(disponibilite);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }
}
