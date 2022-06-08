package com.example.reservationprojetback.service;

import com.example.reservationprojetback.entity.Disponibilite;
import com.example.reservationprojetback.entity.Terrain;
import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.repository.DisponibiliteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisponibiliteService {

    private DisponibiliteRepository disponibiliteRepository;

    public DisponibiliteService(DisponibiliteRepository disponibiliteRepository) {
        this.disponibiliteRepository = disponibiliteRepository;
    }

    public Optional<Disponibilite> getDisponibiliteByTerrain (String numero) {
        return disponibiliteRepository.findByTerrain(numero);
    }

    public List<Disponibilite> getDisponibilites() { return disponibiliteRepository.findAll(); }

}