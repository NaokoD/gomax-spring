package com.gomax.controllers;

import com.gomax.entities.Cinema;
import com.gomax.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private CinemaService cinemaService;

    @Autowired
    CinemaController(CinemaService cinemaService){
        this.cinemaService = cinemaService;
    }

    @GetMapping("")
    public ResponseEntity<List<Cinema>> getAllCinemas(){
        return new ResponseEntity<>(this.cinemaService.findAllCinemas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable Long id){
        return new ResponseEntity<>(this.cinemaService.findCinemaById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Cinema> postCinema(@RequestBody Cinema cinema){
        return new ResponseEntity<>(this.cinemaService.saveCinema(cinema), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Cinema> putCinema(@RequestBody Cinema cinema){
        return new ResponseEntity<>(this.cinemaService.saveCinema(cinema), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCinemaById(@PathVariable Long id){
        return new ResponseEntity<>(this.cinemaService.deleteCinemaById(id), HttpStatus.OK);
    }
}
