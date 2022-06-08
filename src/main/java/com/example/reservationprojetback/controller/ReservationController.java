package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Reservation;
import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(path = "/reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/reservation")
    public void deleteReservation(@PathVariable("id") @Min(1) Integer id) {
        reservationService.deleteReservation(id);
    }
}
