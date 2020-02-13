package com.gomax.repositories;

import com.gomax.entities.Film;
import org.springframework.data.repository.CrudRepository;


public interface FilmRepo extends CrudRepository<Film, Long> {


        }