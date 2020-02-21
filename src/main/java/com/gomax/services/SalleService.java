package com.gomax.services;

import com.gomax.entities.Salle;
import com.gomax.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {

    private SalleRepository salleRepository;

    @Autowired
    public SalleService(SalleRepository salleRepository){
        this.salleRepository = salleRepository;
    }

    public List<Salle> findAllSalles(){
        return (List<Salle>) this.salleRepository.findAll();
    }

    public Optional<Salle> findSalleById(Long id){
        return this.salleRepository.findById(id);
    }

    public Boolean deleteSalleById(Long id) {
        this.salleRepository.deleteById(id);
        return this.salleRepository.existsById(id);
    }

    public Salle saveSalle(Salle salle){
        return this.salleRepository.save(salle);
    }


}
