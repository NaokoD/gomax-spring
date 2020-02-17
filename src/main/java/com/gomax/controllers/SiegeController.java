package com.gomax.controllers;

import com.gomax.entities.Siege;
import com.gomax.services.SiegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sieges")
public class SiegeController {

    private SiegeService siegeService;

    @Autowired
    public SiegeController(SiegeService siegeService){
        this.siegeService = siegeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Siege>> getSieges(@RequestParam(required = false) Long commandeId){
        if(commandeId == null || commandeId.equals("")) {
            return new ResponseEntity<>(this.siegeService.findAllSieges(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(this.siegeService.findSiegesByCommande(commandeId), HttpStatus.OK);
        }
    }
}
