package com.gomax.repositories;

import com.gomax.entities.Commande;
import com.gomax.entities.Seance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {

    public List<Commande> findCommandesBySeance(Seance seance);
}
