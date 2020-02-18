package com.gomax.repositories;



import com.gomax.entities.Film;
import com.gomax.entities.Seance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface SeanceRepo extends CrudRepository<Seance, Long> {

    public List<Seance> findByFilm(Film film);




}