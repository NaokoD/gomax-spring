package com.gomax.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="cinema")
@Data
public class Cinema {

	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String adresse;
	private String cp;
	private String ville;
	
}