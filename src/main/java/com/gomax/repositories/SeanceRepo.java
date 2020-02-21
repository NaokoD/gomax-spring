package com.gomax.repositories;



import com.gomax.entities.Film;
import com.gomax.entities.Seance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface SeanceRepo extends CrudRepository<Seance, Long> {

    public List<Seance> findByFilm(Film film);

    @Query(value ="SELECT SUM(nb_place) FROM commande c JOIN commande_tarif ct ON c.id = ct.commande_id WHERE seance_id = :seanceId", nativeQuery = true)
    Integer findNombreDePlacesPrises(@Param("seanceId") Long seanceId);



}