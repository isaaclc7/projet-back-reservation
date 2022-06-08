package com.example.reservationprojetback.repository;

import com.example.reservationprojetback.entity.Disponibilite;
import com.example.reservationprojetback.entity.Reservation;
import com.example.reservationprojetback.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Integer> {

    Optional<Disponibilite> findByTerrain(String numero);
}
