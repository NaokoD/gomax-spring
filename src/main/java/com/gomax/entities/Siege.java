package com.gomax.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="siege")
@Data
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Siege {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "sieges")
	@JsonBackReference
	private List<Commande> commandes;
}
