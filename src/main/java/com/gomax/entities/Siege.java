package com.gomax.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="siege")
@Data
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "id")
public class Siege {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "sieges")
	@JsonBackReference
	private Set<Commande> commandes;

//	@Transient
//	public Set<Long> commandeIds;
//
//	@PostLoad
//	private void postLoad() {
//		commandeIds = commandes.stream().map(Commande::getId).collect(Collectors.toSet());
//	}
}
