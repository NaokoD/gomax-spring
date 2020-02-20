package com.gomax.controllers;

import com.gomax.entities.Accompagnant;
import com.gomax.services.AccompagnantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accompagnants")
public class AccompagnantController {
    private AccompagnantService accompagnantService;

    @Autowired
    public AccompagnantController(AccompagnantService accompagnantService){
        this.accompagnantService = accompagnantService;
    }

    @GetMapping("")
    public ResponseEntity<List<Accompagnant>> getAccompagnants(){
        return new ResponseEntity<>(this.accompagnantService.findAllAccompagnants(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Accompagnant> postAccompagnant(@RequestBody  Accompagnant accompagnant){
        return new ResponseEntity<>(this.accompagnantService.saveAccompagnant(accompagnant), HttpStatus.CREATED);
    }
}
