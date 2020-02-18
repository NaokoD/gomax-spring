package com.gomax.services;


import com.gomax.entities.Film;
import com.gomax.entities.Seance;
import com.gomax.repositories.SeanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// @Service <=> @Component <=> @Bean
@Service
public class SeanceService {

    // DI better in constructor
    // @Autowired, @Inject, @Resource
    private SeanceRepo seanceRepo;

    // Dependency Injection
    @Autowired
    public SeanceService(SeanceRepo seanceRepo) {
        this.seanceRepo = seanceRepo;
    }

    public List<Seance> findAllSeances() {

        return (List<Seance>) seanceRepo.findAll();
    }


    public Optional<Seance> findSeanceById(Long id) {
        // use Optional
        return this.seanceRepo.findById(id);
    }


    public List<Seance> findAllSeancesByFilmId(Long idFilm){
        Film film = new Film();
        film.setId(idFilm);
        return (List<Seance>) seanceRepo.findByFilm(film);
    }


    public Seance saveSeance(Seance s) {
        return this.seanceRepo.save(s);
    }

    public void deleteSeanceById(Long id) {
        this.seanceRepo.deleteById(id);
    }

    public boolean existsSeanceById(Long id) {
        return this.seanceRepo.existsById(id);
    }
}