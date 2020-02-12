package com.gomax.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity => @Id + Bean JAVA
// Bean JAVA => class 1 constructeur

@Entity
@Table(name="snack")

@Data
@AllArgsConstructor
@NoArgsConstructor

//@Getters
//@Setters

public class Snack {
	// int => type primitif
	// Integer => type objet, type wrappe
	// @GeneratedValue(strategy=GenerationType.AUTO)
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@Column(name="libelle")
	// annotation from Jackson
	@JsonProperty("name")
	private String name;
	
	@Column(name="prix")
	// annotation from Jackson
	@JsonProperty("price")
	private Double price;
	
	
	//@ManyToOne
	//private Commande_snack commande_snack;
	
}