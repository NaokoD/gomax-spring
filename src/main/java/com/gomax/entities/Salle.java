package com.gomax.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="salle")
@Data
public class Salle {
	
	@Id
	@GeneratedValue
	private Long id;
	private String plan;
	private Integer numero;
	
	@ManyToOne
	private Cinema cinema;

}
