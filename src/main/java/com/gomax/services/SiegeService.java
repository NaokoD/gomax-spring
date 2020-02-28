package com.gomax.services;

import com.gomax.entities.Commande;
import com.gomax.entities.Siege;
import com.gomax.repositories.SiegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SiegeService {

    private SiegeRepository siegeRepository;

    @Autowired
    public SiegeService(SiegeRepository siegeRepository){
        this.siegeRepository= siegeRepository;
    }

    /*public Set<Siege> findOccupiedSeatBySeance(Long seanceId){
        List<Commande> commandes = CommandeService.findAllCommandesBySeanceId(seanceId);
        Set<Siege> sieges = new HashSet<Siege>();
        for(Commande commande : commandes){
            if(!commande.getSieges().isEmpty()){
                for(Siege siege : commande.getSieges()){
                    sieges.add(siege);
                }
            }
        }
        return sieges;
    }*/

    public Set<Siege> findSiegesByCommande(Long commandeId){
        Commande commande = new Commande();
        commande.setId(commandeId);
        return this.siegeRepository.findByCommandes(commande);
    }

    public List<Siege> findAllSieges() {
        return (List<Siege>) this.siegeRepository.findAll();
    }

    public Siege saveSiege(Siege siege){
        return this.siegeRepository.save(siege);
    }

    public Set<Siege> findSiegesBySeance(Long seanceId){
        return this.siegeRepository.findBySeance(seanceId);
    }

    public Set<Siege> finSiegesInCommande() {
        return this.siegeRepository.findSiegesInCommande();
    }
}
