package com.gomax.controllers;

import com.gomax.entities.Salle;
import com.gomax.repositories.SalleRepository;
import com.gomax.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService){
        this.salleService = salleService;
    }

    @GetMapping("")
    public ResponseEntity<List<Salle>> getAllSalle(){
        return new ResponseEntity<>(this.salleService.findAllSalles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salle> getSalleById(@PathVariable Long id){
        return new ResponseEntity<>(this.salleService.findSalleById(id).get(), HttpStatus.OK);
    }

}
