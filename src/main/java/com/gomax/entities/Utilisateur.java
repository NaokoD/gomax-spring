package com.gomax.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Utilisateur {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String prenom;

}
