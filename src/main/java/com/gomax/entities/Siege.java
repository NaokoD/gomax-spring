package com.gomax.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="siege")
@Data
public class Siege {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Salle salle;
	@ManyToOne
	private TypeSiege typeSiege;
	
}
