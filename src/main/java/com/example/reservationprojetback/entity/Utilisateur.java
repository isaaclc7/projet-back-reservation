package com.example.reservationprojetback.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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
    @NotNull(message = "{NotNull.Utilisateur.mail}")
    private String mail;

    @Column(name = "mot_de_passe")
    @NotNull(message = "{NotNull.Utilisateur.motDePasse}")
    private String motDePasse;

    public Utilisateur() {
    }

    public Utilisateur(Integer id, String nom, String prenom, String mail, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
    }

    public Integer getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String mot_de_passe) {
        this.motDePasse = mot_de_passe;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur)) return false;
        Utilisateur utilisateur = (Utilisateur) o;
        return Objects.equals(utilisateur, utilisateur.mail) &&
                Objects.equals(motDePasse, utilisateur.motDePasse);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, mail, motDePasse);
    }
}
