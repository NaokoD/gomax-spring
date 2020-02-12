package com.gomax.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="client")
@Data
public class Client {

	@Id
	@GeneratedValue
	private Long id;

	private String nom;
	private String prenom;
	private String email;
	private LocalDate dateDeNaissance;
	private String adresse;
	private String cp;
	private String ville;
	private String pays;
	private String numeroDeFidelite;
}
