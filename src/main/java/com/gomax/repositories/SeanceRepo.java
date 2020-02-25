package com.gomax.repositories;



import com.gomax.entities.Film;
import com.gomax.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface SeanceRepo extends CrudRepository<Seance, Long> {

    public List<Seance> findByFilm(Film film);

    @Query(value ="SELECT SUM(nb_place) FROM commande c JOIN commande_tarif ct ON c.id = ct.commande_id WHERE seance_id = :seanceId", nativeQuery = true)
    Integer findNombreDePlacesPrises(@Param("seanceId") Long seanceId);


    /*SELECT *
    FROM seance
    LEFT JOIN horaire
    ON seance.horaire_id = horaire.id
    WHERE dayofweek(date_seance) = 3
    AND film_id = 1
    AND NOW() < horaire
    ORDER BY horaire_id ASC*/

    /*@Query(value="SELECT * FROM seance s WHERE dayofweek(date_seance) = 1 AND film_id = :filmId ORDER BY horaire_id ASC", nativeQuery = true)*/

    @Query(value="SELECT * FROM seance LEFT JOIN Horaire ON seance.horaire_id = horaire.id WHERE dayofweek(date_seance) = 1 AND date_seance >= CURDATE() AND film_id = :filmId AND HOUR(horaire.horaire) > HOUR(NOW()) ORDER BY horaire.horaire ASC", nativeQuery = true)
    List<Seance> findSeanceOnSundayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance  LEFT JOIN Horaire ON seance.horaire_id = horaire.id WHERE dayofweek(date_seance) = 2 AND date_seance >= CURDATE() AND film_id = :filmId AND HOUR(horaire.horaire) > HOUR(NOW()) ORDER BY horaire.horaire ASC", nativeQuery = true)
    List<Seance> findSeanceOnMondayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance LEFT JOIN Horaire ON seance.horaire_id = horaire.id WHERE dayofweek(date_seance) = 3 AND date_seance >= CURDATE() AND film_id = :filmId AND HOUR(horaire.horaire) > HOUR(NOW()) ORDER BY horaire.horaire ASC", nativeQuery = true)
    List<Seance> findSeanceOnTuesdayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance LEFT JOIN Horaire ON seance.horaire_id = horaire.id WHERE dayofweek(date_seance) = 4 AND date_seance >= CURDATE() AND film_id = :filmId AND HOUR(horaire.horaire) > HOUR(NOW()) ORDER BY horaire.horaire ASC", nativeQuery = true)
    List<Seance> findSeanceOnWednesdayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance LEFT JOIN Horaire ON seance.horaire_id = horaire.id WHERE dayofweek(date_seance) = 5 AND date_seance >= CURDATE() AND film_id = :filmId AND HOUR(horaire.horaire) > HOUR(NOW()) ORDER BY horaire.horaire ASC", nativeQuery = true)
    List<Seance> findSeanceOnThursdayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance LEFT JOIN Horaire ON seance.horaire_id = horaire.id WHERE dayofweek(date_seance) = 6 AND date_seance >= CURDATE() AND film_id = :filmId AND HOUR(horaire.horaire) > HOUR(NOW()) ORDER BY horaire.horaire ASC", nativeQuery = true)
    List<Seance> findSeanceOnFridayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance LEFT JOIN Horaire ON seance.horaire_id = horaire.id WHERE dayofweek(date_seance) = 7 AND date_seance >= CURDATE() AND film_id = :filmId AND HOUR(horaire.horaire) > HOUR(NOW()) ORDER BY horaire.horaire ASC", nativeQuery = true)
    List<Seance> findSeanceOnSaturdayByFilm(@Param("filmId") Long filmId);


}