package com.gomax.entities;

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

@Entity
@Table(name="snack")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snack {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	// annotation from Jackson
	@JsonProperty("name")
	private String libelle;
	
	// annotation from Jackson
		//@JsonProperty("image")
		private String image;
	
	// annotation from Jackson
	@JsonProperty("price")
	private Double prix;

	
	//@ManyToOne
	//private Commande_snack commande_snack;
	
}