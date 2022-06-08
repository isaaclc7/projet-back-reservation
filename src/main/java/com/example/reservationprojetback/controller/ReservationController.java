package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Reservation;
import com.example.reservationprojetback.entity.Utilisateur;
import com.example.reservationprojetback.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
}
