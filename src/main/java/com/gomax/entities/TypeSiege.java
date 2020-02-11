package com.gomax.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="type_siege")
@Data
public class TypeSiege {

	@Id
	@GeneratedValue
	private Long id;
	private String libelle;
}
