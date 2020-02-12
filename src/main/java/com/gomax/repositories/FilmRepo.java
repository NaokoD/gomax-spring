package com.gomax.repositories;

import com.gomax.entities.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface FilmRepo extends CrudRepository<Film, Long> {

public Film findByTitre(String titre);

// @Query => write JPQL or SQL query
@Query(value = "SELECT * FROM Film WHERE titre LIKE %?1%", nativeQuery = true)
public Film findWithTitre(String titre);
        }