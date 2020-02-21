package com.gomax.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gomax.tools.MapSnackDeserializer;
import com.gomax.tools.MapSnackSerializer;
import com.gomax.tools.MapTarifDeserializer;
import com.gomax.tools.MapTarifSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="commande")
@Data

//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "id")
@EqualsAndHashCode(exclude = {"client","seance","tarifs","sieges","snacks"})
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "client_id")
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

	@ManyToMany
	@JoinTable(
			name = "commande_siege",
			joinColumns = { @JoinColumn(name = "commande_id") },
			inverseJoinColumns=@JoinColumn(name="siege_id"))
	private Set<Siege> sieges;

	@ManyToMany
	@JoinTable(
			name = "commande_accompagnant",
			joinColumns = { @JoinColumn(name = "commande_id") },
			inverseJoinColumns=@JoinColumn(name="accompagnant_id"))
	private Set<Accompagnant> accompagnants;

	@ElementCollection
	@MapKeyJoinColumn(name="snack_id")
	@CollectionTable(name = "commande_snack")
	@Column(name="quantite")
	@JsonSerialize(using = MapSnackSerializer.class)
	@JsonDeserialize(using = MapSnackDeserializer.class)
	private Map<Snack, Integer> snacks;

}
