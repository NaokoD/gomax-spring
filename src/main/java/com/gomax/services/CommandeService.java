package com.gomax.services;

import com.gomax.entities.Commande;
import com.gomax.entities.Seance;
import com.gomax.entities.Siege;
import com.gomax.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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

    public Boolean deleteCommandeById(Long id){
        this.commandeRepository.deleteById(id);
        return this.commandeRepository.existsById(id);
    }

    public List<Commande> findAllCommandesBySeanceId(Long seanceId){
        Seance seance = new Seance();
        seance.setId(seanceId);
        return this.commandeRepository.findCommandesBySeance(seance);
    }

    public Set<Siege> findOccupiedSeatBySeance(Long seanceId){
        List<Commande> commandes = this.findAllCommandesBySeanceId(seanceId);
        Set<Siege> sieges = new HashSet<>();
        for(Commande commande : commandes){
            if(!commande.getSieges().isEmpty()){
                for(Siege siege : commande.getSieges()){
                    sieges.add(siege);
                }
            }
        }
        return sieges;
    }
}
