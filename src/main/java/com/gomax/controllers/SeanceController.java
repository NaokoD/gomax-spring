package com.gomax.controllers;

import com.gomax.entities.Film;
import com.gomax.entities.Seance;
import com.gomax.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/seances")
public class SeanceController {

    private SeanceService  seanceService;

    @Autowired
    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }



    public ResponseEntity<List<Seance>> getSeances() {
        return new ResponseEntity<>(this.seanceService.findAllSeances(), HttpStatus.OK);
    }

    public ResponseEntity<List<Seance>> getSeancesByFilmId(@PathVariable Long filmId){
        return new ResponseEntity<>(this.seanceService.findAllSeancesByFilmId(filmId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seance> getSeanceById(@PathVariable Long id) {
        return new ResponseEntity<>(this.seanceService.findSeanceById(id).get(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Seance>> getAllSeancesByFilm(@RequestParam (required = false) Long idFilm){
        if(idFilm == null || idFilm.equals("")){
                return this.getSeances();
        }else{
            return this.getSeancesByFilmId(idFilm);
        }
    }


    @PostMapping("")
    public ResponseEntity<Seance> postSeance(@RequestBody Seance s) {
        System.out.println(s);
        return new ResponseEntity<>(this.seanceService.saveSeance(s),
                HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Seance> putSeance(@RequestBody Seance s) {
        if (this.seanceService.existsSeanceById(s.getId()))
            return new ResponseEntity<>(this.seanceService.saveSeance(s),
                    HttpStatus.OK);
        else
            return new ResponseEntity<>(s,
                    HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeanceById(@PathVariable Long id) {
        this.seanceService.deleteSeanceById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}