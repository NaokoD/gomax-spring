package com.gomax.services;

import com.gomax.entities.Accompagnant;
import com.gomax.repositories.AccompagnantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccompagnantService {
    private AccompagnantRepository accompagnantRepository;

    @Autowired
    public AccompagnantService(AccompagnantRepository accompagnantRepository){
        this.accompagnantRepository = accompagnantRepository;
    }

    public List<Accompagnant> findAllAccompagnants(){
        return (List<Accompagnant>) this.accompagnantRepository.findAll();
    }

    public Optional<Accompagnant> findAccompagnantById(Long id){
        return this.accompagnantRepository.findById(id);
    }

    public Accompagnant saveAccompagnant(Accompagnant accompagnant) {
        return this.accompagnantRepository.save(accompagnant);
    }

    public Boolean deleteById(Long id){
        this.accompagnantRepository.deleteById(id);
        return this.accompagnantRepository.existsById(id);
    }
}
