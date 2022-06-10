package com.example.reservationprojetback.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "{NotNull.Utilisateur.nom}")
    private String nom;

    @Column
    @NotNull(message = "{NotNull.Utilisateur.prenom}")
    private String prenom;

    @Column
    @NotNull(message = "{NotNull.Utilisateur.telephone}")
    private String telephone;

    public Utilisateur() {
    }

    public Utilisateur(Integer id, String nom, String prenom, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
