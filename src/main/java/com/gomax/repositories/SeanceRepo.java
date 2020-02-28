package com.gomax.repositories;



import com.gomax.entities.Film;
import com.gomax.entities.Seance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SeanceRepo extends CrudRepository<Seance, Long> {

    public List<Seance> findByFilm(Film film);

    @Query(value ="SELECT SUM(nb_place) FROM commande c JOIN commande_tarif ct ON c.id = ct.commande_id WHERE seance_id = :seanceId", nativeQuery = true)
    Integer findNombreDePlacesPrises(@Param("seanceId") Long seanceId);


    @Query(value="SELECT * FROM seance WHERE dayofweek(date_seance) = 1 AND film_id = :filmId AND date_seance > NOW() ORDER BY date_seance ASC", nativeQuery = true)
    List<Seance> findSeanceOnSundayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance WHERE dayofweek(date_seance) = 2 AND film_id = :filmId AND date_seance > NOW() ORDER BY date_seance ASC", nativeQuery = true)
    List<Seance> findSeanceOnMondayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance WHERE dayofweek(date_seance) = 3 AND film_id = :filmId AND date_seance > NOW() ORDER BY date_seance ASC", nativeQuery = true)
    List<Seance> findSeanceOnTuesdayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance WHERE dayofweek(date_seance) = 4 AND film_id = :filmId AND date_seance > NOW() ORDER BY date_seance ASC", nativeQuery = true)
    List<Seance> findSeanceOnWednesdayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance WHERE dayofweek(date_seance) = 5 AND film_id = :filmId AND date_seance > NOW() ORDER BY date_seance ASC", nativeQuery = true)
    List<Seance> findSeanceOnThursdayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance WHERE dayofweek(date_seance) = 6 AND film_id = :filmId AND date_seance > NOW() ORDER BY date_seance ASC", nativeQuery = true)
    List<Seance> findSeanceOnFridayByFilm(@Param("filmId") Long filmId);

    @Query(value="SELECT * FROM seance WHERE dayofweek(date_seance) = 7 AND film_id = :filmId AND date_seance > NOW() ORDER BY date_seance ASC", nativeQuery = true)
    List<Seance> findSeanceOnSaturdayByFilm(@Param("filmId") Long filmId);


}