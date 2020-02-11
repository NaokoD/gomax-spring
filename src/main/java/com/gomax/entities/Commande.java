package com.gomax.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private List<Siege> sieges;

	@ElementCollection
	@MapKeyColumn(name = "snack_id")
	@Column(name = "quantite")
	@CollectionTable(name = "commande_snack")
	private Map<Snack, Integer> snacks;
	
	@ElementCollection
	@MapKeyColumn(name = "tarif_id")
	@Column(name = "nb_place")
	@CollectionTable(name = "commande_tarif")
	private Map<Tarif, Integer> tarifs;
	
	
	
}
