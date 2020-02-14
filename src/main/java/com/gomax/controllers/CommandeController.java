package com.gomax.controllers;

import com.gomax.entities.Commande;
import com.gomax.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService){
        this.commandeService = commandeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Commande>> getAllCommandes(){

        return new ResponseEntity<>(this.commandeService.findAllCommandes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id){
        return new ResponseEntity<>(this.commandeService.findCommandeById(id).get(), HttpStatus.OK);
    }

    @PostMapping(path = "", consumes = "application/json")
/*    public ResponseEntity<String> postCommande(@RequestBody Commande c){
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }*/
    public ResponseEntity<Commande> postCommande(@RequestBody Commande c){
        System.out.println(c);
        return new ResponseEntity<>(this.commandeService.saveCommande(c), HttpStatus.CREATED);
    }

}
