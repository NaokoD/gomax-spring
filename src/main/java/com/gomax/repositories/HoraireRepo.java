package com.gomax.repositories;

import com.gomax.entities.Horaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface HoraireRepo extends CrudRepository<Horaire, Long> {

    public Horaire findByHoraire(String horaire);

    // @Query => write JPQL or SQL query
    @Query(value = "SELECT * FROM Horaire WHERE horaire LIKE %?1%", nativeQuery = true)
    public Horaire findWithHoraire(String horaire);
}