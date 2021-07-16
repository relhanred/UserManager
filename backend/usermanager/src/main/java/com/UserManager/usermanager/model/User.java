package com.taty.usermanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String prenom;
    private String nom;
    private String phone;
    private String email;

    public User() {}

    public User(String prenom, String nom, String phone, String email)  {
        this.prenom = prenom;
        this.nom = nom;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "User{" +
                "id = "+ id +
                "prenom = "+ prenom +
                "nom =" + nom +
                "phone =" + phone +
                "email =" + email +
                "}";
    }
}
