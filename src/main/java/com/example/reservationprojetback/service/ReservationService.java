package com.example.reservationprojetback.service;

import com.example.reservationprojetback.entity.Reservation;
import com.example.reservationprojetback.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> getDisponibilite(Integer id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation (Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(@Min(1) Integer id) {
        reservationRepository.deleteById(id);
    }
}
