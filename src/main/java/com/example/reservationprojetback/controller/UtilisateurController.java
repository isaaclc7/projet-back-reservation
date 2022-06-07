package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.Entity.Utilisateur;
import com.example.reservationprojetback.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping(path = "/utilisateurs")
    public ResponseEntity<Utilisateur> findUtilisateurByMail(@RequestParam String mail) {
        Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateurByMail(mail);
        if (utilisateur.isPresent()) {
            return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/utilisateurs")
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception {
        Optional<Utilisateur> mailAlreadyExist = utilisateurService.getUtilisateurByMail(utilisateur.getMail());

        if (mailAlreadyExist.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Le mail renseigné existe déjà");
        } else {
            utilisateurService.createUtilisateur(utilisateur);
        }
        return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
    }
}
