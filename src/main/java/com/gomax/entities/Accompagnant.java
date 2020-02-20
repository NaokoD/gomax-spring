package com.gomax.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="accompagnant")
@PrimaryKeyJoinColumn(name = "accompagnantId")
@Data
public class Accompagnant extends Utilisateur{


}
