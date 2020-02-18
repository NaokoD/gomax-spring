package com.gomax.repositories;

import com.gomax.entities.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FilmRepo extends CrudRepository<Film, Long> {



        }