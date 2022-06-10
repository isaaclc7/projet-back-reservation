package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TerrainController {

    @Autowired
    TerrainService terrainService;

    @GetMapping(path = "/terrains")
    public ResponseEntity<List<Terrain>> listTerrains() {
        List<Terrain> terrains = terrainService.getTerrain();
        return  new ResponseEntity<>(terrains, HttpStatus.OK);
    }
    @GetMapping(path = "/terrains/{id}")
    public ResponseEntity<Terrain> findTerrainById(@PathVariable("id") @Min(1) Integer id) {
        Optional<Terrain> terrain = terrainService.getTerrainById(id);
        if (terrain.isPresent()) {
            return new ResponseEntity<>(terrain.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    @PostMapping(path = "/terrains")
    public ResponseEntity<Terrain> createTerrain(@RequestBody Terrain terrain) {
        Optional<Terrain> terrainAlreadyExist = terrainService.getTerrainByNumero(terrain.getNumero());

        if (terrainAlreadyExist.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Le numéro de terrain renseigné est déjà enregistré");
        } else {
            terrainService.createTerrain(terrain);
        }
        return new ResponseEntity<>(terrain, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/terrains/{id}")
    public void deleteTerrain(@PathVariable("id") @Min(1) Integer id) {
        terrainService.deleteTerrain(id);
    }

}
