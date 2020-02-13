package com.gomax.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="commande")
@Data
public class Commande {
	
	@Id
	@GeneratedValue
	private Long id;
	//private Seance seance;

	@ManyToOne
	private Client client;

	@OneToMany
	@JoinTable(name = "commande_siege")
	private List<Siege> sieges;

	@ElementCollection
	@MapKeyJoinColumn(name="snack_id")
	@CollectionTable(name = "commande_snack")
	@Column(name="quantite")
	private Map<Snack, Integer> snacks;
	
	@ElementCollection
	@MapKeyJoinColumn(name="tarif_id")
	@CollectionTable(name = "commande_tarif")
	@Column(name="nb_place")
	private Map<Tarif,Integer> tarifs;

}
