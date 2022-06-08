package com.example.reservationprojetback.service;

import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Optional<Utilisateur> getUtilisateurByMail (String mail) {
        return utilisateurRepository.findByMail(mail);
    }

    public Optional<Utilisateur> getOneUtilisateur(Integer id) { return utilisateurRepository.findById(id); };

    public Utilisateur createUtilisateur (Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
}
