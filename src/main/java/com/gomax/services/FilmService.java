package com.gomax.services;


import com.gomax.entities.Film;
import com.gomax.repositories.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service <=> @Component <=> @Bean
@Service
public class FilmService {

    // DI better in constructor
    // @Autowired, @Inject, @Resource
    private FilmRepo filmRepo;

    // Dependency Injection
    @Autowired
    public FilmService(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    public List<Film> findAllFilms() {

        return (List<Film>) filmRepo.findAll();
    }

    public Optional<Film> findFilmById(Long id) {
        // use Optional
        return this.filmRepo.findById(id);
    }

    public Film saveFilm(Film f) {
        return this.filmRepo.save(f);
    }

    public void deleteFilmById(Long id) {
        this.filmRepo.deleteById(id);
    }

    public boolean existsFilmById(Long id) {
        return this.filmRepo.existsById(id);
    }
}