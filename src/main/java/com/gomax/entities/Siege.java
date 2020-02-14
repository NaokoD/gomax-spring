package com.gomax.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="siege")
@Data
public class Siege {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private TypeSiege typeSiege;

}
