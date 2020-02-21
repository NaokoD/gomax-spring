package com.gomax.controllers;

import com.gomax.entities.Commande;
import com.gomax.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@CrossOrigin(origins = "http://localhost:4200")
public class CommandeController {

    private CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService){
        this.commandeService = commandeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Commande>> getCommandes(@RequestParam (required = false) Long seanceId){
        if(seanceId == null || seanceId.equals("")) {
            return this.getAllCommandes();
        }else{
            return this.getCommandesBySeanceId(seanceId);
        }
    }

    public ResponseEntity<List<Commande>> getAllCommandes(){
        return new ResponseEntity<>(this.commandeService.findAllCommandes(), HttpStatus.OK);
    }

    public ResponseEntity<List<Commande>> getCommandesBySeanceId(Long seanceId){
        return new ResponseEntity<>(this.commandeService.findAllCommandesBySeanceId(seanceId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id){
        return new ResponseEntity<>(this.commandeService.findCommandeById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Commande> postCommande(@RequestBody Commande commande){
        System.out.println(commande);
        return new ResponseEntity<>(this.commandeService.saveCommande(commande), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Commande> putCommande(@RequestBody Commande c){
        return new ResponseEntity<>(this.commandeService.saveCommande(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCommandeById(@PathVariable Long id){
        return new ResponseEntity<>(this.commandeService.deleteCommandeById(id), HttpStatus.OK);
    }

}
