package com.example.reservationprojetback.Entity;

import javax.persistence.*;

@Entity
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String numero;
}
