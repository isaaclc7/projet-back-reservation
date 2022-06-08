package com.example.reservationprojetback.service;

import com.example.reservationprojetback.entity.Reservation;
import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    public Reservation createReservation (Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
