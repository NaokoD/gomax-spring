package com.gomax.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
	private String libelle;
	private Double prix;

}