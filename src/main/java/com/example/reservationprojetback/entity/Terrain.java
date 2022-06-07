package com.example.reservationprojetback.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String numero;

    public Terrain(Integer id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Terrain)) return false;
        Terrain terrain = (Terrain) o;
        return Objects.equals(getId(), terrain.getId()) && Objects.equals(getNumero(), terrain.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumero());
    }
}