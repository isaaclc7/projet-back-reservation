package com.example.reservationprojetback.controller;

import com.example.reservationprojetback.entity.Reservation;
import com.example.reservationprojetback.service.ReservationService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping(path = "/reservation/{id}")
    public ResponseEntity<Reservation> findOneReservation(@PathVariable("id") @Min(1) Integer id) {
        Optional<Reservation> reservation = reservationService.getDisponibilite(id);
        if (reservation.isPresent()) {
            return new ResponseEntity<>(reservation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/reservation/{id}")
    public void deleteReservation(@PathVariable("id") @Min(1) Integer id) {
        reservationService.deleteReservation(id);
    }
}
