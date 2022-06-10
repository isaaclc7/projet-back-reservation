package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Disponibilite;
import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.service.DisponibiliteService;
import com.example.reservationprojetback.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DisponibiliteController {

    @Autowired
    private DisponibiliteService disponibiliteService;

    @Autowired
    private TerrainService terrainService;

    @GetMapping(path = "/disponibilites")
    public ResponseEntity<List<Disponibilite>> findDisponibiliteByTerrain(@RequestParam String numero) {
        Optional<Terrain> terrain = terrainService.getTerrainByNumero(numero);
        List<Disponibilite> disponibilites = disponibiliteService.getDisponibilites();
        if (terrain.isPresent()) {
            List<Disponibilite> disponibilitesByTerrain = disponibilites
                    .stream()
                    .filter(d -> d.getTerrain().getNumero().equals(terrain.get().getNumero()))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(disponibilitesByTerrain, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(path = "/disponibilites/{id}")
    public void deleteDisponibilities(@PathVariable("id") @Min(1) Integer id) {
        disponibiliteService.deleteDisponibilitie(id);
    }


}
