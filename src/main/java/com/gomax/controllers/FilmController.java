package com.gomax.controllers;

import com.gomax.entities.Film;
import com.gomax.entities.Seance;
import com.gomax.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/films")
public class FilmController {

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping("")
    public ResponseEntity<List<Film>> getFilms() {
        return new ResponseEntity<>(this.filmService.findAllFilms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        return new ResponseEntity<>(this.filmService.findFilmById(id).get(), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Film> postFilm(@RequestBody Film f) {
        return new ResponseEntity<>(this.filmService.saveFilm(f),
                HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Film> putFilm(@RequestBody Film f) {
        if (this.filmService.existsFilmById(f.getId()))
            return new ResponseEntity<>(this.filmService.saveFilm(f),
                    HttpStatus.OK);
        else
            return new ResponseEntity<>(f,
                    HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilmById(@PathVariable Long id) {
        this.filmService.deleteFilmById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}