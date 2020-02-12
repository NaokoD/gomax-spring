package com.gomax.services;


import com.gomax.entities.Horaire;
import com.gomax.repositories.HoraireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoraireService {

    private HoraireRepo horaireRepo;

    @Autowired
    public HoraireService(HoraireRepo horaireRepo) {
        this.horaireRepo = horaireRepo;
    }

    public List<Horaire> findAllHoraires() {

        return (List<Horaire>) horaireRepo.findAll();
    }

    public Optional<Horaire> findHoraireById(Long id) {
        // use Optional
        return this.horaireRepo.findById(id);
    }

    public Horaire saveHoraire(Horaire h) {
        return this.horaireRepo.save(h);
    }

    public void deleteHoraireById(Long id) {
        this.horaireRepo.deleteById(id);
    }

    public boolean existsHoraireById(Long id) {
        return this.horaireRepo.existsById(id);
    }
}