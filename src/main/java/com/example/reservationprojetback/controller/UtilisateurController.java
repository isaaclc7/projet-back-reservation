package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping(path = "/utilisateurs")
    public ResponseEntity<Utilisateur> findUtilisateurByTelephone(@RequestParam String telephone) {
        Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateurByTelephone(telephone);
        if (utilisateur.isPresent()) {
            return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path = "/utilisateurs/{id}")
    public ResponseEntity<?> findOneUtilisateur(@PathVariable("id") @Min(1) Integer id) {
        Optional<Utilisateur> utilisateur = utilisateurService.getOneUtilisateur(id);
        if (utilisateur.isPresent()) {
            return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/utilisateurs")
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        Optional<Utilisateur> telephoneAlreadyExist = utilisateurService.getUtilisateurByTelephone(utilisateur.getTelephone());

        if (telephoneAlreadyExist.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Le numéro de téléphone renseigné est déjà enregistré");
        } else {
            utilisateurService.createUtilisateur(utilisateur);
        }
        return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
    }
}
