package com.gomax.controllers;

import com.gomax.entities.Siege;
import com.gomax.services.SiegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sieges")
@CrossOrigin(origins = "http://localhost:4200")
public class SiegeController {

    private SiegeService siegeService;

    @Autowired
    public SiegeController(SiegeService siegeService){
        this.siegeService = siegeService;
    }

    @GetMapping("")
    public ResponseEntity<? extends Collection<Siege>> getSieges(@RequestParam(required = false) Long commandeId){
        if(commandeId == null || commandeId.equals("")) {
            return new ResponseEntity<List<Siege>>(this.siegeService.findAllSieges(), HttpStatus.OK);
        }else{
            return new ResponseEntity<Set<Siege>>(this.siegeService.findSiegesByCommande(commandeId), HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<Siege> postSiege(@RequestBody Siege siege){
        return new ResponseEntity<>(this.siegeService.saveSiege(siege), HttpStatus.CREATED);
    }

    @GetMapping("/commandes")
    public ResponseEntity<Set<Siege>> getSiegesInCommandes(){
        return new ResponseEntity<>(this.siegeService.finSiegesInCommande(), HttpStatus.OK);
    }

    @GetMapping("/seances/{id}")
    public ResponseEntity<Set<Siege>> getSiegesInSeances(@PathVariable Long id){
        return new ResponseEntity<>(this.siegeService.findSiegesBySeance(id), HttpStatus.OK);
    }
}
