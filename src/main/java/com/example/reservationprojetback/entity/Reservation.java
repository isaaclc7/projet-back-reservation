package com.example.reservationprojetback.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_reservation")
    private Date dateReservation;

    @ManyToOne
    @JoinColumn(name = "id_terrain")
    private Terrain terrain;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    public Reservation() {
    }

    public Reservation(Integer id, Date dateReservation, Terrain terrain, Utilisateur utilisateur) {
        this.id = id;
        this.dateReservation = dateReservation;
        this.terrain = terrain;
        this.utilisateur = utilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDateReservation(), that.getDateReservation()) && Objects.equals(getTerrain(), that.getTerrain()) && Objects.equals(getUtilisateur(), that.getUtilisateur());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateReservation(), getTerrain(), getUtilisateur());
    }
}
