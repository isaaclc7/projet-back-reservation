package com.example.reservationprojetback.repository;

import com.example.reservationprojetback.entity.Disponibilite;
import com.example.reservationprojetback.entity.Reservation;
import com.example.reservationprojetback.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Integer> {

    List<Disponibilite> findByTerrain(String numero);


}
