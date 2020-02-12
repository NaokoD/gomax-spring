package com.gomax.controllers;

import com.gomax.entities.Categorie;
import com.gomax.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }


    @GetMapping("")
    public ResponseEntity<List<Categorie>> getCategories() {
        return new ResponseEntity<>(this.categorieService.findAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Long id) {
        return new ResponseEntity<>(this.categorieService.findCategorieById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Categorie> postCategorie(@RequestBody Categorie c) {
        return new ResponseEntity<>(this.categorieService.saveCategorie(c),
                HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Categorie> putFilm(@RequestBody Categorie c) {
        if (this.categorieService.existsCategorieById(c.getId()))
            return new ResponseEntity<>(this.categorieService.saveCategorie(c),
                    HttpStatus.OK);
        else
            return new ResponseEntity<>(c,
                    HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorieById(@PathVariable Long id) {
        this.categorieService.deleteCategorieById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}