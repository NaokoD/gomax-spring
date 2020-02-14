package com.gomax.services;

import com.gomax.entities.Commande;
import com.gomax.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    private CommandeRepository commandeRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository){
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> findAllCommandes(){
        return (List<Commande>) this.commandeRepository.findAll();
    }

    public Optional<Commande> findCommandeById(Long id){
        return this.commandeRepository.findById(id);
    }

    public Commande saveCommande(Commande commande){
        System.out.println(commande);
        commande.setDateDeCreation(LocalDateTime.now());
        return this.commandeRepository.save(commande);
    }
}
