package com.gomax.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gomax.tools.MapSnackSerializer;
import com.gomax.tools.MapTarifDeserializer;
import com.gomax.tools.MapTarifSerializer;
import lombok.Data;

@Entity
@Table(name="commande")
@Data
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Client client;

	@ManyToOne
	private Seance seance;

	@ElementCollection
	@MapKeyJoinColumn(name="tarif_id")
	@CollectionTable(name = "commande_tarif")
	@Column(name="nb_place")
	@JsonSerialize(using = MapTarifSerializer.class)
	@JsonDeserialize(using = MapTarifDeserializer.class)
	private Map<Tarif,Integer> tarifs;

	private LocalDateTime dateDeCreation;

	@OneToMany
	@JoinTable(name = "commande_siege", inverseJoinColumns=@JoinColumn(name="siege_id"))
	private List<Siege> sieges;


	@ElementCollection
	@MapKeyJoinColumn(name="snack_id")
	@CollectionTable(name = "commande_snack")
	@Column(name="quantite")
	@JsonSerialize(using = MapSnackSerializer.class)
	private Map<Snack, Integer> snacks;

}
