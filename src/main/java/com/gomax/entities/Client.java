package com.gomax.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="client")
@PrimaryKeyJoinColumn(name = "clientId")
@Data
public class Client extends Utilisateur{



	private String email;
	private LocalDate dateDeNaissance;
	private String adresse;
	private String cp;
	private String ville;
	private String pays;
	private String numeroDeFidelite;
}
